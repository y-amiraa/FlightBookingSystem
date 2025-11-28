public class Vol {
    
    private String numeroVol;
    private CompagnieAerienne compagnie; // Agrégation
    private String villeDepart;
    private String villeArrivee;
    private String dateDepart;
    private int capaciteMax;

    // Constructeur
    public Vol(String numeroVol, CompagnieAerienne compagnie, String depart, String arrivee, String date, int capacite) {
        this.numeroVol = numeroVol;
        this.compagnie = compagnie;
        this.villeDepart = depart;
        this.villeArrivee = arrivee;
        this.dateDepart = date;
        this.capaciteMax = capacite;
    }

    // Getters
    public String getNumeroVol() {
        return numeroVol;
    }

    public CompagnieAerienne getCompagnie() {
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
    
    // Setters (pour la démonstration des setters)
    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }
    // ... autres setters pour la complétude ...

    @Override
    public String toString() {
        return "Vol " + numeroVol + " | Compagnie: " + compagnie.getNom() + 
               " | Départ: " + villeDepart + " | Arrivée: " + villeArrivee + 
               " | Date: " + dateDepart + " | Capacité: " + capaciteMax;
    }
}
