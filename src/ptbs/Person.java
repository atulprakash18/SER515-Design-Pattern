package ptbs;

import java.util.Iterator;
abstract public class Person {

    int type = 0;
    String userName;
    ProductList productList;
    ProductMenu theProductMenu;
    Product currentProduct;
    Trade currentTrade;

    public Person() {
        productList = new ProductList();
    }

    abstract public ProductMenu createProductMenu(Product theProduct, int theCategory);

    public void showAddButton() {
        theProductMenu.showAddButtons();
    }

    public void showViewButtons() {
        theProductMenu.showViewButtons();
    }

    public void showComboxes() {
        theProductMenu.showComboxes();
    }

    public void showRadios() {
        theProductMenu.showRadios();
    }

    public void show() {
        theProductMenu.setVisible(true);
    }

    public boolean ifLogout() {
        return theProductMenu.ifLogout();
    }


    public boolean showMenu() {
        Iterator<?> theIter = currentProduct.tradeList.iterator();
        theProductMenu.theProduct = currentProduct;
        Trade theTrade;
        while (theIter.hasNext()) {
            theTrade = (Trade) theIter.next();
            theProductMenu.tradeCombox.addItem(theTrade);
        }
        return false;
    }

    public ProductList getProductList() {
        return productList;
    }

    public void addProduct(Product theProduct) {
        productList.add(theProduct);
    }

}
