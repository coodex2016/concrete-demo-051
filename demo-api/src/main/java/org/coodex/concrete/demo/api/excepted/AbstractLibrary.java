package org.coodex.concrete.demo.api.excepted;

import org.coodex.concrete.api.AccessAllow;
import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Description;
import org.coodex.concrete.demo.pojo.Book;
import org.coodex.util.Parameter;

@ConcreteService(
        value = "Books",
        nonspecific = true // 抽象的服务，此服务不会直接发布，concrete只会发布具体的服务
)
@AccessAllow(roles = "图书管理员") // 此服务的接口需要图书管理员角色，AccessAllow也可以用来修饰具体服务接口
public interface AbstractLibrary<B extends Book> {

    @Description(name = "销毁一本书")
    @ConcreteService("{name}")
    void delete(@Parameter("name") String name);

    @Description(name = "整理书架")
    void sort();
}