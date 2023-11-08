package by.latotskiy.repository;

import by.latotskiy.models.Turtle;
import by.latotskiy.models.TurtleList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;


// Данный класс используется для чтения и записи данных из файла turtles.xml
public class TurtleXMLProcessor {

    // Метод, который записывает все обьекты списка turtles в XML файл
    public void marshalTurtles(List<Turtle> turtles, String filePath) throws JAXBException {
        TurtleList turtleList = new TurtleList();
        turtleList.setTurtles(turtles);

        JAXBContext context = JAXBContext.newInstance(TurtleList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(turtleList, new File(filePath));

    }

    // Метод, который считывает данные из XML файла

    public List<Turtle> unmarshalTurtles(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(TurtleList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        TurtleList turtleList = (TurtleList) unmarshaller.unmarshal(new File(filePath));
        return turtleList.getTurtles();
    }
}
