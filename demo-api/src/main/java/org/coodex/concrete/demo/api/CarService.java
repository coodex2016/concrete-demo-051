package org.coodex.concrete.demo.api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Description;
import org.coodex.concrete.demo.pojo.CarInfo;
import org.coodex.mock.Mock;
import org.coodex.mock.ext.VehicleNum;
import org.coodex.util.Parameter;

@ConcreteService("cars")
@Description(name = "车辆资源服务", description = "文档化示例")
public interface CarService {

    @ConcreteService("/{id}/PlateCode")
    @VehicleNum
    @Description(name = "获取车牌号", description = "根据一辆车的id获取它车牌号")
    String getCarNumberById(
            @Description(name = "车辆id")
            @Mock.String
            @Parameter("id")
            String id);

    @ConcreteService("/{id}")
    @Description(name = "获取一辆车的信息", description = "数据包括车牌号车牌颜色等")
    CarInfo getCarById(
            @Description(name = "车辆id")
            @Mock.String
            @Parameter("id")
            String id);

    @Deprecated
    @Mock.Number("[3,9]")
    Integer warningExample();
}