package org.coodex.concrete.demo.boot;

import org.coodex.concrete.message.Queue;
import org.coodex.concrete.message.Subscription;
import org.coodex.concrete.message.Topic;
import org.coodex.concrete.message.Topics;
import org.coodex.util.GenericTypeHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.inject.Inject;

@SpringBootApplication
public class TopicExample {

    public static class TopicDemo {
        @Inject
        @Queue("队列1")
        private Topic<String> topic1;
        @Inject
        @Queue("队列2")
        private Topic<String> topic2;

        public Topic<String> getTopic1() {
            return topic1;
        }

        // 等同于topic1
        public Topic<String> getTopic1UseApi() {
            return Topics.get(new GenericTypeHelper.GenericType<Topic<String>>() {
            }.getType(), "队列1");
        }

        public Topic<String> getTopic2() {
            return topic2;
        }
    }

    @Bean
    public TopicDemo getTopicDemo() {
        return new TopicDemo();
    }

    private static void topicDemo(Topic<String> topic, String message) {
        // 0 订阅的情况
        topic.publish(message + ".1");
        // 订阅1
        Subscription subscription1 = topic.subscribe(t -> {
            System.out.println("subscribe1: " + t);
        });
        topic.publish(message + ".2");
        // 这时候应该会显示subscribe1收到消息
        // 订阅2
        Subscription subscription2 = topic.subscribe(t -> {
            System.out.println("subscribe2: " + t);
        });
        topic.publish(message + ".3");
        // 这时候应该显示订阅1和2都收到了消息
        subscription1.cancel();
        topic.publish(message + ".4");
        // 订阅1已经取消了订阅，所以这时候应该显示订阅2收到了消息
        subscription2.cancel();
        topic.publish(message + ".5");
        // 这时候所有订阅都取消了，所以不显示消息
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TopicExample.class);
        TopicDemo demo = context.getBean(TopicDemo.class);

        topicDemo(demo.getTopic1(), "注入: 队列1");
        topicDemo(demo.getTopic1UseApi(), "原始API: 队列1");
        topicDemo(demo.getTopic2(), "注入: 队列2");


    }
}
