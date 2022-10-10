package spp.demo.command;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is used to demonstrate the `Add Log` command.
 * <p>
 * <b>Usage:</b>
 * Open the Source++ Command Palette with `Ctrl+Shift+S` and search for `Add Log`.
 * </p>
 * <p>
 * <b>Command source code:</b>
 * <a href="https://github.com/sourceplusplus/jetbrains-commander/blob/master/resources/.spp/plugins/add-log/plugin.kts">Add Log</a>
 * </p>
 */
public class AddLog {

    /**
     * Execute the <b>Add Log</b> command with your cursor on line 28 to set up a live log
     * <b>before</b> the execution of that line. This will open the log configuration inlay. This inlay
     * allows you to input a new log message to output. You can use the "$" symbol to reference
     * variables in the current scope. You can also use the "Ctrl+Space" shortcut to see a list of
     * available variables. Try outputting the following message: <b>Random number: $randomNumber. Even: $isEven</b>
     */
    public void simpleLog() {
        int randomNumber = ThreadLocalRandom.current().nextInt();
        boolean isEven = randomNumber % 2 == 0;
    }
}
