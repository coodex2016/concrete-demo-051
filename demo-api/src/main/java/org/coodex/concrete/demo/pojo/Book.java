package org.coodex.concrete.demo.pojo;

public abstract class Book {

    private String name;
    private String code;

    public Book() {
    }

    public Book(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public abstract String getType();

    public abstract void setType(String type);

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }
}
