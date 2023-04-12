package login;

public class UserView {
    private static UserRepository repository = new UserRepository();

    public UserView() {
    }

    public void start() {
        while(true) {
            System.out.println("        [ 메 인 화 면 ]");
            System.out.println("1. 로그인하기");
            System.out.println("2. 회원가입하기");
            System.out.println("3. 관리자 계정으로 로그인");
            switch (Utility.input("번호 입력 >> ")) {
                case "1":
                    this.loginStart();
                    break;
                case "2":
                    userSys.UserView.start();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("메뉴 번호로 입력해주세요");
            }
        }
    }

    private void loginStart() {
        String inputId = Utility.input("# 아이디 입력 : ");
        String inputPwd = Utility.input("# 비밀번호 입력 : ");

        try {
            repository.loginValidate(inputId, inputPwd);
        } catch (LoginValidateException var4) {
            System.out.println(var4.getMessage());
        }

    }

    private void joinStart() {

    }
}
