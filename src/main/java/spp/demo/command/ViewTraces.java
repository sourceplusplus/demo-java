package spp.demo.command;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.DefaultHttpClientConfiguration;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.HttpClientConfiguration;

import java.net.URL;

/**
 * This class is used to demonstrate the `View Traces` command.
 * <p>
 * <b>Usage:</b>
 * Open the Source++ Command Palette with `Ctrl+Shift+S` and search for `View Traces`.
 * </p>
 * <p>
 * <b>Command source code:</b>
 * <a href="https://github.com/sourceplusplus/jetbrains-commander/blob/master/resources/.spp/plugins/view-traces/plugin.kts">View Traces</a>
 * </p>
 */
@Controller("/command")
public class ViewTraces {

    private final HttpClientConfiguration config = new DefaultHttpClientConfiguration();

    public ViewTraces() {
        config.setExceptionOnErrorStatus(false);
    }

    /**
     * Execute the `View Traces` command with your caret anywhere between lines 31 and 38 to see the traces for
     * the endpoint below. Executing this command will open a list of traces for the given endpoint. Clicking on a
     * trace will open the trace details.
     */
    @Get("/view-traces")
    public HttpResponse<Void> entryEndpoint() throws Exception {
        try (HttpClient client = HttpClient.create(new URL("http://localhost:8080"), config)) {
            try (BlockingHttpClient blocking = client.toBlocking()) {
                blocking.retrieve("/command/view-traces/exit");
            }
        }
        return HttpResponse.ok();
    }

    @Get("/view-traces/exit")
    public HttpResponse<String> exitEndpoint() {
        return HttpResponse.ok("Success");
    }
}
