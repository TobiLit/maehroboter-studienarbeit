package app;

import core.SimulationEngine;

/**
 * The Main class serves as the entry point for the simulation application.
 * It initializes and executes a SimulationEngine instance to run a grid-based
 * navigation simulation.
 */
public class Main {

    /**
     * The entry point of the simulation application. This method creates an instance
     * of a simulation engine, configures it with predefined parameters, and starts
     * the simulation process.
     *
     * @param args command-line arguments passed to the application. Currently,
     *             they are not being utilized by the program.
     */
    public static void main(String[] args) {
        SimulationEngine engine = new SimulationEngine(10, 100, 20);
        engine.run();
    }
}