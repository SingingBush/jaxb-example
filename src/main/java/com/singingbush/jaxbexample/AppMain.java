package com.singingbush.jaxbexample;

import com.singingbush.jaxbexample.model.Shiporder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.xml.bind.JAXBException;
import java.io.IOException;

public class AppMain {

    private static final Logger log = LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args) throws IOException {
        log.debug("booting up...");

        try {
            final var processor = new OrderProcessor();

            final var inputStream = AppMain.class.getClassLoader()
                .getResource("shiporder.xml")
                .openStream();

            final Shiporder order = processor.convertOrder(inputStream);

            log.info("Our order has {} items", order.getItem().size());
        } catch (final JAXBException e) {
            log.error("Fatal error occurred", e);
        }
    }

}
