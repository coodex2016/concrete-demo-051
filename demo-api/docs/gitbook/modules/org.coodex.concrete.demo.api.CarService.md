# 车辆资源服务

* **模块名称：** /Cars
* **模块定义：** org.coodex.concrete.demo.api.CarService


文档化示例

## 接口
### <span id="m1">~~/warningExample~~</span>




* **method name:** warningExample
* **path:** /Cars/warningExample
* **Http Method:** GET
* **acl:** Anonymous
* **return:** Integer
* **params:** NONE

- **example result**:
```json
3
```



### <span id="m2">获取车牌号</span>

根据一辆车的id获取它车牌号


* **method name:** getCarNumberById
* **path:** /Cars/{id}/PlateCode
* **Http Method:** GET
* **acl:** Anonymous
* **return:** String
* **params:** 

| ParamName | Method | Label | Type                  | Description |
| --------- | -- | ---- | --------------------- | ------------ |
| - |  | 车辆id | String | 　 |

- **example result**:

```
琼B11211
```



### <span id="m3">获取一辆车的信息</span>

数据包括车牌号车牌颜色等


* **method name:** getCarById
* **path:** /Cars/{id}
* **Http Method:** GET
* **acl:** Anonymous
* **return:** [CarInfo](../pojos/org.coodex.concrete.demo.pojo.CarInfo.md)
* **params:** 

| ParamName | Method | Label | Type                  | Description |
| --------- | -- | ---- | --------------------- | ------------ |
| - |  | 车辆id | String | 　 |

- **example result**:
```json
{
	"brand":"奔驰",
	"idCard":"520621201405267780",
	"ownerName":"贾呐欢",
	"plateCode":"青E6F52Q",
	"plateColor":3
}
```



