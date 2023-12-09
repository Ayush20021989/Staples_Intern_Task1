package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}
	@Autowired
	private ProductRepository productRepository;
	@Override
	public void run(String... args) throws Exception {
		//Added two rows in the table just to verify if the Schema has been created in MySQL
		Product product =  new Product();
		product.setName("Table");
		product.setPrice(6000);
		product.setQuantity(2);
		productRepository.save(product);
		Product product1 =  new Product();
		product1.setName("Lamp");
		product1.setPrice(12000);
		product1.setQuantity(2);
		productRepository.save(product1);
	}
}
