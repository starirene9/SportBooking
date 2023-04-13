package userSys;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import static userSys.Utility.*;

public class UserView {
    public static UserView uv;
    static UserInfo userInfo;
    private static UserRepository urp;


    static {

        urp = new UserRepository();

    }

    public static void start() {

        joinMemberShip();
        urp.showList();
        urp.makeSaveFile();
    }

    private static void joinMemberShip() {
        System.out.println("==========[ 회 원 가 입 ]==========");

        // 아이디 입력
        String userId;
        while (true) {
            userId = input("# 아이디(영어 또는 숫자) : ");

            // 아이디 중복검사
            if (urp.isDuplicate(userId)) {
                System.out.println("중복된 아이디입니다. 다시 입력해주세요");
            } else {
                // 아이디 올바른 패턴 분석
                if (!userId.equals("") && isAlphaNumeric(userId)) {
                    System.out.println("입력 가능한 아이디 입니다.");
                    break;
                } else {
                    System.out.println("올바른 ID을 입력해주세요");
                }
            }
        }

        // 비밀번호 입력
        String userPwd;
        while (true) {
            userPwd = input("# 비밀번호(최대 13자) : ");
            // 비밀번호 글자수 13이하로 제한
            if (stringLength(userPwd, 13)) {
                break;
            } else {
                System.out.println("비밀번호가 너무 깁니다. 10이하로 적어주세요");
            }
        }
        // 이름 입력
        String userName;

        while (true) {
            userName = input("# 이름 : ");
            if (isAlphaKorean(userName)) {
                break;
            } else {
                System.out.println("올바른 이름을 입력하세요");
            }
        }

        // 거주지 입력
        System.out.println("거주지를 입력하세요");
        System.out.println("강남구 // 강동구 // 강서구 // 광진구 // 구로구 // 동대문구 // 동작구 //\n해당 구에 거주하시는 분은 혜택을 받으실수있습니다.");
        String userArea = input("# 거주지 입력(ex 서울특별시 강남구): ");

        // 전화번호 입력
        String userPhoneNum;
        while (true) {
            userPhoneNum = input("# 핸드폰 번호(-포함) : ");
            // 올바른 값 확인
            if (checkPhoneNum(userPhoneNum)) {
                break;
            }
        }

        //생년월일 입력
        String userAge;

        while (true) {
            userAge = input("# 생년월일(6자리) : ");
            // 올바른 값 확인 && 글자수 제한
            if (checkDate(userAge)) {
                break;
            } else {
                System.out.println("올바른값을 입력해주세요(6자리)");
            }
        }


        // 객체생성
        userInfo = new UserInfo(userId, userPwd, userName, userArea, userAge, userPhoneNum);


        // UserRepository 에저장
        urp.register(userInfo);

    }

    /**
     * 아이디에 영어와 숫자로만 제한하는 함수
     *
     * @param inputId 입력하는 아이디
     * @return true: 영어와 숫자
     * @return false: 영어와 숫자 이의의 값
     */
    public static boolean isAlphaNumeric(String inputId) {
        return Pattern.matches("[a-zA-Z0-9]*$", inputId);
    }


    /**
     * 이름에 영어와 한국만 제한하는 함수
     *
     * @param name: 입력한 이름
     * @return true: 영어와 한국어만 사용
     * @return false: 영어와 한국어 외의 String 사용
     */
    public static boolean isAlphaKorean(String name) {
        return Pattern.matches("[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]*$", name);
    }

    /**
     * 글자수를 제한하는 함수
     *
     * @param s      : String 타입 변수
     * @param length : 제한하고 싶은 글자수
     * @return true : 글자수가 제한글자수보다 작을시
     * @return false :글자수가 제한글자수를 초과할시
     */
    static boolean stringLength(String s, int length) {
        if (s.length() > length) {
            System.out.printf("%d 자리 이하로 입력해주세요\n", length);
            return false;
        }
        return true;
    }


    /**
     * 올바른 전화번호 인지 검사하는 기능
     *
     * @param userPhoneNum 검사하고 싶은 핸드폰 번호
     * @return true: 올바른 번호 형태
     * @return false: 틀린 번호 형태
     */
    public static boolean checkPhoneNum(String userPhoneNum) {
        String pattern2 = "^\\d{3}-\\d{3,4}-\\d{4}$";
        if (Pattern.matches(pattern2, userPhoneNum)) {
            return true;
        } else {
            System.out.println("올바른 휴대전화 번호를 입력해주세요. ");
            return false;
        }
    }


    /**
     * 올바른 생년월일 인지 검사하는 기능
     *
     * @param checkDate 정수로 변환될수있는 String
     * @return true : 패턴에 맞은 생년월일
     * @return false : 패턴과 다른 생년월일
     */
    public static boolean checkDate(String checkDate) {
        try {
            SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyMMdd");
            dateFormatParser.setLenient(false);
            dateFormatParser.parse(checkDate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
