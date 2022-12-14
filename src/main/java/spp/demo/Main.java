package spp.demo;

import io.micronaut.runtime.Micronaut;
import spp.demo.command.AddBreakpoint;
import spp.demo.command.AddLog;
import spp.demo.command.TailLogs;

import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    private static final Executor executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        Micronaut.run(Main.class, args);

        while (true) {
            executeDemos();
            Thread.sleep(1000);
        }
    }

    public static void executeDemos() {
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

    public static void triggerEndpoints() {
        //failing endpoint indicator
        callEndpoint("/indicator/fail-100-percent");
        callEndpoint("/indicator/fail-50-percent");

        //slow endpoint indicator
        callEndpoint("/indicator/slow-2000ms");
        callEndpoint("/indicator/slow-1000ms");

        //high load endpoint indicator
        for (int i = 0; i < 4; i++) {
            callEndpoint("/indicator/high-load-four-per-second");
        }
        for (int i = 0; i < 2; i++) {
            callEndpoint("/indicator/high-load-two-per-second");
        }
    }

    private static void callEndpoint(String endpoint) {
        executor.execute(() -> {
            try {
                new URL("http://localhost:8080" + endpoint).openStream().close();
            } catch (Exception ignore) {
            }
        });
    }
}
