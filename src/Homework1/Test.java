package Homework1;


import com.google.gson.Gson;

import java.io.IOException;


public class Test {
    public static void main(String[] args) throws IOException {

        Planet planet1 = new Planet("Earth", 510, 356);
        PlanetService.serializePlanet(planet1);
        Planet p1 = PlanetService.deserializePlanet();
        System.out.println(p1);


    }
}
