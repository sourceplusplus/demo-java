package spp.demo.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestStabilityIndicator {

    @Test
    public void success() {
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

    @Test
    public void fail25Percent() {
        if (Math.random() > 0.75) {
            throw new RuntimeException("fail 25%");
        }
    }

    @Disabled
    @Test
    public void neverExecuted() {
    }
}
