package epsi.model;

// Generated 6 mai 2015 11:18:39 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TypeCuisine generated by hbm2java
 */
@Entity
@Table(name = "type_cuisine", catalog = "bdd_lpdc")
public class TypeCuisine implements java.io.Serializable {

	private Integer idTypeCuisine;
	private String designationTypeCuisine;
	private Set<Plat> plats = new HashSet<Plat>(0);

	public TypeCuisine() {
	}

	public TypeCuisine(String designationTypeCuisine) {
		this.designationTypeCuisine = designationTypeCuisine;
	}

	public TypeCuisine(String designationTypeCuisine, Set<Plat> plats) {
		this.designationTypeCuisine = designationTypeCuisine;
		this.plats = plats;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_Type_Cuisine", unique = true, nullable = false)
	public Integer getIdTypeCuisine() {
		return this.idTypeCuisine;
	}

	public void setIdTypeCuisine(Integer idTypeCuisine) {
		this.idTypeCuisine = idTypeCuisine;
	}

	@Column(name = "designation_Type_Cuisine", nullable = false, length = 100)
	public String getDesignationTypeCuisine() {
		return this.designationTypeCuisine;
	}

	public void setDesignationTypeCuisine(String designationTypeCuisine) {
		this.designationTypeCuisine = designationTypeCuisine;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeCuisine")
	public Set<Plat> getPlats() {
		return this.plats;
	}

	public void setPlats(Set<Plat> plats) {
		this.plats = plats;
	}

}
