package com.chilltraders.core.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

public class ObjectFactory {
	private final static QName _CountEmployeesResponse_QNAME = new QName("http://topdown.server.jaxws.baeldung.com/", "countEmployeesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.baeldung.jaxws.server.topdown
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://topdown.server.jaxws.baeldung.com/", name = "countEmployeesResponse")
    public JAXBElement<Integer> createCountEmployeesResponse(Integer value) {
        return new JAXBElement<Integer>(_CountEmployeesResponse_QNAME, Integer.class, null, value);
    }
}
