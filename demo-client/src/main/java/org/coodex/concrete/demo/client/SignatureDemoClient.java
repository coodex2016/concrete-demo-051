package org.coodex.concrete.demo.client;

import org.coodex.concrete.Client;
import org.coodex.concrete.demo.api.excepted.DemoSignatureService;
import org.coodex.concrete.demo.pojo.ExamplePojo;

public class SignatureDemoClient {

    public static void main(String[] args) {
        DemoSignatureService demoSignatureService = Client.getInstance(DemoSignatureService.class, "demoModule");
        demoSignatureService.doSomeThing(1, "kkk", new ExamplePojo());
    }
}