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

import br.com.efc.jstokrest.entity.Item;
import br.com.efc.jstokrest.repository.ItemRepository;

/**
 * @author euler
 *
 */
@RestController
public class ItemController {

	private ItemRepository _itemRepository;

	/**
	 * 
	 */
	public ItemController(ItemRepository itemRepository) {
		_itemRepository = itemRepository;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public List<Item> Get() {
		return _itemRepository.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public ResponseEntity<Item> GetById(@PathVariable(value = "id") long id) {

		Optional<Item> item = _itemRepository.findById(id);

		if (item.isPresent()) {
			return new ResponseEntity<Item>(item.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param item
	 * @return
	 */
	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public Item Post(@Valid @RequestBody Item item) {

		return _itemRepository.save(item);

	}

	/**
	 * @param id
	 * @param newItem
	 * @return
	 */
	@RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Item> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Item newItem) {

		Optional<Item> oldItem = _itemRepository.findById(id);

		if (oldItem.isPresent()) {
			Item item = oldItem.get();
			item.setSn(newItem.getSn());
			item.setProduct(newItem.getProduct());
			item.setStok(newItem.getStok());
			_itemRepository.save(item);
			return new ResponseEntity<Item>(item, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {

		Optional<Item> item = _itemRepository.findById(id);
		if (item.isPresent()) {
			_itemRepository.delete(item.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
