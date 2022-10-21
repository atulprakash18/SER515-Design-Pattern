package ptbs;

public class Person {

    int type = 0; // type=0 : student, type=1 instructor
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

    // show the assignment list
    public boolean showMenu() {
        // create a iterator for the assignment list
        // Iterator theIter=new ListIterator(CurrentCourse.AssList );
        Iterator<?> theIter = currentProduct.tradeList.iterator();
        theProductMenu.theProduct = currentProduct;
        Assignment theAssignment;
        while (theIter.hasNext()) {
            theAssignment = (Trade) theIter.next();
            theProductMenu.tradeCombox.addItem(theAssignment);
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
