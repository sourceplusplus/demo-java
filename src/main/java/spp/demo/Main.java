package spp.demo;

import io.micronaut.runtime.Micronaut;
import spp.demo.command.AddBreakpoint;
import spp.demo.command.AddLog;
import spp.demo.command.TailLogs;

import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {
        Micronaut.run(Main.class, args);

        while (true) {
            executeDemos();
            Thread.sleep(1000);
        }
    }

    public static void executeDemos() throws Exception {
        triggerAddBreakpoint();
        triggerAddLog();
        triggerTailLogs();
        triggerEndpoints();
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

    public static void triggerEndpoints() throws Exception {
        URL baseUrl = new URL("http://localhost:8080");
        try {
            new URL(baseUrl, "/indicator/fail-100-percent").openStream().close();
        } catch (Exception ignore) {
        }
        try {
            new URL(baseUrl, "/indicator/fail-50-percent").openStream().close();
        } catch (Exception ignore) {
        }
    }
}
