package ptbs;

public class PTBS {


    static Facade theFacade = new Facade();

    public PTBS() {
        System.out.println("HACS Implemented");
    }

    public static void main(String[] args) {
        System.out.println("run success");
//        UserInfoItem userinfoitem = new UserInfoItem();
//        theFacade.createProductList();
//        while (true) {
//            boolean bExit = false;
//            bExit = Facade.login(userinfoitem);
//            if (bExit)
//                break;
//            theFacade.createUser(userinfoitem);
//            theFacade.attachProductToUser();
//            if (userinfoitem.userType == UserInfoItem.USER_TYPE.Buyer) // if is a student remind him of the due date
//                theFacade.remind();
//            boolean bLogout = false;
//            while (!bLogout) {
//                bLogout = theFacade.selectProduct();
//                if (bLogout)
//                    break;
//                bLogout = theFacade.productOperation();
//            }
//        }
//        System.out.println("Hello world!");
    }
}

