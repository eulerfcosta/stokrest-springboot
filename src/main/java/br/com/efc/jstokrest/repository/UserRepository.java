/**
 * 
 */
package br.com.efc.jstokrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.efc.jstokrest.entity.User;

/**
 * @author euler
 *
 */
public interface UserRepository extends JpaRepository<User, Long > {

}
