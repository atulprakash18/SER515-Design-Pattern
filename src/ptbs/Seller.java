package ptbs;

public class Seller extends Person {
    public Seller() {
        type = 1; // type=1 :instructor
    }

    public ProductMenu createProductMenu(Product theProduct, int theLevel) {
        if (theLevel == 0)
        {
            theProduct = new HighLevelProductMenu();
        } else // 1: LowLevel
        {
            theProduct = new LowLevelProductMenu();
        }
        return theProduct;
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
