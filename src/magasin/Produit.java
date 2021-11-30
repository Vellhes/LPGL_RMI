package magasin;

public class Produit {

	private int IdProduit;
	private String NomProduit;
	private String DescriptionProduit;
	private double Tarif;
	
	public int getIdProduit() {
		return IdProduit;
	}
	
	public void setIdProduit(int idProduit) {
		IdProduit = idProduit;
	}
	
	public String getNomProduit() {
		return NomProduit;
	}
	
	public void setNomProduit(String nomProduit) {
		NomProduit = nomProduit;
	}
	
	public String getDescriptionProduit() {
		return DescriptionProduit;
	}
	
	public void setDescriptionProduit(String descriptionProduit) {
		DescriptionProduit = descriptionProduit;
	}
	
	@Override
	public String toString() {
		return "Produit [IdProduit=" + IdProduit + ", NomProduit=" + NomProduit + ", DescriptionProduit="
				+ DescriptionProduit + ", Tarif=" + Tarif + "]";
	}
	
	public double getTarif() {
		return Tarif;
	}
	
	public void setTarif(float tarif) {
		Tarif = tarif;
	}
	
	public Produit(int idProduit, String nomProduit, String descriptionProduit, double tarif) {
		super();
		IdProduit = idProduit;
		NomProduit = nomProduit;
		DescriptionProduit = descriptionProduit;
		Tarif = tarif;
	}
}
