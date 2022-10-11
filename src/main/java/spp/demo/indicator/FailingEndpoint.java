package spp.demo.indicator;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/indicator")
public class FailingEndpoint {

    @Get("/fail-100-percent")
    public HttpResponse<Void> fail100Percent() {
        return HttpResponse.serverError();
    }

    @Get("/fail-75-percent")
    public HttpResponse<Void> fail75Percent() {
        if (Math.random() > 0.25) {
            return HttpResponse.serverError();
        }
        return HttpResponse.ok();
    }

    @Get("/fail-50-percent")
    public HttpResponse<Void> fail50Percent() {
        if (Math.random() > 0.5) {
            return HttpResponse.serverError();
        }
        return HttpResponse.ok();
    }
}
