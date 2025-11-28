public class Passager {
    
    // les attributs sont privés pour garantir l'encapsulation (ils ne sont
    // accessibles que via les méthodes get/set)
    private String nom;
    private String prenom;
    private String numeroPasseport;

 
    // constructeur : méthode appelée quand on crée un nouvel objet passager
    // cela permet d'initialiser ses propriétés (nom, prenom, passeport)
    public Passager(String nom, String prenom, String numeroPasseport) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroPasseport = numeroPasseport;
    }
    
    
    // les "getters" permettent de lire la valeur des attributs privés
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroPasseport() {
        return numeroPasseport;
    }
    
    
    // les "setters" permettent de modifier la valeur des attributs privés
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
