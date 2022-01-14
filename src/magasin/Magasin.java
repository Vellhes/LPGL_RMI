package magasin;

public class Magasin {

	private String Adresse;
	private String Nom;
	private int Identifiant;
	
	
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public int getIdentifiant() {
		return Identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.Identifiant = identifiant;
	}
	@Override
	public String toString() {
		return Nom;
	}
	public Magasin(String adresse, String nom, int identifiant) {
		super();
		Adresse = adresse;
		Nom = nom;
		this.Identifiant = identifiant;
	}
	public Magasin() {
		super();
	}

	
}
