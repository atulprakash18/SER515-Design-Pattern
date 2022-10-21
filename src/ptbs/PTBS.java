package ptbs;

public class PTBS {


    static Facade theFacade = new Facade();

    public PTBS() {
        System.out.println("HACS Implemented");
    }

    public static void main(String[] args) {
//        UserInfoItem userinfoitem = new UserInfoItem();
//        theFacade.createCourseList();
//        while (true) {
//            boolean bExit = false;
//            bExit = Facade.login(userinfoitem);
//            if (bExit)
//                break;
//            theFacade.createUser(userinfoitem);
//            theFacade.attachCourseToUser();
//            if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student) // if is a student remind him of the due date
//                theFacade.remind();
//            boolean bLogout = false;
//            while (!bLogout) {
//                bLogout = theFacade.selectCourse();
//                if (bLogout)
//                    break;
//                bLogout = theFacade.courseOperation();
//            }
//        }
        System.out.println("Hello world!");
    }
}

