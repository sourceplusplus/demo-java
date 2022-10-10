package spp.demo.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger log = LoggerFactory.getLogger(AddLog.class);

    /**
     * Execute the <b>Add Log</b> command with your cursor on line 34 to set up a live log
     * <b>before</b> the execution of that line. This will open the log configuration inlay. This inlay
     * allows you to input a new log message to output. You can use the "$" symbol to reference
     * variables in the current scope. You can also use the "Ctrl+Space" shortcut to see a list of
     * available variables. Try outputting the following message:<br>
     * <b>Random number: $randomNumber - Even: $isEven</b>
     */
    public void simpleLog() {
        int randomNumber = ThreadLocalRandom.current().nextInt();
        boolean isEven = randomNumber % 2 == 0;
    }

    /**
     * The <b>Add Log</b> command can also be used with the <b>Tail Logs</b> command. Execute the
     * <b>Tail Logs</b> command with your cursor between or on lines 42-44. Then execute the
     * <b>Add Log</b> command with your cursor on line 45. Try outputting the following message:<br>
     * <b>And is even: $isEven</b>
     */
    public void simpleLogWithTailLogs() {
        int randomNumber = ThreadLocalRandom.current().nextInt();
        boolean isEven = randomNumber % 2 == 0;
        log.info("Random number: {}", randomNumber);
    }
}
