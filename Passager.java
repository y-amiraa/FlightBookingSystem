package flightbookingsystem;

public class Passager {
    private int id;
    private String nom;
    private String contact;


    public Passager(int id, String nom, String contact) {
        this.id = id;
        this.nom = nom;
        this.contact = contact;
    }

public int getId() {
    return id;
}
public String getNom() {
    return nom;
}

public String getContact() {
    return contact;
}   

}