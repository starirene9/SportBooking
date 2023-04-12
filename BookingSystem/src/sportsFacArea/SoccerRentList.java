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
}
