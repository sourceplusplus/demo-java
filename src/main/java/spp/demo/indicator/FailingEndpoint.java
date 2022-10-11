package spp.demo.indicator;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/indicator")
public class FailingEndpoint {

    @Get("/fail-100-percent")
    public void fail100Percent() {
        throw new RuntimeException("Failed");
    }

    @Get("/fail-75-percent")
    public void fail75Percent() {
        if (Math.random() > 0.25) {
            throw new RuntimeException("Failed");
        }
    }

    @Get("/fail-50-percent")
    public void fail50Percent() {
        if (Math.random() > 0.5) {
            throw new RuntimeException("Failed");
        }
    }
}
