package magasin;

public class LigneCommande {
	private Produit produitCommande;
	private int IdLigne;
	private int IdCommande;
	private int Quantite;
	
	@Override
	public String toString() {
		return "LigneCommande [produitCommande=" + produitCommande + ", IdLigne=" + IdLigne + ", IdCommande="
				+ IdCommande + ", Quantite=" + Quantite + "]";
	}
	public LigneCommande(Produit produitCommande, int idLigne, int idCommande, int quantite) {
		super();
		this.produitCommande = produitCommande;
		IdLigne = idLigne;
		IdCommande = idCommande;
		Quantite = quantite;
	}
	public Produit getProduitCommande() {
		return produitCommande;
	}
	
	public void setProduitCommande(Produit produitCommande) {
		this.produitCommande = produitCommande;
	}
	
	public int getIdLigne() {
		return IdLigne;
	}
	public void setIdLigne(int idLigne) {
		IdLigne = idLigne;
	}
	public int getIdCommande() {
		return IdCommande;
	}
	public void setIdCommande(int idCommande) {
		IdCommande = idCommande;
	}
	public int getQuantite() {
		return Quantite;
	}
	public void setQuantite(int quantite) {
		Quantite = quantite;
	}
	
}
