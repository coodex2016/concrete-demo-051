package org.coodex.concrete.demo.pojo;

public class BookB extends Book {
    private String type = "理工类";

    public BookB() {
    }

    public BookB(String name, String code) {
        super(name, code);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
