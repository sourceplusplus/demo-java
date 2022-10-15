package spp.demo.indicator;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * This class is used to demonstrate the `Unused Endpoint` indicator. This indicator will be automatically added to
 * endpoints with no traffic and is visible in the gutter to the left of the editor.
 * <p>
 * <b>Usage:</b>
 * N/A (automatically added)
 * </p>
 * <p>
 * <b>Indicator source code:</b>
 * <a href="https://github.com/sourceplusplus/jetbrains-commander/blob/master/resources/.spp/plugins/unused-endpoint/plugin.kts">Unused Endpoint</a>
 * </p>
 */
@Controller("/indicator")
public class UnusedEndpoint {

    /**
     * Hover your mouse over the cloud icon on line 26 to see the unused URL.
     */
    @Get("/unused-endpoint")
    public HttpResponse<Void> unused() {
        return HttpResponse.ok();
    }
}
