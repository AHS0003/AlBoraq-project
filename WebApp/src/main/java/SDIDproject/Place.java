package SDIDproject;

public class Place {
    private int placeNo;
    private String statutPlace; // khawya wla 3amra
    public String getStatutPlace() {
        return statutPlace;
    }
    public Place(int placeNo) {
        this.placeNo = placeNo;
        this.statutPlace = "Libre";
    }
    public void setStatutPlace(String statutPlace) {
        this.statutPlace = statutPlace;
    }
    public int getPlaceNo() {
        return placeNo;
    }
    public void setPlaceNo(int placeNo) {
        this.placeNo = placeNo;
    }
    public boolean estDisponible() { // retourne un boolean li huwa 0 wla 1 , 1: khawya 0:3amra
        return statutPlace.equals("Libre");
    }
    @Override
    public String toString() {
        return "Place :" +
                "placeNo=" + placeNo +
                ", statutPlace='" + statutPlace;
    }
}
