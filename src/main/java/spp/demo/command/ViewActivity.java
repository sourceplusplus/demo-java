package spp.demo.command;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * This class is used to demonstrate the `View Activity` command.
 * <p>
 * <b>Usage:</b>
 * Open the Source++ Command Palette with `Ctrl+Shift+S` and search for `View Activity`.
 * </p>
 * <p>
 * <b>Command source code:</b>
 * <a href="https://github.com/sourceplusplus/jetbrains-commander/blob/master/resources/.spp/plugins/view-activity/plugin.kts">View Activity</a>
 * </p>
 */
@Controller("/command")
public class ViewActivity {

    /**
     * Execute the `View Activity` command with your caret anywhere between lines 26 and 38 to see the activity for
     * the endpoint below. Executing this command will open live charts displaying the average latency, throughput,
     * and availability of the given endpoint.
     */
    @Get("/view-activity")
    public void viewActivityEndpoint() {
        try {
            if (Math.random() < 0.5) {
                Thread.sleep(40);
            } else {
                Thread.sleep(60);
            }
            if (Math.random() < 0.1) {
                throw new RuntimeException("Random exception");
            }
        } catch (InterruptedException ignore) {
        }
    }
}
