package login;

public class UserInfo {
    private String userId; // 로그인 아이디
    private String userPwd; // 로그인 비밀번호
    private String userName;
    private String userArea;
    private int userAge;
    private Gender gender;
    private String userPhoneNum;

    public UserInfo() {}

    public UserInfo(String userId, String userPwd, String userName, String userArea, int userAge, Gender gender, String userPhoneNum) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userArea = userArea;
        this.userAge = userAge;
        this.gender = gender;
        this.userPhoneNum = userPhoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "UserInfo[" +
                "userId: '" + userId + '\'' +
                ", userPwd: '" + userPwd + '\'' +
                ", userName: '" + userName + '\'' +
                ", userArea: '" + userArea + '\'' +
                ", userAge: " + userAge +
                ", gender: " + gender +
                ", userPhoneNum: '" + userPhoneNum + '\'' +
                ']';
    }
}
