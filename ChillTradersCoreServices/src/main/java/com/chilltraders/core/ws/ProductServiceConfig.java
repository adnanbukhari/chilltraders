package com.chilltraders.core.ws;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chilltraders.core.repository.ProductRepository;

@Configuration
public class ProductServiceConfig  {
	
	@Autowired
    private Bus bus;
	
	@Autowired
	private ProductRepository productRepository;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new ProductServiceImpl(productRepository));
        endpoint.publish("/products");
        return endpoint;
    }
}
