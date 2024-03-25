package Ders05;

import org.junit.Test;

public class TestBaseBeforeClassAfterClass extends Utilities.TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        driver.get("https://google.az");
    }
}
