package org.coodex.concrete.demo.api;

import org.coodex.concrete.api.ErrorCode;

import static org.coodex.concrete.common.ErrorCodeConstants.CUSTOM_LOWER_BOUND;

@ErrorCode("demo")// 声明此类型是错误码定义，相关定义的命名空间为demo
public class DemoErrorCodes {
    protected static final int DEMO_BASED = CUSTOM_LOWER_BOUND + 5000;

    @ErrorCode.Key("too_hard")// 指明消息模板的key为 demo(命名空间).too_hard
    public static final int TOO_HARD = DEMO_BASED + 1;

    // 不指定注解，则表示使用 命名空间.错误码 作为模板key
    public static final int NONE_ANNOTATION = DEMO_BASED + 2;

    @ErrorCode.Key("not_exists")
    public static final int NOT_EXISTS = DEMO_BASED + 3;

    @ErrorCode.Template("使用模板注解的例子，参数为: {0}")
    public static final int TEMPLATE_ANNOTATION = DEMO_BASED + 4;

    @ErrorCode.Template("使用freeMarker的例子: ${o1.ownerName} 驾驶着 ${o1.plateCode} 跑过去了")
    public static final int FREE_MARKER_EXAMPLE = DEMO_BASED + 5;
}
