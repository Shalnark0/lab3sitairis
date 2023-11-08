package by.latotskiy.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

// Данный класс используется для сохранения всех черепах в виде списка в XML файле

@XmlRootElement
public class TurtleList {
    private List<Turtle> turtles;

    @XmlElement
    public List<Turtle> getTurtles() {
        return turtles;
    }

    public void setTurtles(List<Turtle> turtles) {
        this.turtles = turtles;
    }
}
