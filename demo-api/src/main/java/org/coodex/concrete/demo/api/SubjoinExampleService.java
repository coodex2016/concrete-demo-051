package org.coodex.concrete.demo.api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Description;
import org.coodex.mock.Mock;
import org.coodex.mock.ext.FullName;
import org.coodex.util.Parameter;

@ConcreteService("SubjoinExample")
public interface SubjoinExampleService {

    @Description(name = "向某人say hello",
            description = "当此人为第一次访问时，我们通过subjoin返回新用户的信息")
    String sayHello(
            @FullName // 在swagger中生成一个姓名的样例数据
            @Parameter("name")
            String name);

    @Description(name = "由开发者手动设置warning data的示例",
            description = "同之前的案例一样，不过把异常改为警告，当加数和被加数不是个位数时，向调用者发送一个太难了的警告")
    Integer add(
            @Mock.Number("[0,20]")
            @Parameter("x1")
            Integer x1,
            @Mock.Number("[0,20]")
            @Parameter("x2")
            Integer x2);
}