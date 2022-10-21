package ptbs;

public class Buyer extends Person {

    public Buyer() {
        type = 0; // type=0:
    }

    public ProductMenu createProductMenu(Product theProduct, int theLevel) {
        if (theLevel == 0)
        {
            theProductMenu = new HighLevelCourseMenu();
        } else // 1: LowLevel
        {
            theProductMenu = new LowLevelCourseMenu();
        }
        return theProductMenu;
    }

    @Override
    public boolean showMenu() {
        super.showMenu();
        showViewButtons();
        showComboxes();
        showRadios();
        show();
        return ifLogout();
    }
}
