package spp.demo.indicator;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * This class is used to demonstrate the `High Load Endpoint` indicator. This indicator will be automatically added
 * to endpoints with the highest request rates and is visible in the gutter to the left of the editor.
 * <p>
 * <b>Usage:</b>
 * N/A (automatically added)
 * </p>
 * <p>
 * <b>Indicator source code:</b>
 * <a href="https://github.com/sourceplusplus/jetbrains-commander/blob/master/resources/.spp/plugins/high-load-endpoint/plugin.kts">High Load Endpoint</a>
 * </p>
 */
@Controller("/indicator")
public class HighLoadEndpoint {

    /**
     * Hover your mouse over the upwards chevron icon on line 26 to see the request rate (~4/second).
     */
    @Get("/high-load-four-per-second")
    public HttpResponse<Void> highLoad4PerSecond() {
        return HttpResponse.ok();
    }

    /**
     * Hover your mouse over the upwards chevron icon on line 34 to see the request rate (~2/second).
     */
    @Get("/high-load-two-per-second")
    public HttpResponse<Void> highLoad2PerSecond() {
        return HttpResponse.ok();
    }
}
