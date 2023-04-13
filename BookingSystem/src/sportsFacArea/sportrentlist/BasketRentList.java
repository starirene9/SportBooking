package sportsFacArea.sportrentlist;

import static login.Utility.input;

public class BasketRentList {
    private int basketUniform;
    private int colorCorn;
    private int basketBall;

    public BasketRentList() {
    }

    public BasketRentList(int soccerUniform, int soccerShoes, int soccerBall) {
        this.basketUniform = soccerUniform;
        this.colorCorn = soccerShoes;
        this.basketBall = soccerBall;
    }

    public int getBasketUniform() {
        return basketUniform;
    }

    public void setBasketUniform(int basketUniform) {
        this.basketUniform = basketUniform;
    }

    public int getColorCorn() {
        return colorCorn;
    }

    public void setColorCorn(int colorCorn) {
        this.colorCorn = colorCorn;
    }

    public int getBasketBall() {
        return basketBall;
    }

    public void setBasketBall(int basketBall) {
        this.basketBall = basketBall;
    }

    public String allInfo(){
        return String.format("대여한 유니폼의 개수 : %d\n대여한 축구화의 개수 %d\n대여한 축구공의 개수 %d\n", getBasketUniform(), getColorCorn(), getBasketBall());
    }
    public int rentTotal(){
        return getBasketUniform() * 1000 + getColorCorn() * 1000 + getBasketBall() * 1000;
    }

    public int rentCount(){
        return getBasketUniform() + getColorCorn() + getBasketBall();
    }

    public void basketRentList() { // 축구장 렌트할 물건 보여주고 입력받기
        System.out.println("1. 농구 조끼 [개당 1000원]");
        System.out.println("2. 컬러콘 [개당 1000원]");
        System.out.println("3. 농구공 [개당 1000원]");
        System.out.println("4. 종료");

        String inputRentNum = input("# 빌릴 물건을 번호로 입력하세요 >> ");
        try {
            switch (inputRentNum){
                case "1":
                    setBasketUniform(Integer.parseInt(input("빌릴 유니폼의 갯수를 입력하세요 >> ")));
                    basketRentList();
                    break;
                case "2":
                    setColorCorn(Integer.parseInt(input("빌릴 축구화 갯수를 입력하세요 >> ")));
                    basketRentList();
                    break;
                case "3":
                    setBasketBall(Integer.parseInt(input("빌릴 축구공 갯수를 입력하세요 >> ")));
                    basketRentList();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("잘못된 입력입니다");
                    basketRentList();
            }
        }catch (NumberFormatException e){
            System.out.println("잘못된 입력입니다");
            basketRentList();
        }

    }

}
