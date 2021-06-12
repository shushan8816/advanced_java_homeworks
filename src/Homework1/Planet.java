package Homework1;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class Planet implements Serializable {

    private static final long serialVersionUID = -5179041030718586343L;
    private String name;
    private int area; // (million km²)
    private int orbit; // (days)


    public Planet() {
    }

    public Planet(String name, int area, int orbit) {
        this.name = name;
        this.area = area;
        this.orbit = orbit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getOrbit() {
        return orbit;
    }

    public void setOrbit(int orbit) {
        this.orbit = orbit;
    }


    @Override
    public String toString() {
        return "Planet {" +
                "name : " + name  +
                ", area : " + area +
                ", orbit : " + orbit +
                "}";
    }
}
