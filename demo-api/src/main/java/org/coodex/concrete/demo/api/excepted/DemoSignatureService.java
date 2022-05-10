package org.coodex.concrete.demo.api.excepted;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Signable;
import org.coodex.concrete.demo.pojo.ExamplePojo;
import org.coodex.util.Parameter;

@Signable // 声明这个服务需要签名，也可以作用在服务接口上
@ConcreteService
public interface DemoSignatureService {

    void doSomeThing(@Parameter("a") Integer a,
                     @Parameter("kkk") String kkk,
                     @Parameter("pojo") ExamplePojo pojo);
}