package ptbs;

public class Seller extends Person {
    public Seller() {
        type = 1; // type=1 :instructor
    }

    public ProductMenu createProductMenu(Product theProduct, int theLevel) {
        if (theLevel == 0)
        {
            theProductMenu = new HighLevelProductMenu();
        } else // 1: LowLevel
        {
            theProductMenu = new LowLevelProductMenu();
        }
        return theProductMenu;
    }

    public boolean showMenu() {
        super.showMenu();
        showAddButton();
        showViewButtons();
        showComboxes();
        showRadios();
        show();
        return ifLogout();
    }
}
