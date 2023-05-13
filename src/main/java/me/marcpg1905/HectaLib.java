package me.marcpg1905;

import me.marcpg1905.environment.Env;

import java.io.File;
import java.util.Set;

public class HectaLib {
    private Set<Env> currentEnvironments;
    private static File config;
    public HectaLib(String configPath, Set<Env> environments) {
        config = new File(configPath);
        currentEnvironments = environments;
    }
}
