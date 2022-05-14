package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository produtRepository;

	public List<Product> listAll() {
		return produtRepository.findAll();
	}

	public void save(Product product) {
		produtRepository.save(product);
	}

	public Product get(Long id) {
		return produtRepository.findById(id).get();
	}

	public void delete(Long id) {
		produtRepository.deleteById(id);
	}
}
