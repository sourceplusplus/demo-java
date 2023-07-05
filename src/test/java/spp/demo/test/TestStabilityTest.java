package spp.demo.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestStabilityTest {

    @Test
    public void success100Percent() {
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

    @Disabled
    @Test
    public void neverExecuted() {
    }
}
