public class Passager {
    
    private String nom;
    private String prenom;
    private String numeroPasseport;

    // Constructeur
    public Passager(String nom, String prenom, String numeroPasseport) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroPasseport = numeroPasseport;
    }
    
    // Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroPasseport() {
        return numeroPasseport;
    }
    
    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumeroPasseport(String numeroPasseport) {
        this.numeroPasseport = numeroPasseport;
    }
}
