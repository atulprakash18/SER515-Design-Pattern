package ptbs;

import java.util.ArrayList;

public class Product {

    String productName;
    public ArrayList<Trade> tradeList = new ArrayList<Trade>();
    int numberOfTrade;
    int productCategory;
    boolean accepted = false;

    public boolean isAccepted() {
        return accepted;
    }

    public Product(String strProduct, int theCategory) {
        this.productName = strProduct;
        this.productCategory = theCategory;
        this.numberOfTrade = 0;
    }

//    public int getproductCategory() {
//        return productCategory;
//    }

    public void addAssignment(Trade newTrade) {
        tradeList.add(newTrade);
    }

    public String toString() {
        return productName;
    }

    void accept(NodeVisitor visitor) {
        visitor.visitProduct(this);
        accepted = true;
    }

}
