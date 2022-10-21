package ptbs;

public class UserInfoItem {

    public enum USER_TYPE {
        Buyer, Seller
    }

    String strUserName;
    USER_TYPE userType; // 0 : Student, 1: Instructor
}

