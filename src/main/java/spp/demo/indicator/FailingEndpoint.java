package spp.demo.indicator;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * This class is used to demonstrate the `Failing Endpoint` indicator. This indicator will be automatically added
 * to endpoints that are actively failing and is visible in the gutter to the left of the editor.
 * <p>
 * <b>Usage:</b>
 * N/A (automatically added)
 * </p>
 * <p>
 * <b>Indicator source code:</b>
 * <a href="https://github.com/sourceplusplus/jetbrains-commander/blob/master/resources/.spp/plugins/failing-endpoint/plugin.kts">Failing Endpoint</a>
 * </p>
 */
@Controller("/indicator")
public class FailingEndpoint {

    /**
     * Hover your mouse over the bug icon on line 26 to see the error rate (100%).
     */
    @Get("/fail-100-percent")
    public HttpResponse<Void> fail100Percent() {
        return HttpResponse.serverError();
    }

    /**
     * Hover your mouse over the bug icon on line 34 to see the error rate (~50%).
     */
    @Get("/fail-50-percent")
    public HttpResponse<Void> fail50Percent() {
        if (Math.random() > 0.5) {
            return HttpResponse.serverError();
        }
        return HttpResponse.ok();
    }
}
