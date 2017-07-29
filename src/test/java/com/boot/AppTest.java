package com.boot;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.boot.controller.HomeController;

public class AppTest {

	@Test
    public void testApp() {
        HomeController hc = new HomeController();
        String response = hc.index();
        assertEquals(response, "Daas Boot, reporting for duty");
    }
}
