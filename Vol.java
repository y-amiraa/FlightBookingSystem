package flightbookingsystem;
import java.util.List;
import java.util.Objects;

public class Vol {
    private String numeroVol;
    private String depart;
    private String destination;
    private String arrivee;
    private double prix;
    private String compagnie;
   


    
    

    public Vol(String numeroVol, String compagnie, String depart, String destination, String arrivee, double prix) {
        this.numeroVol = numeroVol;
        this.depart = depart;
        this.destination = destination;
        this.arrivee = arrivee;
        this.prix = prix;
        this.compagnie = compagnie;
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateArrivee() {
        return arrivee;
    }

    public void setDateArrivee(String dateArrivee) {
        this.arrivee = dateArrivee;
    }



  

    public boolean ajouterPassager(Passager p) {
        if (p == null) return false;
        return passagers.add(p);
    }

    public boolean retirerPassager(Passager p) {
        return passagers.remove(p);
    }

    public int nombrePassagers() {
        return passagers.size();
    }

    @Override
    public String toString() {
        return "Vol{" +
                "numeroVol='" + numeroVol + '\'' +
                ", compagnie='" + compagnie + '\'' +
                ", depart='" + depart + '\'' +
                ", destination='" + destination + '\'' +
                ", dateArrivee='" + arrivee + '\'' +
                ", prix=" + prix +
                ", passagers=" + passagers.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vol vol = (Vol) o;
        return Objects.equals(numeroVol, vol.numeroVol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroVol);
    }
}

