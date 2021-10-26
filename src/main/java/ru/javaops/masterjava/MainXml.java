package ru.javaops.masterjava;

import com.google.common.io.Resources;
import ru.javaops.masterjava.xml.schema.ObjectFactory;
import ru.javaops.masterjava.xml.schema.Payload;
import ru.javaops.masterjava.xml.schema.User;
import ru.javaops.masterjava.xml.util.JaxbParser;
import ru.javaops.masterjava.xml.util.Schemas;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Comparator;

public class MainXml {
    public static void main(String[] args) throws IOException, JAXBException {
        final JaxbParser parser = new JaxbParser(ObjectFactory.class);
        parser.setSchema(Schemas.ofClasspath("payload.xsd"));

        final Payload payload = parser.unmarshal(Resources.getResource("payload.xml").openStream());
        payload.getUsers().getUser().sort(Comparator.comparing(User::getEmail));

        payload.getUsers().getUser().forEach(user -> System.out.println(user.getEmail()));
    }
}
