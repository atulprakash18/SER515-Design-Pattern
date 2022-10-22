package ptbs;

public class Buyer extends Person {

    public Buyer() {
        type = 0; // type=0:
    }

    public ProductMenu createProductMenu(Product theProduct, int theLevel) {

        // create Products function
        if (theLevel == 0)
        {
            theProductMenu = new HighLevelProductMenu();
        } else // 1: LowLevel
        {
            theProductMenu = new LowLevelProductMenu();
        }
        return theProductMenu;
    }

    @Override
    public boolean showMenu() {
        //show menu
        super.showMenu();
        showViewButtons();
        showComboxes();

        //show Radios
        showRadios();
        show();
        return ifLogout();
    }
}
