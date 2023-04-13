package sportsFacArea.sportrentlist;

import static login.Utility.input;

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

    public void soccerRentList() { // 축구장 렌트할 물건 보여주고 입력받기
        System.out.println("1. 축구 유니폼 [개당 1000원]");
        System.out.println("2. 축구화 [개당 2000원]");
        System.out.println("3. 축구공 [개당 1000원]");
        System.out.println("4. 종료");

        String inputRentNum = input("# 빌릴 물건을 번호로 입력하세요 >> ");
        try {
            switch (inputRentNum){
                case "1":
                    setSoccerUniform (Integer.parseInt(input("빌릴 유니폼의 갯수를 입력하세요 >> ")));
                    soccerRentList();
                    break;
                case "2":
                    setSoccerShoes(Integer.parseInt(input("빌릴 축구화 갯수를 입력하세요 >> ")));
                    soccerRentList();
                    break;
                case "3":
                    setSoccerBall(Integer.parseInt(input("빌릴 축구공 갯수를 입력하세요 >> ")));
                    soccerRentList();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("잘못된 입력입니다");
                    soccerRentList();
            }
        }catch (NumberFormatException e){
            System.out.println("잘못된 입력입니다");
            soccerRentList();
        }

    }

}
