package org.coodex.concrete.demo.impl;

import lombok.extern.slf4j.Slf4j;
import org.coodex.concrete.core.signature.SignUtil;
import org.coodex.concrete.demo.api.excepted.DemoSignatureService;
import org.coodex.concrete.demo.pojo.ExamplePojo;

import javax.inject.Named;

@Named
@Slf4j
public class DemoSignatureServiceImpl implements DemoSignatureService {
    @Override
    public void doSomeThing(Integer a, String kkk, ExamplePojo pojo) {
        log.info("client keyId: {}, alg: {}, noise: {}, sign: {}",
                SignUtil.getKeyId(),
                SignUtil.getAlgorithm(),
                SignUtil.getNoise(),
                SignUtil.getSign());
    }
}