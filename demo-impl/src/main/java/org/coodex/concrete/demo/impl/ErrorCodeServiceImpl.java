package org.coodex.concrete.demo.impl;

import org.coodex.concrete.common.ConcreteException;
import org.coodex.concrete.common.IF;
import org.coodex.concrete.demo.api.ErrorCodeService;
import org.coodex.concrete.demo.pojo.CarInfo;

import javax.inject.Named;

import static org.coodex.concrete.demo.api.DemoErrorCodes.*;

@Named
public class ErrorCodeServiceImpl implements ErrorCodeService {

    @Override
    public void noneAnnotation() {
        throw new ConcreteException(NONE_ANNOTATION);
    }

    @Override
    public void templateAnnotation() {
        throw new ConcreteException(TEMPLATE_ANNOTATION, "11111");
    }

    @Override
    public void freeMarker(CarInfo carInfo) {
        throw new ConcreteException(
                FREE_MARKER_EXAMPLE,// 使用下面返回的carInfo作为模板渲染的参数
                IF.isNull(carInfo, NOT_EXISTS)// 当carInfo为空时，走NOT_EXISTS异常，否则返回carInfo
        );
    }
}
