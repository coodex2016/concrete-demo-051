package org.coodex.concrete.demo.api;

import org.coodex.concrete.apitools.API;

import java.io.IOException;

public class CodeGenerator {

    public static void main(String[] args) throws IOException {
        API.generateFor("jquery", "org.coodex.concrete.demo.**.api");
        API.generateFor("axios", "org.coodex.concrete.demo.**.api");
        API.generateFor("angular", "org.coodex.concrete.demo.**.api");
    }

}
