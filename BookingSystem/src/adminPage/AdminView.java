package adminPage;


import login.UserView;

import static login.Utility.input;

public class AdminView {
    AdminRepository ar;
    AdminPreReservedView aprv;


    public void adminMenu() {
        System.out.println("===========Admin 계정=============");
        System.out.println("#1. 시설예약 목록");
        System.out.println("#0. 로그아웃");
        aprv=new AdminPreReservedView();
        whileloop:while (true) {
            String adminInputNum = input(">>");
            switch (adminInputNum) {
                case "1":
                    System.out.println("예약목록을 보여드립니다.");
//                    ar=new AdminRepository();
//                    ar.loadReservationFile();
                    aprv.showPreList();
                    break whileloop;
                case "0":
                    System.out.println("로그아웃 하시겠습니까?[Y/N]");
                    String yOrn = input(">>");
                    switch (yOrn.toUpperCase().charAt(0)) {
                        case 'Y':
                            UserView loginView = new UserView();
                            loginView.inputUserinfo();
                            break whileloop;
                        case 'N':
                            adminMenu();
                            break;
                        default:
                            System.out.println("값을 정확하게 입력해주세요");
                    }
                    break;
                default:
                    System.out.println("올바른 값을 입력하세요");
            }
        }



    }
//    public void acceptReservation(){
//        System.out.println("==========예 약 정 보 창==========");
//        for (int i = 0; i < ar.; i++) {
//
//        }
//    }



}
