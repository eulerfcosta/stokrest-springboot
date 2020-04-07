/**
 * 
 */
package br.com.efc.jstokrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.efc.jstokrest.entity.ProductType;

/**
 * @author euler
 *
 */
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
