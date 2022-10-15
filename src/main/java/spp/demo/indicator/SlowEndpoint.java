package spp.demo.indicator;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * This class is used to demonstrate the `Slow Endpoint` indicator. This indicator will be automatically added to
 * endpoints with the highest response times and is visible in the gutter to the left of the editor.
 * <p>
 * <b>Usage:</b>
 * N/A (automatically added)
 * </p>
 * <p>
 * <b>Indicator source code:</b>
 * <a href="https://github.com/sourceplusplus/jetbrains-commander/blob/master/resources/.spp/plugins/slow-endpoint/plugin.kts">Slow Endpoint</a>
 * </p>
 */
@Controller("/indicator")
public class SlowEndpoint {

    /**
     * Hover your mouse over the orange turtle icon on line 26 to see the endpoint's response time (2000ms).
     */
    @Get("/slow-2000ms")
    public HttpResponse<Void> slow2000ms() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignore) {
        }
        return HttpResponse.ok();
    }

    /**
     * Hover your mouse over the orange turtle icon on line 34 to see the endpoint's response time (1000ms).
     */
    @Get("/slow-1000ms")
    public HttpResponse<Void> slow1000ms() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }
        return HttpResponse.ok();
    }
}
