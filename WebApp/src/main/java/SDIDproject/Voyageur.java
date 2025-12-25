package SDIDproject;

public class Voyageur {
    private static int  unique_code_voyageur =1;
    private String nom;
    private String email;
    private String numero_telephone;
    private int age;
    private String password;

    public Voyageur(String nom, String email, String numero, int age) {
        unique_code_voyageur = generationCodeUnique();
        this.nom = nom;
        this.email = email;
        this.numero_telephone = numero;
        this.age = age;
    }
    public Voyageur(String nom, String email, String numero, int age, String password) {
        unique_code_voyageur = generationCodeUnique();
        this.nom = nom;
        this.email = email;
        this.numero_telephone = numero;
        this.age = age;
        this.password = password;
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public static int getUnique_code_voyageur() {return unique_code_voyageur;}
    public static void setUnique_code_voyageur(int unique_code_voyageur) {Voyageur.unique_code_voyageur = unique_code_voyageur;}
    private synchronized int generationCodeUnique() {
        return unique_code_voyageur++;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNumero() {
        return numero_telephone;
    }
    public void setNumero(String numero) {
        this.numero_telephone = numero;
    }
    public int getCode() {
        return unique_code_voyageur;
    }
    public void setCode(int code) {
        unique_code_voyageur = code;
    }
    public String getNumero_telephone() {
        return numero_telephone;
    }
    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    // hedi katder l affichage les infos dyel Voyageur
    public String toString() {
        return "Voyageur{" +
                "unique_code_voyageur=" + unique_code_voyageur +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", numero_telephone=" + numero_telephone +
                '}';
    }
}
