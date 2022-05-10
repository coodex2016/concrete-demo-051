package org.coodex.concrete.demo.api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Description;
import org.coodex.concrete.demo.pojo.CarInfo;

@ConcreteService
public interface ErrorCodeService {

    @Description(name = "无配置")
    void noneAnnotation();

    @Description(name = "使用Template注解")
    void templateAnnotation();

    @Description(name = "freeMarker模板")
    void freeMarker(CarInfo carInfo);
}
