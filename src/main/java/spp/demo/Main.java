package spp.demo;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import io.micronaut.runtime.Micronaut;
import spp.demo.command.AddBreakpoint;
import spp.demo.command.AddLog;
import spp.demo.command.TailLogs;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    private static final Executor executor = Executors.newCachedThreadPool();
    private static final MetricRegistry metricRegistry = new MetricRegistry();

    public static void main(String[] args) throws Exception {
        Micronaut.run(Main.class, args);

        ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry).build();

        while (true) {
            executeDemos();
            Thread.sleep(1000);

            reporter.report();

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
//        //function duration insight
//        callEndpoint("/insight/slow-function");
//        callEndpoint("/insight/fast-function");

//        //view activity command
//        callEndpoint("/command/view-activity");
//
//        //view traces command
//        callEndpoint("/command/view-traces");
//
//        //failing endpoint indicator
//        callEndpoint("/indicator/fail-100-percent");
//        callEndpoint("/indicator/fail-50-percent");
//
//        //slow endpoint indicator
//        callEndpoint("/indicator/slow-2000ms");
//        callEndpoint("/indicator/slow-1000ms");
//
        //high load endpoint indicator
        for (int i = 0; i < 6; i++) {
            callEndpoint("/indicator/high-load-six-per-second");
        }
        for (int i = 0; i < 3; i++) {
            callEndpoint("/indicator/high-load-three-per-second");
        }
    }

    private static void callEndpoint(String endpoint) {
        Timer.Context timer = metricRegistry.timer(endpoint).time();
        URL url;
        try {
            url = new URL("http://localhost:8080" + endpoint);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        executor.execute(() -> {
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(10_000);
                connection.setReadTimeout(10_000);
                int responseCode = connection.getResponseCode();
                System.out.println("Response code: " + responseCode);
            } catch (Exception ignore) {
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                timer.close();
            }
        });
    }
}
