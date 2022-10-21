package ptbs;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.util.Iterator;


public class ProductMenu {

    private static final long serialVersionUID = 1L;
    Product theProduct;
    boolean bLogout = true;

    JRadioButton tradeRadio = new JRadioButton();
    JComboBox<Object> tradeCombox = new JComboBox<Object>();
    JButton tradeViewButton = new JButton();
    JButton tradeAddButton = new JButton();
    JRadioButton optionRadio = new JRadioButton();
    JLabel tradeContentLable = new JLabel();
    JComboBox<Object> optionCombo = new JComboBox<Object>();
    JButton optionViewButton = new JButton();
    JButton optionAddButton = new JButton();
    JButton buttonChangeCourse = new JButton();
    JButton buttonLogout = new JButton();

    public ProductMenu() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setModal(true);
        setSize(503, 294);
    }

    private void jbInit() throws Exception {
        buttonChangeCourse.setText("ChangeCourse");
        buttonChangeCourse.setBounds(new Rectangle(101, 211, 73, 37));
        buttonChangeCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonChangeCourseActionPerformed(e);
            }
        });
        this.getContentPane().setLayout(null);
        this.setTitle("");
        buttonLogout.setText("Logout");
        buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonLogoutActionPerformed(e);
            }
        });
        this.getContentPane().add(buttonChangeCourse, null);
        this.getContentPane().add(buttonLogout, null);
    }

    abstract void showMenu(Product theProduct);

    abstract void showAddButtons();

    abstract void showViewButtons();

    abstract void showRadios();

    abstract void showComboxes();

    abstract void showLabel();

    void productAddButtonActionPerformed(ActionEvent e) {
        PTBS.theFacade.addTrade(theTrade);
        refresh();
    }

    void assignmentViewButtonActionPerformed(ActionEvent e) {
        Trade theTra = (Trade) tradeCombox.getSelectedItem();
        PTBS.theFacade.viewTrade(theTra);
    }

    void refresh() {
        tradeCombox.removeAllItems();
        Iterator<?> Iter = theTrade.assignmentList.iterator();
        while (Iter.hasNext()) {
            tradeCombox.addItem(Iter.next());
        }
    }

    void buttonChangeCourseActionPerformed(ActionEvent e) {
        bLogout = false;
        setVisible(false);
    }

    void buttonLogoutActionPerformed(ActionEvent e) {
        bLogout = true;
        setVisible(true);
    }

    boolean ifLogout() {
        return bLogout;
    }


}
