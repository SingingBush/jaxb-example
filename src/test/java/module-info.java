module jaxb.example.test {

    requires jakarta.xml.bind;

    requires jaxb.example;

    requires transitive org.junit.jupiter.engine;
    requires transitive org.junit.jupiter.api;

    // Rather than opening the module completely, just open it to junit:
    opens com.singingbush.jaxbexampletest to org.junit.platform.commons;
}
