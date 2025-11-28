public class Vol {
    
    // les attributs privés modélisent les caractéristiques du vol
    // ils sont privés pour l'encapsulation
    private String numeroVol;
    
    // ceci est un exemple d'agrégation : la classe Vol contient un objet
    // de la classe CompagnieAerienne. c'est une association forte.
    private CompagnieAerienne compagnie; 
    
    private String villeDepart;
    private String villeArrivee;
    private String dateDepart;
    private int capaciteMax;

    
    // constructeur : cette méthode est appelée pour créer et initialiser
    // un nouvel objet Vol avec toutes ses informations
    public Vol(String numeroVol, CompagnieAerienne compagnie, String depart, String arrivee, String date, int capacite) {
        this.numeroVol = numeroVol;
        this.compagnie = compagnie;
        this.villeDepart = depart;
        this.villeArrivee = arrivee;
        this.dateDepart = date;
        this.capaciteMax = capacite;
    }

    
    // les "getters" (accesseurs) permettent de lire les attributs privés
    public String getNumeroVol() {
        return numeroVol;
    }

    public CompagnieAerienne getCompagnie() {
        // ce getter retourne l'objet CompagnieAerienne associé à ce vol
        return compagnie;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }
    
    // les "setters" (mutateurs) permettent de modifier les attributs privés
    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }
    
    // on pourrait ajouter d'autres setters ici (setVilleDepart, setCapaciteMax, etc.)
    // mais pour l'exemple, un seul suffit pour démontrer le concept.

    
    // la méthode toString() permet d'afficher l'objet Vol de manière lisible 
    // lorsqu'on utilise System.out.println(monVol)
    public String toString() {
        return "Vol " + numeroVol + " | Compagnie: " + compagnie.getNom() + 
               " | Départ: " + villeDepart + " | Arrivée: " + villeArrivee + 
               " | Date: " + dateDepart + " | Capacité: " + capaciteMax;
    }
}
