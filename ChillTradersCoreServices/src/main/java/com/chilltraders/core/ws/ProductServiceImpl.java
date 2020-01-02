package com.chilltraders.core.ws;

import java.util.List;

import javax.jws.WebService;

import com.chilltraders.core.exception.ResourceNotFoundException;
import com.chilltraders.core.exception.ResourcelreadyExistsException;
import com.chilltraders.core.model.Product;
import com.chilltraders.core.repository.ProductRepository;


@WebService(serviceName = "ProductService", endpointInterface = "com.chilltraders.core.ws.ProductService")
public class ProductServiceImpl implements ProductService {

	ProductRepository productRepository;
	ProductServiceImpl(ProductRepository productRepository){
		this.productRepository = productRepository;
		
	}

	@Override
	public Product getProduct(long id) throws ResourceNotFoundException {
		return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));	
	}

	@Override
	public Product updateProduct(long id, Product product) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProduct(long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product addProduct(long id, Product product) throws ResourcelreadyExistsException {
		return productRepository.save(product);
	}

	@Override
	public long countProducts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> getAllProducts() {
		System.out.println("Inside Get All Products: " + productRepository);
		return productRepository.findAll();
	}

}
