package com.chilltraders.core.ws;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.chilltraders.core.exception.ResourceNotFoundException;
import com.chilltraders.core.exception.ResourcelreadyExistsException;
import com.chilltraders.core.model.Product;


@WebService
public interface ProductService {

    @WebMethod
    Product getProduct(long id) throws ResourceNotFoundException;

    @WebMethod
    Product updateProduct(long id, Product product) throws ResourceNotFoundException;

    @WebMethod
    boolean deleteProduct(long id) throws ResourceNotFoundException;

    @WebMethod
    Product addProduct(long id, Product product) throws ResourcelreadyExistsException;

    @WebMethod
    long countProducts();

    @WebMethod
    List<Product> getAllProducts();
    
}