package epsi.model;

// Generated 6 mai 2015 11:18:39 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Commande generated by hbm2java
 */
@Entity
@Table(name = "commande", catalog = "bdd_lpdc")
public class Commande implements java.io.Serializable {

	private Integer idCommande;
	private EtatCommande etatCommande;
	private User user;
	private Date dateHCommande;
	private Date heureLivraison;
	private String livraison;
	private Set<CommandeContient> commandeContients = new HashSet<CommandeContient>(
			0);

	public Commande() {
	}

	public Commande(User user, Date dateHCommande, Date heureLivraison) {
		this.user = user;
		this.dateHCommande = dateHCommande;
		this.heureLivraison = heureLivraison;
	}

	public Commande(EtatCommande etatCommande, User user, Date dateHCommande,
			Date heureLivraison, String livraison,
			Set<CommandeContient> commandeContients) {
		this.etatCommande = etatCommande;
		this.user = user;
		this.dateHCommande = dateHCommande;
		this.heureLivraison = heureLivraison;
		this.livraison = livraison;
		this.commandeContients = commandeContients;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_Commande", unique = true, nullable = false)
	public Integer getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Etat")
	public EtatCommande getEtatCommande() {
		return this.etatCommande;
	}

	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_User", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateH_Commande", nullable = false, length = 19)
	public Date getDateHCommande() {
		return this.dateHCommande;
	}

	public void setDateHCommande(Date dateHCommande) {
		this.dateHCommande = dateHCommande;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "heure_Livraison", nullable = false, length = 19)
	public Date getHeureLivraison() {
		return this.heureLivraison;
	}

	public void setHeureLivraison(Date heureLivraison) {
		this.heureLivraison = heureLivraison;
	}

	@Column(name = "livraison", length = 30)
	public String getLivraison() {
		return this.livraison;
	}

	public void setLivraison(String livraison) {
		this.livraison = livraison;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commande")
	public Set<CommandeContient> getCommandeContients() {
		return this.commandeContients;
	}

	public void setCommandeContients(Set<CommandeContient> commandeContients) {
		this.commandeContients = commandeContients;
	}

}
