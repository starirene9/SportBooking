package sportsFacArea.sportrentlist;

import static login.Utility.input;

public class SwimRentList {
    private int swimHat;
    private int swimGlass;
    private int swimTube;

    public SwimRentList() {
    }

    public SwimRentList(int soccerUniform, int soccerShoes, int soccerBall) {
        this.swimHat = soccerUniform;
        this.swimGlass = soccerShoes;
        this.swimTube = soccerBall;
    }

    public int getSwimHat() {
        return swimHat;
    }

    public void setSwimHat(int swimHat) {
        this.swimHat = swimHat;
    }

    public int getSwimGlass() {
        return swimGlass;
    }

    public void setSwimGlass(int swimGlass) {
        this.swimGlass = swimGlass;
    }

    public int getSwimTube() {
        return swimTube;
    }

    public void setSwimTube(int swimTube) {
        this.swimTube = swimTube;
    }

    public String allInfo(){
        return String.format("대여한 유니폼의 개수 : %d\n대여한 축구화의 개수 %d\n대여한 축구공의 개수 %d\n", getSwimHat(), getSwimGlass(), getSwimTube());
    }
    public int rentTotal(){
        return getSwimHat() * 1000 + getSwimGlass() * 2000 + getSwimTube() * 1000;
    }

    public int rentCount(){
        return getSwimHat() + getSwimGlass() + getSwimTube();
    }

    public void swimRentList() { // 축구장 렌트할 물건 보여주고 입력받기
        System.out.println("1. 축구 유니폼 [개당 1000원]");
        System.out.println("2. 축구화 [개당 2000원]");
        System.out.println("3. 축구공 [개당 1000원]");
        System.out.println("4. 종료");

        String inputRentNum = input("# 빌릴 물건을 번호로 입력하세요 >> ");
        try {
            switch (inputRentNum){
                case "1":
                    setSwimHat(Integer.parseInt(input("빌릴 유니폼의 갯수를 입력하세요 >> ")));
                    swimRentList();
                    break;
                case "2":
                    setSwimGlass(Integer.parseInt(input("빌릴 축구화 갯수를 입력하세요 >> ")));
                    swimRentList();
                    break;
                case "3":
                    setSwimTube(Integer.parseInt(input("빌릴 축구공 갯수를 입력하세요 >> ")));
                    swimRentList();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("잘못된 입력입니다");
                    swimRentList();
            }
        }catch (NumberFormatException e){
            System.out.println("잘못된 입력입니다");
            swimRentList();
        }

    }

}
