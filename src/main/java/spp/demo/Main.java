package spp.demo;

import spp.demo.command.AddBreakpoint;
import spp.demo.command.AddLog;
import spp.demo.command.TailLogs;

public class Main {

    public static void main(String[] args) throws Exception {
        while (true) {
            executeDemos();
            Thread.sleep(1000);
        }
    }

    public static void executeDemos() {
        triggerAddBreakpoint();
        triggerAddLog();
        triggerTailLogs();
    }

    public static void triggerAddBreakpoint() {
        new AddBreakpoint().simpleBreakpoint();
    }

    public static void triggerAddLog() {
        AddLog addLog = new AddLog();
        addLog.simpleLog();
        addLog.simpleLogWithTailLogs();
    }

    public static void triggerTailLogs() {
        TailLogs tailLogs = new TailLogs();
        tailLogs.tailClassLogs();
        tailLogs.tailMethodLogs();
        tailLogs.tailStatementLogs();
    }
}
