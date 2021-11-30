package magasin;

import java.util.List;

public class Commande {

	private int IdMagasin;
	private int IdCommande;
	private String dateCommande;
	private List<LigneCommande> listLC ;
	public int getIdMagasin() {
		return IdMagasin;
	}
	public void setIdMagasin(int idMagasin) {
		IdMagasin = idMagasin;
	}
	public int getIdCommande() {
		return IdCommande;
	}
	public void setIdCommande(int idCommande) {
		IdCommande = idCommande;
	}
	public String getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	public List<LigneCommande> getListLC() {
		return listLC;
	}
	public void setListLC(List<LigneCommande> listLC) {
		this.listLC = listLC;
	}
	public Commande(int idMagasin, int idCommande, String dateCommande, List<LigneCommande> listLC) {
		super();
		IdMagasin = idMagasin;
		IdCommande = idCommande;
		this.dateCommande = dateCommande;
		this.listLC = listLC;
	}
	@Override
	public String toString() {
		return "Commande [IdMagasin=" + IdMagasin + ", IdCommande=" + IdCommande + ", dateCommande=" + dateCommande
				+ ", listLC=" + listLC + "]";
	}
	
	
}
