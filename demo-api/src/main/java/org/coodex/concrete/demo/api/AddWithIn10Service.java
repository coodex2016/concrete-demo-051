package org.coodex.concrete.demo.api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Description;
import org.coodex.util.Parameter;

@ConcreteService
@Description(name = "十以内加法")
public interface AddWithIn10Service {
    Integer add(@Parameter("x1") Integer x1, @Parameter("x2") Integer x2);
}