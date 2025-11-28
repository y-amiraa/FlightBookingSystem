public class CompagnieAerienne {
    
    // les attributs sont privés pour l'encapsulation (on ne peut pas y accéder directement)
    private String nom;
    private String codeIATA; // ceci est le code unique à deux lettres de la compagnie (indispensable en aviation commerciale)
    
    // constructeur : il permet de créer un objet CompagnieAerienne et de définir
    // son nom et son code dès sa création
    public CompagnieAerienne(String nom, String codeIATA) { 
        this.nom = nom;
        this.codeIATA = codeIATA;
    }
    
    // les "getters" (accesseurs) permettent de lire la valeur des attributs privés
    public String getNom() {
        return nom;
    }

    public String getCodeIATA() {
        return codeIATA;
    }
    
    // les "setters" (mutateurs) permettent de modifier la valeur des attributs privés
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodeIATA(String codeIATA) {
        this.codeIATA = codeIATA;
    }
    
    // la méthode toString() retourne une description de l'objet pour l'affichage
    public String toString() {
        return nom + " (" + codeIATA + ")";
    }
}
