package org.coodex.concrete.demo.api.excepted;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Domain;
import org.coodex.concrete.demo.pojo.BookB;

@ConcreteService("B")
@Domain("理工类")
public interface LibraryB extends AbstractLibrary<BookB> {
}