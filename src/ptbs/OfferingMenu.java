package ptbs;

import javax.swing.JDialog;

public class OfferingMenu extends JDialog {

    private static final long serialVersionUID = 1L;

    public OfferingMenu() {
        System.out.println("offering  Menu Implemented.");
    }

    void showMenu(Offering theOffering) {
        setVisible(true);
    }

}
