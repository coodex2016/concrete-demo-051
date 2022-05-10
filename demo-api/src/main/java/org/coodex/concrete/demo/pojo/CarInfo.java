package org.coodex.concrete.demo.pojo;

import lombok.Data;
import org.coodex.concrete.api.Description;
import org.coodex.mock.Mock;
import org.coodex.mock.ext.FullName;
import org.coodex.mock.ext.IdCard;
import org.coodex.mock.ext.VehicleNum;

@Data
public class CarInfo {
    @VehicleNum
    @Description(name = "车牌号码")
    private String plateCode;
    @Mock.Number("[0,4],9")
    @Description(name = "车牌颜色", description = "按照国标定义")
    private Integer plateColor;

    @Description(name = "车主姓名")
    @FullName
    private String ownerName;
    @Description(name = "车主身份证号")
    @IdCard
    private String idCard;

    @Description(name = "车辆品牌")
    @Mock.String(range = {"兰博基尼", "玛莎拉蒂", "奔驰", "宾利", "Audi", "BMW"})
    private String brand;
}
