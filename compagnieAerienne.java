
public class CompagnieAerienne {
    
  
    private String nom;
    private String codeIATA; 
    

    public CompagnieAerienne(String nom, String codeIATA) {
        this.nom = nom;
        this.codeIATA = codeIATA;
    }
    

    
    public String getNom() {
        return nom;
    }

    public String getCodeIATA() {
        return codeIATA;
    }
    
  
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodeIATA(String codeIATA) {
        this.codeIATA = codeIATA;
    }
    


    public String toString() {
        return nom + " (" + codeIATA + ")";
    }
}

