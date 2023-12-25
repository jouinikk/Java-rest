package Entities;

public class Produit {
    private int id;
    private String name;
    private  String description;
    private float prix;
    private Categorie cat;

    public Produit(Categorie cat) {
        this.cat = cat;
    }

    public Produit(int id, String name, String description, float prix, Categorie cat) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.prix = prix;
        this.cat = cat;
    }

    public Produit() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }

    public Categorie getCat() {
        return cat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", cat=" + cat +
                '}';
    }
}
