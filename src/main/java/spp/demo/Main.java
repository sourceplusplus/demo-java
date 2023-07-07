package spp.demo;

import io.micronaut.runtime.Micronaut;
import spp.demo.command.AddBreakpoint;
import spp.demo.command.AddLog;
import spp.demo.command.TailLogs;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    private static final Executor executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        Micronaut.run(Main.class, args);

        while (true) {
            executeDemos();
            Thread.sleep(1000);

            Map<Thread, StackTraceElement[]> threads = Thread.getAllStackTraces();
            for (Map.Entry<Thread, StackTraceElement[]> entry : threads.entrySet()) {
                Thread thread = entry.getKey();
                StackTraceElement[] stackTraceElements = entry.getValue();
                System.out.println("Thread: " + thread.getName());
                for (StackTraceElement stackTraceElement : stackTraceElements) {
                    System.out.println("    " + stackTraceElement);
                }
            }

            int threadCount = Thread.activeCount();
            System.out.println("Thread count: " + threadCount);
        }
    }

    public static void executeDemos() {
        triggerAddBreakpoint();
        triggerAddLog();
        triggerTailLogs();
        triggerEndpoints();
    }

    public static void triggerAddBreakpoint() {
        AddBreakpoint addBreakpoint = new AddBreakpoint();
        addBreakpoint.simpleBreakpoint();
        addBreakpoint.breakpointWithRedactedData();
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
        //function duration insight
        callEndpoint("/insight/slow-function");
        callEndpoint("/insight/fast-function");

        //view activity command
        callEndpoint("/command/view-activity");

        //view traces command
        callEndpoint("/command/view-traces");

        //failing endpoint indicator
        callEndpoint("/indicator/fail-100-percent");
        callEndpoint("/indicator/fail-50-percent");

        //slow endpoint indicator
        callEndpoint("/indicator/slow-2000ms");
        callEndpoint("/indicator/slow-1000ms");

        //high load endpoint indicator
        for (int i = 0; i < 6; i++) {
            callEndpoint("/indicator/high-load-six-per-second");
        }
        for (int i = 0; i < 3; i++) {
            callEndpoint("/indicator/high-load-three-per-second");
        }
    }

    private static void callEndpoint(String endpoint) {
        executor.execute(() -> {
            try {
                URL url = new URL("http://localhost:8080" + endpoint);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.getResponseCode();
                connection.disconnect();
            } catch (Exception ignore) {
            }
        });
    }
}
