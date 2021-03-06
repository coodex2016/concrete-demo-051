'use strict';

(function (factory) {
    if (typeof exports === "object" && typeof module === "object") // CommonJS
        module.exports = factory(require('jquery'));
    else if (typeof define === "function" && define.amd) // AMD
        define(['jquery'], factory);
    else { // Plain browser env
        var self = this || window;
        self.concrete = factory(self.$, self);
    }
}(function ($, self) {


    /**
     * 根据方法参数数量重载方法
     * @param funcName
     * @param function_map
     * @returns {Function}
     */
    var overload = function (funcName, function_map) {

        return function () {
            var key = arguments.length.toString();
            var func = function_map[key];
            if (!func && typeof func !== "function") {
                throw new Error(
                    "not found function: " + funcName + " with " + key + " parameter(s).");
            }
            return func.apply(this, arguments);
        }
    };

    var default_configuration = {
        "root": "",
        "pollingTimeout": 10,
        "onError": function (code, msg) {
            alert("errorCode:" + code + "\nerrorMsg:" + msg);
        },
        "onBroadcast": function (msgId, host, subject, data) {
            console.log(data);
        }
    };


    var configuration = default_configuration;

    var encode = function (any) {
        if (any === undefined || any === null)
            return "";
        else
            return encodeURIComponent(any.toString());
    }

    var localTokenId = null;

    var getTokenId = function(){
        return (configuration.globalTokenKey ?
            localStorage.getItem(configuration.globalTokenKey) : null) || localTokenId;
    }

    var setTokenId = function(tokenId){
        if(!tokenId) return;
        localTokenId = tokenId;
        if(configuration.globalTokenKey){
            localStorage.setItem(configuration.globalTokenKey, tokenId);
        }
    }

    var invoke = function (executable) {
        if (executable) {
            var pathNodes = executable.path.split("/");
            var url = "";
            var param = $.extend({}, executable.param);
            for (var i = 0; i < pathNodes.length; i++) {
                var node = pathNodes[i];
                if (!node && node.trim() === "") continue;
                if (node.charAt(0) === "{") {
                    var key = node.substr(1, node.length - 2);
                    node = param[key];
                    delete param[key];
                }
                url += "/" + encode(node);
            }

            var data = {};
            if (Object.keys(param).length > 0) {
                var obj = Object.keys(param).length === 1 ? param[Object.keys(param)[0]] : param;
                data = {
                    data: typeof(obj) === 'string' ? obj : JSON.stringify(obj)
                }
            }

            var headers = {
                'X-CLIENT-PROVIDER': 'CONCRETE-jQuery',
                'Cache-Control': 'no-cache, no-store'
            };

            var tokenId = getTokenId();
            if(tokenId)headers["CONCRETE-TOKEN-ID"] = tokenId;

            return $.ajax($.extend({}, data, {
                url: configuration.root + url,
                type: executable.method,
                contentType: "application/json; charset=utf-8",
                dataType: executable.dataType,
                headers: headers,
                crossDomain: true,
                xhrFields: {
                    withCredentials: true
                },
                success: function(data, textStatus, request){
                    setTokenId(request.getResponseHeader('CONCRETE-TOKEN-ID'));
                }
            })).fail(function (jx) {
                if (configuration.onError) {
                    var e = jx.responseJSON;
                    if(typeof e === "object"){
                        configuration.onError(e.code,e.msg);
                    } else {
                        configuration.onError(jx.status, jx.responseText);
                    }
                                        // configuration.onError(this, arguments);
                }
            });
        } else {
            throw new Error("executable object is null.");
        }
    };

    var modules = {};

    var clean = function (fullName) {
        var nodes = fullName.split(".");
        var result = undefined;
        for (var i = 0; i < nodes.length; i++) {
            if (nodes[i] && nodes[i].trim() !== "") {
                if (result) {
                    result = result + "." + nodes[i];
                } else {
                    result = nodes[i];
                }
            }
        }
        return result;
    };

    var parseModule = function (fullName) {
        var packageName = undefined;
        var nodes = clean(fullName).split(".");
        for (var i = 0; i < nodes.length - 1; i++) {
            if (packageName) {
                packageName += "." + nodes[i];
            } else {
                packageName = nodes[i];
            }
        }
        return {
            "package": packageName,
            "module": nodes[nodes.length - 1]
        }
    };



    var concrete = {
        "polling": function(){
            try{
                if(!this.pollingStart){
                    var pollingModule = this.module("org.coodex.concrete.jaxrs.Polling");
                    var self = this;
                    var pollingFunc = function(){
                        if(!self.pollingStart) return;
                        pollingModule.polling(configuration.pollingTimeout).done(function(messages){
                            if(configuration.onBroadcast && messages && messages.length > 0){
                                for(var i = 0; i < messages.length; i ++){
                                    var msg = messages[i];
                                    try{
                                        configuration.onBroadcast(msg.id, msg.host, msg.subject, msg.body);
                                    }catch(e){}
                                }
                            }
                            setTimeout(pollingFunc, 10);
                        }).error(function(){
                            this.pollingStart = false;
                        })
                    }
                    this.pollingStart = true;
                    pollingFunc();
                }
            }catch(e){}
        },
        "configure": function (config) {
            configuration = $.extend({}, default_configuration, config);
        },
        "module": function () {
            if (arguments.length == 0 || arguments.length > 2) {
                throw new Error("IllegalArgument, arguments must (moduleName) or (package.moduleName) or (moduleName, package).");
            }
            var fullName = arguments.length === 1 ? arguments[0] : (arguments[1] + "." + arguments[0]);
            var info = parseModule(fullName);
            var m = modules[info.module];
            var module = undefined;
            if (m) {
                if (info.package) {
                    module = m[info.package];
                } else {
                    if (Object.keys(m).length === 1) {
                        module = m[Object.keys(m)[0]];
                    }
                }
            }

            if (module)
                return module;

            throw new Error("No module found. " + fullName);
        }
    };


    /**
     * 注册一个模块，由代码生成器调用
     * @param moduleName 模块名，既Interface的ClassName
     * @param packageName 包名，既Interface的packageName
     * @param module 该模块的所有方法
     */
    var register = function (moduleName, packageName, module) {
        if (!modules[moduleName]) {
            modules[moduleName] = {};
        }
        modules[moduleName][packageName] = module;
    };

    register("DemoLoginService", "org.coodex.concrete.demo.api.excepted", { "login": function (id) {return invoke({"path": "/OrgCoodexConcreteDemoApiExceptedDemoLoginService/login","param": {"id": id},"method": "POST", "dataType": "json" });}});

    register("MessageTriggerService", "org.coodex.concrete.demo.api.excepted", { "trigger": function (msg) {return invoke({"path": "/OrgCoodexConcreteDemoApiExceptedMessageTriggerService/trigger","param": {"msg": msg},"method": "POST", "dataType": "json" });}});

    register("AddWithIn10Service", "org.coodex.concrete.demo.api", { "add": function (x1, x2) {return invoke({"path": "/OrgCoodexConcreteDemoApiAddWithIn10Service/add","param": {"x1": x1, "x2": x2},"method": "POST", "dataType": "json" });}});

    register("LibraryB", "org.coodex.concrete.demo.api.excepted", { "sort": function () {return invoke({"path": "/B/Books/sort","param": {},"method": "GET", "dataType": "json" });}, "delete": function (name) {return invoke({"path": "/B/Books/{name}","param": {"name": name},"method": "DELETE", "dataType": "json" });}});

    register("TokenDemoService", "org.coodex.concrete.demo.api", { "setTokenValue": function (value) {return invoke({"path": "/OrgCoodexConcreteDemoApiTokenDemoService/tokenValue","param": {"value": value},"method": "PUT", "dataType": "json" });}, "getTokenValue": function () {return invoke({"path": "/OrgCoodexConcreteDemoApiTokenDemoService/tokenValue","param": {},"method": "GET", "dataType": "text" });}});

    register("LibraryA", "org.coodex.concrete.demo.api.excepted", { "sort": function () {return invoke({"path": "/A/Books/sort","param": {},"method": "GET", "dataType": "json" });}, "delete": function (name) {return invoke({"path": "/A/Books/{name}","param": {"name": name},"method": "DELETE", "dataType": "json" });}});

    register("TimeLimitedService", "org.coodex.concrete.demo.api", { "lunch": function () {return invoke({"path": "/OrgCoodexConcreteDemoApiTimeLimitedService/lunch","param": {},"method": "GET", "dataType": "json" });}, "work": function () {return invoke({"path": "/OrgCoodexConcreteDemoApiTimeLimitedService/work","param": {},"method": "GET", "dataType": "json" });}, "breakfast": function () {return invoke({"path": "/OrgCoodexConcreteDemoApiTimeLimitedService/breakfast","param": {},"method": "GET", "dataType": "json" });}, "dinner": function () {return invoke({"path": "/OrgCoodexConcreteDemoApiTimeLimitedService/dinner","param": {},"method": "GET", "dataType": "json" });}});

    register("SubjoinExampleService", "org.coodex.concrete.demo.api", { "add": function (x1, x2) {return invoke({"path": "/SubjoinExample/add","param": {"x1": x1, "x2": x2},"method": "POST", "dataType": "json" });}, "sayHello": function (name) {return invoke({"path": "/SubjoinExample/sayHello","param": {"name": name},"method": "POST", "dataType": "text" });}});

    register("DemoSignatureService", "org.coodex.concrete.demo.api.excepted", { "doSomeThing": function (a, kkk, pojo) {return invoke({"path": "/OrgCoodexConcreteDemoApiExceptedDemoSignatureService/doSomeThing","param": {"a": a, "kkk": kkk, "pojo": pojo},"method": "POST", "dataType": "json" });}});

    register("ErrorCodeService", "org.coodex.concrete.demo.api", { "templateAnnotation": function () {return invoke({"path": "/OrgCoodexConcreteDemoApiErrorCodeService/templateAnnotation","param": {},"method": "GET", "dataType": "json" });}, "noneAnnotation": function () {return invoke({"path": "/OrgCoodexConcreteDemoApiErrorCodeService/noneAnnotation","param": {},"method": "GET", "dataType": "json" });}, "freeMarker": function (arg0) {return invoke({"path": "/OrgCoodexConcreteDemoApiErrorCodeService/freeMarker","param": {"arg0": arg0},"method": "POST", "dataType": "json" });}});

    register("LimitingService", "org.coodex.concrete.demo.api.excepted", { "demoMaximumConcurrency": function () {return invoke({"path": "/OrgCoodexConcreteDemoApiExceptedLimitingService/demoMaximumConcurrency","param": {},"method": "GET", "dataType": "json" });}, "demoTokenBucket": function () {return invoke({"path": "/OrgCoodexConcreteDemoApiExceptedLimitingService/demoTokenBucket","param": {},"method": "GET", "dataType": "json" });}});

    register("AddService", "org.coodex.concrete.demo.api", { "add": function (x1, x2) {return invoke({"path": "/Calculator/add","param": {"x1": x1, "x2": x2},"method": "POST", "dataType": "json" });}});

    register("CarService", "org.coodex.concrete.demo.api", { "warningExample": function () {return invoke({"path": "/Cars/warningExample","param": {},"method": "GET", "dataType": "json" });}, "getCarById": function (id) {return invoke({"path": "/Cars/{id}","param": {"id": id},"method": "GET", "dataType": "json" });}, "getCarNumberById": function (id) {return invoke({"path": "/Cars/{id}/PlateCode","param": {"id": id},"method": "GET", "dataType": "text" });}});

    if(self){
        self.concrete = concrete;
    }
    return concrete;

}));