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

import br.com.efc.jstokrest.entity.ProductType;
import br.com.efc.jstokrest.entity.User;
import br.com.efc.jstokrest.repository.ProductTypeRepository;

/**
 * @author euler
 *
 */
@RestController
public class ProductTypeController {

	private ProductTypeRepository _producttypeRepository;

	/**
	 * @param productTypeRepository
	 */
	public ProductTypeController(ProductTypeRepository productTypeRepository) {
		_producttypeRepository = productTypeRepository;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/producttype", method = RequestMethod.GET)
	public List<ProductType> Get() {
		return _producttypeRepository.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/producttype/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductType> GetById(@PathVariable(value = "id") long id) {

		Optional<ProductType> productType = _producttypeRepository.findById(id);

		if (productType.isPresent()) {
			return new ResponseEntity<ProductType>(productType.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param productType
	 * @return
	 */
	@RequestMapping(value = "/producttype", method = RequestMethod.POST)
	public ProductType Post(@Valid @RequestBody ProductType productType) {

		return _producttypeRepository.save(productType);

	}

	/**
	 * @param id
	 * @param newProductType
	 * @return
	 */
	@RequestMapping(value = "/producttype/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ProductType> Put(@PathVariable(value = "id") long id,
			@Valid @RequestBody ProductType newProductType) {

		Optional<ProductType> oldProductType = _producttypeRepository.findById(id);

		if (oldProductType.isPresent()) {
			ProductType productType = oldProductType.get();
			productType.setName(newProductType.getName());
			_producttypeRepository.save(productType);
			return new ResponseEntity<ProductType>(productType, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/producttype/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

		Optional<ProductType> productType = _producttypeRepository.findById(id);
		if (productType.isPresent()) {
			_producttypeRepository.delete(productType.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
