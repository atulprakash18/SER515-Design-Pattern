package ptbs;

import java.util.Iterator;

public class ProductIterator implements Iterator<Object> {
    ProductList theProductList;
    int currentProductNumber = -1;

    public ProductIterator() {
        System.out.println("Course Iterator Implemeted");
    }

    public ProductIterator(ProductList productList) {
        theProductList = productList;
    }

    public ProductList getTheCourseList() {
        return theProductList;
    }

    public boolean hasNext() {
        if (currentProductNumber >= theProductList.size() - 1)
            return false;
        else
            return true;
    }

    public Object next() {
        if (hasNext() == true) {
            currentProductNumber++;
            return theProductList.get(currentProductNumber);
        } else {
            return null;
        }
    }

    public void remove() {
        theProductList.remove(currentProductNumber);
    }

    // the next Course that fits the given CourseName
    public Object next(String ProductName) {
        Product theProduct;
        theProduct = (Product) next();
        while (theProduct != null) {
            if (ProductName.compareTo(theProduct.toString()) == 0) {
                return theProduct;
            }
            theProduct = (Product) next();
        }
        return null;
    }

}