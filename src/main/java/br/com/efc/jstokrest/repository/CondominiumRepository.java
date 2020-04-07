/**
 * 
 */
package br.com.efc.jstokrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.efc.jstokrest.entity.Condominium;

/**
 * @author euler
 *
 */
public interface CondominiumRepository extends JpaRepository<Condominium, Long> {

}
