package sportsFacArea;

public class SoccerRentList {
    private int soccerUniform;
    private int soccerShoes;
    private int soccerBall;

    public SoccerRentList() {
    }

    public SoccerRentList(int soccerUniform, int soccerShoes, int soccerBall) {
        this.soccerUniform = soccerUniform;
        this.soccerShoes = soccerShoes;
        this.soccerBall = soccerBall;
    }

    public int getSoccerUniform() {
        return soccerUniform;
    }

    public void setSoccerUniform(int soccerUniform) {
        this.soccerUniform = soccerUniform;
    }

    public int getSoccerShoes() {
        return soccerShoes;
    }

    public void setSoccerShoes(int soccerShoes) {
        this.soccerShoes = soccerShoes;
    }

    public int getSoccerBall() {
        return soccerBall;
    }

    public void setSoccerBall(int soccerBall) {
        this.soccerBall = soccerBall;
    }

    public String allInfo(){
        return String.format("대여한 유니폼의 개수 : %d\n대여한 축구화의 개수 %d\n대여한 축구공의 개수 %d\n",getSoccerUniform(),getSoccerShoes(),getSoccerBall());
    }
    public int rentTotal(){
        return getSoccerUniform() * 1000 + getSoccerShoes() * 2000 + getSoccerBall() * 1000;
    }

    public int rentCount(){
        return getSoccerUniform() + getSoccerShoes() + getSoccerBall();
    }


}
