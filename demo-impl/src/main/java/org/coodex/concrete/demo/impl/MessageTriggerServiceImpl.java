package org.coodex.concrete.demo.impl;

import org.coodex.concrete.demo.api.excepted.MessageTriggerService;
import org.coodex.concrete.message.Queue;
import org.coodex.concrete.message.Topic;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MessageTriggerServiceImpl implements MessageTriggerService {

    // 定义一个主题，主题由主题类型，消息类型，队列三部分共同确定
    @Inject
    @Queue("demo")
    private Topic<String> topic;

    @Override
    public void trigger(String msg) {
        topic.publish(msg);// 使用这个主题发布一个消息
    }
}