package magasin;

import java.util.List;

public class Utilisateur {

	String prenom,nom,mail,mdp,adresse;

	public Utilisateur(String prenom, String nom, String mail, String mdp, String adresse){
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
		this.adresse = adresse;
	}

	public String toString() {
		return "Utilisateur [prenom=" + prenom + ", nom=" + nom + ", mail=" + mail + ", mdp=" + mdp + ", adresse="
				+ adresse + "]";
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public static void inscription(Utilisateur utilisateur, List<Utilisateur> list) {
		list.add(utilisateur);
	}

	public static void connexion(Utilisateur utilisateur, List<Utilisateur> list) {
		for(int i = 0;i < list.size() ; i++) {
			if(utilisateur.getMail() == list.get(i).getMail() && utilisateur.getMdp() == list.get(i).getMdp()) {
				System.out.println("connecté");
			}
		}
	}
		
}
	
