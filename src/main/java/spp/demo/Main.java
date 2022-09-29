package spp.demo;

import spp.demo.command.TailLogs;

public class Main {

    private static TailLogs tailLogs = new TailLogs();

    public static void main(String[] args) throws Exception {
        while (true) {
            executeDemos();
            Thread.sleep(1000);
        }
    }

    public static void executeDemos() {
        triggerTailLogs();
    }

    public static void triggerTailLogs() {
        tailLogs.tailClassLogs();
        tailLogs.tailMethodLogs();
        tailLogs.tailStatementLogs();
    }
}