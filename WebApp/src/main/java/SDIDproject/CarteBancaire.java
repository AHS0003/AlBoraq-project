package SDIDproject;

public class CarteBancaire {
    private int idCarte;
    private String nomPorteur;
    private String numeroCarte;
    private int moisExpiration;
    private int anneeExpiration;
    private String codeVerification;

    // Constructor
    public CarteBancaire(int idCarte, String nomPorteur, String numeroCarte, int moisExpiration, int anneeExpiration, String codeVerification) {
        this.idCarte = idCarte;
        this.nomPorteur = nomPorteur;
        this.numeroCarte = numeroCarte;
        this.moisExpiration = moisExpiration;
        this.anneeExpiration = anneeExpiration;
        this.codeVerification = codeVerification;
    }

    // Getters and Setters
    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public String getNomPorteur() {
        return nomPorteur;
    }

    public void setNomPorteur(String nomPorteur) {
        this.nomPorteur = nomPorteur;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public int getMoisExpiration() {
        return moisExpiration;
    }

    public void setMoisExpiration(int moisExpiration) {
        this.moisExpiration = moisExpiration;
    }

    public int getAnneeExpiration() {
        return anneeExpiration;
    }

    public void setAnneeExpiration(int anneeExpiration) {
        this.anneeExpiration = anneeExpiration;
    }

    public String getCodeVerification() {
        return codeVerification;
    }

    public void setCodeVerification(String codeVerification) {
        this.codeVerification = codeVerification;
    }
}