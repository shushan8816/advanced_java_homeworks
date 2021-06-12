package Homework1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class JaxbObjectToXML {
    public static void main(String[] args) {

        Planet planet2 = new Planet("Mercury", 747, 88);
        jaxbObjectToXML(planet2);

    }

    private static void jaxbObjectToXML(Planet planet2) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Planet.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File("planet2.xml");
            jaxbMarshaller.marshal(planet2, file);
            String xmlContent;
            try (StringWriter sw = new StringWriter()) {
                jaxbMarshaller.marshal(planet2, sw);
                xmlContent = sw.toString();
            }
            System.out.println(xmlContent);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    String fileName = "planet.xml";
    private static void jaxbXmlFileToObject(String fileName) {

        File xmlFile = new File(fileName);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Planet.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Planet planet2 = (Planet) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println(planet2);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}


