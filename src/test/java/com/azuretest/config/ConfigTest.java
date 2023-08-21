package com.azuretest.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class ConfigTest {

    @Test
    public void testVariablesDeEntorno() {
        String env = "test-value-home";
        Boolean isTEST = env.equals(System.getenv("TEST"));
        //System.out.println(System.getenv("TEST"));
        //System.out.println("El valor de la variable de TEST es: " + System.getenv("TEST"));
        assertTrue(isTEST);
    }

    @Test
    public void testImprimirTodasLasVariablesDeEntorno() {
        Map<String, String> getEnv = System.getenv();
        getEnv.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }
}
