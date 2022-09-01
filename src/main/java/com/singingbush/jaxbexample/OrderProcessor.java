package com.singingbush.jaxbexample;

import com.singingbush.jaxbexample.model.Shiporder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.InputStream;

public class OrderProcessor {

    private static final Logger log = LoggerFactory.getLogger(OrderProcessor.class);

    final Unmarshaller unmarshaller;

    public OrderProcessor() throws JAXBException {
        this.unmarshaller = JAXBContext
            .newInstance(Shiporder.class)
            .createUnmarshaller();

        log.info("Created JAXB unmarshaller for Shiporder");
    }

    public Shiporder convertOrder(final InputStream stream) throws JAXBException {
        return (Shiporder)this.unmarshaller.unmarshal(stream);
    }
}
