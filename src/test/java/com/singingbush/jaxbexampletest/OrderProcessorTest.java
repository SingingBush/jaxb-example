package com.singingbush.jaxbexampletest;

import com.singingbush.jaxbexample.AppMain;
import com.singingbush.jaxbexample.OrderProcessor;
import com.singingbush.jaxbexample.model.Shiporder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.xml.bind.JAXBException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {

    private OrderProcessor processor;

    @BeforeEach
    void setUp() throws JAXBException {
        this.processor = new OrderProcessor();
    }

    @Test
    void convertOrder() throws JAXBException, IOException {
        final var testData = AppMain.class.getClassLoader()
            .getResource("test-shiporder-data.xml")
            .openStream();

        final Shiporder order = this.processor.convertOrder(testData);

        assertNotNull(order);
        assertEquals("Steve Smith", order.getOrderperson());
        assertEquals("Some Street", order.getShipto().getAddress());
        assertEquals("London", order.getShipto().getCity());
        assertEquals(4, order.getItem().size());
    }
}
