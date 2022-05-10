package org.coodex.concrete.demo.api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.ServiceTiming;

@ConcreteService
public interface TimeLimitedService {

    @ServiceTiming("breakfast")
    void breakfast();

    @ServiceTiming("lunch")
    void lunch();

    @ServiceTiming("dinner")
    void dinner();

    @ServiceTiming({"workday", "worktime"})
    void work();
}