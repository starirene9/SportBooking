package sportsFacArea;

public class SportsFacList {
    private String soccerPac;
    private String basketPac;
    private String swimmingPac;

    public SportsFacList() {}

    public SportsFacList(String soccerPac, String basketPac, String swimmingPac) {
        this.soccerPac = soccerPac;
        this.basketPac = basketPac;
        this.swimmingPac = swimmingPac;
    }

    public String getSoccerPac() {
        return soccerPac;
    }

    public void setSoccerPac(String soccerPac) {
        this.soccerPac = soccerPac;
    }

    public String getBasketPac() {
        return basketPac;
    }

    public void setBasketPac(String basketPac) {
        this.basketPac = basketPac;
    }

    public String getSwimmingPac() {
        return swimmingPac;
    }

    public void setSwimmingPac(String swimmingPac) {
        this.swimmingPac = swimmingPac;
    }

    @Override
    public String toString() {
        return "SportsFacilityList{" +
                "soccerPac='" + soccerPac + '\'' +
                ", basketPac='" + basketPac + '\'' +
                ", swimmingPac='" + swimmingPac + '\'' +
                '}';
    }
}
