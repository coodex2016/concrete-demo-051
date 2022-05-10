# 车辆资源服务

* **模块名称：** /Cars
* **模块定义：** org.coodex.concrete.demo.api.CarService


文档化示例

## <span id="m1">~~/warningExample~~</span>




* **method name:** warningExample
* **path:** /Cars/warningExample
* **Http Method:** GET
* **acl:** Anonymous
* **return:** Integer
* **params:** NONE

::: details 点击查看示意数据

```json
3
```


:::

## <span id="m2">获取车牌号</span>

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

::: details 点击查看示意数据


```
黑M35S1Q
```


:::

## <span id="m3">获取一辆车的信息</span>

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

::: details 点击查看示意数据

```json
{
	"brand":"宾利",
	"idCard":"320723201308235462",
	"ownerName":"饶獭",
	"plateCode":"京A7V916",
	"plateColor":2
}
```


:::

