module jaxb.example {

    requires org.slf4j;
    requires jakarta.xml.bind;

    // The generated model needs to be opened to JAXB to be usable
    opens com.singingbush.jaxbexample.model to jakarta.xml.bind;

    // The generated model needs to be exported
    exports com.singingbush.jaxbexample.model;

    exports com.singingbush.jaxbexample;
}
