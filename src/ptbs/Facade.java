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

    void addTrading(Person thePerson) {
        TradingMenu theTradingMenu;
        if (thePerson.type == 0)// student
        {
            theTradingMenu = new BuyerTradingMenu();
        } else {
            theTradingMenu = new SellerTradingMenu();
        }
        Trading theTrading = new Trading();
        theTradingMenu.showMenu(theTrading, thePerson);
        thePerson.addTrading(theTrading);
    }

    void viewTrading(Trading theTrading) {
        TradingMenu theTradingMenu;
        if (thePerson.type == 0)
        {
            theTradingMenu = new BuyerTradingMenu();
        } else {
            theTradingMenu = new SellerTradingMenu();
        }
        theTradingMenu.showMenu(theTrading, thePerson);
    }

    // functions for InstructorTradingMenu
    /*
     * this function will grade the give Solution: theSolution this function calls
     */

    void viewOffering(Offer theOffer) {
        OfferMenu offerMenu = new OfferMenu();
        offerMenu.showMenu(theOffer);
    }

    void markOffering(Trading theTrading) {
        Offer theOffer;
        OfferIterator theOfferIterator;
        theOfferIterator = theTrading.getOfferIterator();
        theOffer = (Offer) theOfferIterator.next();
        while (theOffer != null) {
            theOffer.setReported(true);
            theOffer = (Offer) theOfferIterator.next();
        }
    }

    // functions for StudentTradingMenu
    void submitOffering(Trading theTrading, Offer theOffer) {
        theTrading.addOffer(theOffer);
    }

    void remind() {
        Reminder theReminder = new Reminder();
        theReminder.showReminder(thePerson.getTradeList());
    }

    void createUser(UserInfoItem userinfoitem) {
        if (userinfoitem.userType == UserInfoItem.USER_TYPE.Buyer) // student
        {
            thePerson = new Buyer();
        } else // instructor
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

    void AttachProductToUser() {
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

    public boolean SelectProduct() {
        ProductSelectDlg theDlg = new ProductSelectDlg();
        theSelectProduct = theDlg.showDlg(thePerson.productList);
        thePerson.currentProduct = theSelectProduct;
        nProuctCategory = theDlg.nProuctCategory;
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