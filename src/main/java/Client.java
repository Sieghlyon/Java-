
/**
 * Hello world!
 *
 */
public class Client 
{
    
    
    private String nom;
    private String prenom;
    private int clientID;
    private String passwd;
    private String login;
    
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public String getpasswd() {
		return passwd;
	}
	public void setpasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String toString() {
		String chain = this.clientID + " " + this.nom + " " + this.prenom + " " + this.login ;
		return chain;
	}
}
