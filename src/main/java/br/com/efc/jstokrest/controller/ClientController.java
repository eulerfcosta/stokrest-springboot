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

import br.com.efc.jstokrest.entity.Client;
import br.com.efc.jstokrest.entity.User;
import br.com.efc.jstokrest.repository.ClientRepository;

/**
 * @author euler
 *
 */

@RestController
public class ClientController {

	private ClientRepository _clientRepository;

	/**
	 * @param clientRepository
	 */
	public ClientController(ClientRepository clientRepository) {
		_clientRepository = clientRepository;

	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public List<Client> Get() {
		return _clientRepository.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> GetById(@PathVariable(value = "id") long id) {

		Optional<Client> client = _clientRepository.findById(id);

		if (client.isPresent()) {
			return new ResponseEntity<Client>(client.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param client
	 * @return
	 */
	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public Client Post(@Valid @RequestBody Client client) {

		return _clientRepository.save(client);

	}

	/**
	 * @param id
	 * @param newClient
	 * @return
	 */
	@RequestMapping(value = "/client/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Client newClient) {

		Optional<Client> oldClient = _clientRepository.findById(id);

		if (oldClient.isPresent()) {
			Client client = oldClient.get();
			client.setName(newClient.getName());
			client.setDoc(newClient.getDoc());
			client.setSis_id(newClient.getSis_id());
			client.setIs_stok(newClient.getIs_stok());
			_clientRepository.save(client);
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

		Optional<Client> client = _clientRepository.findById(id);
		if (client.isPresent()) {
			_clientRepository.delete(client.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
