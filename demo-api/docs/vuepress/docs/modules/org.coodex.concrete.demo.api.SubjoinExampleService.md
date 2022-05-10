# /SubjoinExample

* **模块名称：** /SubjoinExample
* **模块定义：** org.coodex.concrete.demo.api.SubjoinExampleService




## <span id="m1">向某人say hello</span>

当此人为第一次访问时，我们通过subjoin返回新用户的信息


* **method name:** sayHello
* **path:** /SubjoinExample/sayHello
* **Http Method:** POST
* **acl:** Anonymous
* **return:** String
* **params:** 

| ParamName | Method | Label | Type                  | Description |
| --------- | -- | ---- | --------------------- | ------------ |
| name | POST |  | String | 　 |

::: details 点击查看示意数据


```
Dkhc99z3GIk
```


:::

## <span id="m2">由开发者手动设置warning data的示例</span>

同之前的案例一样，不过把异常改为警告，当加数和被加数不是个位数时，向调用者发送一个太难了的警告


* **method name:** add
* **path:** /SubjoinExample/add
* **Http Method:** POST
* **acl:** Anonymous
* **return:** Integer
* **params:** 

| ParamName | Method | Label | Type                  | Description |
| --------- | -- | ---- | --------------------- | ------------ |
| x1 | POST |  | Integer | 　 |
| x2 | POST |  | Integer | 　 |

::: details 点击查看示意数据

```json
871980419
```


:::

