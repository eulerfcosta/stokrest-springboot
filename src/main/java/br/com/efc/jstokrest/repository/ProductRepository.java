/**
 * 
 */
package br.com.efc.jstokrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.efc.jstokrest.entity.Product;

/**
 * @author euler
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
