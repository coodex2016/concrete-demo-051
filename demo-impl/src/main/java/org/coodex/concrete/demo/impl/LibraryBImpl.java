package org.coodex.concrete.demo.impl;

import org.coodex.concrete.demo.api.excepted.LibraryB;
import org.coodex.concrete.demo.pojo.Book;
import org.coodex.concrete.demo.pojo.BookB;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class LibraryBImpl extends AbstractLibraryImpl<BookB> implements LibraryB {
    private final Map<String, Book> books = new HashMap<String, Book>() {{
        for (int i = 1; i < 10; i++)
            put("B" + i, new BookB("B" + i, "B" + i));
    }};

    @Override
    protected Map<String, Book> getBooks() {
        return books;
    }

    @Override
    protected String getType() {
        return "理工类";
    }
}