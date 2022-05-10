package org.coodex.concrete.demo.impl;

import org.coodex.concrete.demo.api.excepted.LibraryA;
import org.coodex.concrete.demo.pojo.Book;
import org.coodex.concrete.demo.pojo.BookA;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class LibraryAImpl extends AbstractLibraryImpl<BookA> implements LibraryA {

    private final Map<String, Book> books = new HashMap<String, Book>() {{
        for (int i = 1; i < 10; i++)
            put("A" + i, new BookA("A" + i, "A" + i));
    }};

    @Override
    protected Map<String, Book> getBooks() {
        return books;
    }

    @Override
    protected String getType() {
        return "文史类";
    }
}