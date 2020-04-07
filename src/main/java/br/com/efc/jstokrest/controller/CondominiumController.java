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

import br.com.efc.jstokrest.entity.Condominium;
import br.com.efc.jstokrest.repository.CondominiumRepository;

/**
 * @author euler
 *
 */

@RestController
public class CondominiumController {

	private CondominiumRepository _condominiumRepository;

	/**
	 * @param condominiumRepository
	 */
	public CondominiumController(CondominiumRepository condominiumRepository) {
		_condominiumRepository = condominiumRepository;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/condominium", method = RequestMethod.GET)
	public List<Condominium> Get() {
		return _condominiumRepository.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/condominium/{id}", method = RequestMethod.GET)
	public ResponseEntity<Condominium> GetById(@PathVariable(value = "id") long id) {

		Optional<Condominium> condominium = _condominiumRepository.findById(id);

		if (condominium.isPresent()) {
			return new ResponseEntity<Condominium>(condominium.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param condominium
	 * @return
	 */
	@RequestMapping(value = "/condominium", method = RequestMethod.POST)
	public Condominium Post(@Valid @RequestBody Condominium condominium) {

		return _condominiumRepository.save(condominium);

	}

	/**
	 * @param id
	 * @param newCondominium
	 * @return
	 */
	@RequestMapping(value = "/condominium/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Condominium> Put(@PathVariable(value = "id") long id,
			@Valid @RequestBody Condominium newCondominium) {

		Optional<Condominium> oldCondominium = _condominiumRepository.findById(id);

		if (oldCondominium.isPresent()) {
			Condominium condominium = oldCondominium.get();
			condominium.setName(newCondominium.getName());
			condominium.setAddress(newCondominium.getAddress());
			condominium.setNumber(newCondominium.getNumber());
			condominium.setComplement(newCondominium.getComplement());
			condominium.setNeighborhood(newCondominium.getNeighborhood());
			condominium.setZipcode(newCondominium.getZipcode());
			condominium.setState(newCondominium.getState());
			_condominiumRepository.save(condominium);
			return new ResponseEntity<Condominium>(condominium, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/Condominium/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

		Optional<Condominium> condominium = _condominiumRepository.findById(id);
		if (condominium.isPresent()) {
			_condominiumRepository.delete(condominium.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
