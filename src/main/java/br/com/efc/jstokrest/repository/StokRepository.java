/**
 * 
 */
package br.com.efc.jstokrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.efc.jstokrest.entity.Stok;

/**
 * @author euler
 *
 */
public interface StokRepository extends JpaRepository<Stok, Long> {

}
