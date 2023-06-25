package spp.demo.test;

import org.junit.jupiter.api.Test;

public class TestHealthIndicator {

    @Test
    public void success() {
        // do nothing
    }

    @Test
    public void fail100Percent() {
        throw new RuntimeException("fail 100%");
    }

    @Test
    public void fail50Percent() {
        if (Math.random() > 0.5) {
            throw new RuntimeException("fail 50%");
        }
    }
}
