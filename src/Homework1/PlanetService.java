package Homework1;

import java.io.*;

public class PlanetService {
    private static final String FILE_NAME = "planet.bin";

    // Serialize object Planet
    public static void serializePlanet(Planet planet) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("planet.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(planet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Deserialize object Planet
    public static Planet deserializePlanet() throws IOException {
        Planet planet = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("planet.bin");
            ois = new ObjectInputStream(fis);
            planet = (Planet) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return planet;
    }
}
