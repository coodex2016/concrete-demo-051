package org.coodex.concrete.demo.api;

import org.coodex.concrete.apitools.API;

import java.io.IOException;

public class DocGenerator {
    public static void main(String[] args) throws IOException {
        // 第一个参数说明使用哪个profile, api_gen.第一个参数
        API.generateFor("gitbook", "org.coodex.concrete.demo.**.api");
        API.generateFor("vuepress", "org.coodex.concrete.demo.**.api");
    }
}
