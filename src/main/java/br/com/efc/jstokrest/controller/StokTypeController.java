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

import br.com.efc.jstokrest.entity.StokType;
import br.com.efc.jstokrest.repository.StokTypeRepository;

/**
 * @author euler
 *
 */
@RestController
public class StokTypeController {

	private StokTypeRepository _stoktypeRepository;

	/**
	 * @param stoktypeRepository
	 */
	public StokTypeController(StokTypeRepository stoktypeRepository) {
		_stoktypeRepository = stoktypeRepository;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/stoktype", method = RequestMethod.GET)
	public List<StokType> Get() {
		return _stoktypeRepository.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/stoktype/{id}", method = RequestMethod.GET)
	public ResponseEntity<StokType> GetById(@PathVariable(value = "id") long id) {

		Optional<StokType> stokType = _stoktypeRepository.findById(id);

		if (stokType.isPresent()) {
			return new ResponseEntity<StokType>(stokType.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param stokType
	 * @return
	 */
	@RequestMapping(value = "/stoktype", method = RequestMethod.POST)
	public StokType Post(@Valid @RequestBody StokType stokType) {

		return _stoktypeRepository.save(stokType);

	}

	/**
	 * @param id
	 * @param newstokType
	 * @return
	 */
	@RequestMapping(value = "/stoktype/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StokType> Put(@PathVariable(value = "id") long id, @Valid @RequestBody StokType newstokType) {

		Optional<StokType> oldstokType = _stoktypeRepository.findById(id);

		if (oldstokType.isPresent()) {
			StokType stokType = oldstokType.get();
			stokType.setName(newstokType.getName());
			_stoktypeRepository.save(stokType);
			return new ResponseEntity<StokType>(stokType, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/stoktype/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

		Optional<StokType> stokType = _stoktypeRepository.findById(id);
		if (stokType.isPresent()) {
			_stoktypeRepository.delete(stokType.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
