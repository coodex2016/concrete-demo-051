package org.coodex.concrete.demo.pojo;

public class BookA extends Book {

    public BookA() {
    }

    private String type = "文史类";

    public BookA(String name, String code) {
        super(name, code);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
