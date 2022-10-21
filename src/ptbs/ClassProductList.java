package ptbs;

package hacs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClassProductList{

    private static final long serialVersionUID = 1L;

    public ClassProductList() {
        System.out.println("Product list implemented");
    }

    // initialize the list by reading from the file.
    void initializeFromFile(String theFileName) {
        try {
            BufferedReader file;
            String strProductName = null;
            file = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\" + theFileName));
            while ((strProductName = file.readLine()) != null) {
                Product theProduct = new Product(strProductName, 0);
                add(theProduct);
            }
            file.close();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Product findProductByproductName(String ProductName) {
        int nProductCount = size();
        for (int i = 0; i < nProductCount; i++) {
            Product theProduct = (Product) get(i);
            if (theProduct.strProductName.compareTo(ProductName) == 0)
                return theProduct;
        }
        return null;
    }

}
