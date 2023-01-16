package spp.demo.command;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is used to demonstrate the `Add Breakpoint` command.
 * <p>
 * <b>Usage:</b>
 * Open the Source++ Command Palette with `Ctrl+Shift+S` and search for `Add Breakpoint`.
 * </p>
 * <p>
 * <b>Command source code:</b>
 * <a href="https://github.com/sourceplusplus/jetbrains-commander/blob/master/resources/.spp/plugins/add-breakpoint/plugin.kts">Add Breakpoint</a>
 * </p>
 */
public class AddBreakpoint {

    /**
     * Execute the <b>Add Breakpoint</b> command with your cursor on line 32 to set up a non-breaking breakpoint
     * <b>before</b> the execution of that line. This will open the breakpoint configuration inlay. Hit enter to make
     * the breakpoint non-conditional. Hit enter again make the breakpoint single-use and create the breakpoint.
     * <p>
     * Once the breakpoint is created, the breakpoint status inlay will appear. This inlay will show the current
     * status of the breakpoint and will be marked as <b>Complete</b> once the breakpoint is hit. Once the breakpoint
     * is hit, the breakpoint status inlay can be expanded to show a table of the breakpoint hits. Clicking on a
     * breakpoint hit will open the breakpoint hit data in the traditional debugger variables view.
     * </p>
     */
    public void simpleBreakpoint() {
        int randomNumber = ThreadLocalRandom.current().nextInt();
        boolean isEven = randomNumber % 2 == 0;
        System.out.println(randomNumber + " is " + (isEven ? "even" : "odd"));
    }

    /**
     * The <b>Add Breakpoint</b> command (as well as other live instruments) support PII (Personally Identifiable
     * Information) redaction. This allows you to safely add breakpoints to code with sensitive data.
     * <p>
     * Try adding a breakpoint to output any of the variables below.
     * </p>
     */
    public void breakpointWithRedactedData() {
        String password = "password123"; // redacted via variable identifier
        String ssn = "123-45-6789"; // redacted via regex pattern
    }
}
