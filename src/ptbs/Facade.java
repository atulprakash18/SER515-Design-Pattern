package ptbs;

import java.io.BufferedReader;
import java.io.FileReader;

public class Facade {
    public int userType;
    private Product theSelectProduct = null;
    private int nProductCategory = 0;
    ProductList theProductList;
    Person thePerson;

    public Facade() {
        System.out.println("Facade Implemented");
    }

    static public boolean login(UserInfoItem userinfoItem) {
        Login login = new Login();
        login.setModal(true);
        login.setVisible(true);
        userinfoItem.strUserName = login.getUserName();
        userinfoItem.userType = login.getUserType();
        return login.isExit();
    }

    void addTrading(Product theProduct) {
        TradingMenu theTradingMenu;
        if (thePerson.type == 0)// student
        {
            theTradingMenu = new BuyerTradingMenu();
        } else {
            theTradingMenu = new SellerTradingMenu();
        }
        Trade theTrading = new Trade();
        theTradingMenu.showMenu(theTrading, thePerson);
        theProduct.addTrading(theTrading);
    }

    void viewTrading(Trade theTrading) {
        TradingMenu theTradingMenu;
        if (thePerson.type == 0)
        {
            theTradingMenu = new BuyerTradingMenu();
        } else {
            theTradingMenu = new SellerTradingMenu();
        }
        theTradingMenu.showMenu(theTrading, thePerson);
    }

    void markOffering(Offering theOffer) {
        OfferingMenu offerMenu = new OfferingMenu();
        offerMenu.showMenu(theOffer);
    }

    void viewOffering(Trade theTrading) {
        Offering theOffer;
        OfferingIterator theOfferIterator;
        theOfferIterator = theTrading.getOfferingIterator();
        theOffer = (Offering) theOfferIterator.next();
        while (theOffer != null) {
            theOffer.setReported(true);
            theOffer = (Offering) theOfferIterator.next();
        }
    }

    void submitOffering(Trade theTrading, Offering theOffer) {
        theTrading.addOffering(theOffer);
    }

    void remind() {
        Reminder theReminder = new Reminder();
        theReminder.showReminder(thePerson.getProductList());
    }

    void createUser(UserInfoItem userinfoitem) {
        if (userinfoitem.userType == UserInfoItem.USER_TYPE.Buyer) // student
        {
            thePerson = new Buyer();
        } else
        {
            thePerson = new Seller();
        }
        thePerson.userName = userinfoitem.strUserName;
    }

    void createProductList() {
        theProductList = new ProductList();
        theProductList.initializeFromFile("ProductInfo.txt");
    }

    public ProductList getTheProductList() {
        return theProductList;
    }

    void attachProductToUser() {
        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(System.getProperty("user.dir") + "//UserProduct.txt"));
            String aline, strUserName, strProductName;
            while ((aline = file.readLine()) != null) // not the EOF
            {
                strUserName = getUserName(aline);
                strProductName = getProductName(aline);
                if (strUserName.compareTo(thePerson.userName) == 0)
                {
                    theSelectProduct = findProductByProductName(strProductName);
                    if (theSelectProduct != null)
                    {
                        thePerson.addProduct(theSelectProduct);
                    }
                }
            }
        } catch (Exception ee) {
            ;
        }
    }


    private String getUserName(String aline) {
        int Sep = aline.lastIndexOf(':');
        return aline.substring(0, Sep);
    }

    private String getProductName(String aline) {
        int Sep = aline.lastIndexOf(':');
        return aline.substring(Sep + 1, aline.length());
    }

    public boolean selectProduct() {
        ProductSelectDlg theDlg = new ProductSelectDlg();
        theSelectProduct = theDlg.showDlg(thePerson.productList);
        thePerson.currentProduct = theSelectProduct;
        nProductCategory = theDlg.nProductCategory;
        return theDlg.isLogout();
    }

    public boolean productOperation() {
        thePerson.createProductMenu(theSelectProduct, nProductCategory);
        return thePerson.showMenu();
    }

    private Product findProductByProductName(String strProductName) {
        ProductIterator Iterator = new ProductIterator(theProductList);
        return (Product) Iterator.next(strProductName);
    }

}