package org.coodex.concrete.demo.api.excepted;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Domain;
import org.coodex.concrete.demo.pojo.BookA;

@ConcreteService("A")
@Domain("文史类")
public interface LibraryA extends AbstractLibrary<BookA> {
}