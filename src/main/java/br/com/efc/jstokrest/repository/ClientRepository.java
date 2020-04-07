/**
 * 
 */
package br.com.efc.jstokrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.efc.jstokrest.entity.Client;

/**
 * @author euler
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
