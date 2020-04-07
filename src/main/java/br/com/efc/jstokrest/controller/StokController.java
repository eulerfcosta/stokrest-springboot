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

import br.com.efc.jstokrest.entity.Stok;
import br.com.efc.jstokrest.repository.StokRepository;

/**
 * @author euler
 *
 */
@RestController
public class StokController {

	private StokRepository _stokRepository;

	/**
	 * @param stokRepository
	 */
	public StokController(StokRepository stokRepository) {
		_stokRepository = stokRepository;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/stok", method = RequestMethod.GET)
	public List<Stok> Get() {
		return _stokRepository.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/stok/{id}", method = RequestMethod.GET)
	public ResponseEntity<Stok> GetById(@PathVariable(value = "id") long id) {

		Optional<Stok> stok = _stokRepository.findById(id);

		if (stok.isPresent()) {
			return new ResponseEntity<Stok>(stok.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param stok
	 * @return
	 */
	@RequestMapping(value = "/stok", method = RequestMethod.POST)
	public Stok Post(@Valid @RequestBody Stok stok) {

		return _stokRepository.save(stok);

	}

	/**
	 * @param id
	 * @param newStok
	 * @return
	 */
	@RequestMapping(value = "/stok/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Stok> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Stok newStok) {

		Optional<Stok> oldStok = _stokRepository.findById(id);

		if (oldStok.isPresent()) {
			Stok stok = oldStok.get();
			stok.setName(newStok.getName());
			stok.setStokType(newStok.getStokType());
			stok.setClient(newStok.getClient());
			_stokRepository.save(stok);
			return new ResponseEntity<Stok>(stok, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/stok/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

		Optional<Stok> stok = _stokRepository.findById(id);
		if (stok.isPresent()) {
			_stokRepository.delete(stok.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
