/**
 * 
 */
package br.com.efc.jstokrest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.efc.jstokrest.entity.Product;
import br.com.efc.jstokrest.repository.ProductRepository;

/**
 * @author euler
 *
 */

@RestController
public class ProductController {

	private ProductRepository _productRepository;

	/**
	 * @param productRepository
	 */
	public ProductController(ProductRepository productRepository) {
		_productRepository = productRepository;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public List<Product> Get() {
		return _productRepository.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> GetById(@PathVariable(value = "id") long id) {

		Optional<Product> product = _productRepository.findById(id);

		if (product.isPresent()) {
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public Product Post(@Valid @RequestBody Product product) {

		return _productRepository.save(product);

	}

	/**
	 * @param id
	 * @param newProduct
	 * @return
	 */
	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Product newProduct) {

		Optional<Product> oldProduct = _productRepository.findById(id);

		if (oldProduct.isPresent()) {
			Product product = oldProduct.get();
			product.setName(newProduct.getName());
			product.setProductType(newProduct.getProductType());
			_productRepository.save(product);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

		Optional<Product> product = _productRepository.findById(id);
		if (product.isPresent()) {
			_productRepository.delete(product.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
