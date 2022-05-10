package org.coodex.concrete.demo.impl;

import org.coodex.concrete.demo.api.AddService;

import javax.inject.Named;

@Named//inject规范
public class AddServiceImpl implements AddService {

    @Override
    public int add(int x1, int x2) {
        return x1 + x2;
    }
}