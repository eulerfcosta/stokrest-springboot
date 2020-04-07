/**
 * 
 */
package br.com.efc.jstokrest.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author euler
 *
 */

/**
 * @author euler
 *
 */
/**
 * @author euler
 *
 */
/**
 * @author euler
 *
 */
/**
 * @author euler
 *
 */
/**
 * @author euler
 *
 */
/**
 * @author euler
 *
 */
/**
 * @author euler
 *
 */
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String doc;

	@Column(nullable = true)
	private long sis_id;

	@Column(nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean is_stok;

	@Column(nullable = true, updatable = false)
	@CreationTimestamp
	private Timestamp created_at;

	@Column(nullable = true, updatable = true)
	@UpdateTimestamp
	private Timestamp updated_at;

	/**
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getDoc() {
		return doc;
	}

	/**
	 * @param doc
	 */
	public void setDoc(String doc) {
		this.doc = doc;
	}

	/**
	 * @return
	 */
	public long getSis_id() {
		return sis_id;
	}

	/**
	 * @param sis_id
	 */
	public void setSis_id(long sis_id) {
		this.sis_id = sis_id;
	}

	/**
	 * @return
	 */
	public boolean getIs_stok() {
		return is_stok;
	}

	/**
	 * @param is_stok
	 */
	public void setIs_stok(boolean is_stok) {
		this.is_stok = is_stok;
	}

	/**
	 * @return
	 */
	public Timestamp getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at
	 */
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return
	 */
	public Timestamp getUpdated_at() {
		return updated_at;
	}

	/**
	 * @param updated_at
	 */
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

}
