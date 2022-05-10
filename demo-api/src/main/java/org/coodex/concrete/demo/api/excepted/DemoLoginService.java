package org.coodex.concrete.demo.api.excepted;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Modules;
import org.coodex.util.Parameter;

@ConcreteService
public interface DemoLoginService {

    @Modules(values = {"M1", "M2"})
    void login(@Parameter("id") String id);
}