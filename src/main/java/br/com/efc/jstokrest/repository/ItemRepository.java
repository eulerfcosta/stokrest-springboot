/**
 * 
 */
package br.com.efc.jstokrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.efc.jstokrest.entity.Item;

/**
 * @author euler
 *
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

}
