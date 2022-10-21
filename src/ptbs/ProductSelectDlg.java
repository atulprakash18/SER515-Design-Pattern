package ptbs;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;


import javax.swing.JComboBox;
import javax.swing.JDialog;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class ProductSelectDlg extends JDialog {

    private static final long serialVersionUID = 1L;

    // 0 HighLevel presentation 1 LowLevel Experiment
    ProductList theProductList;
    Product selectedProduct;
    int nProductCategory = 0;
    boolean mBLogout = false;
    JComboBox<Product> productNameComboBox = new JComboBox<Product>();
    JRadioButton highLevelRadio = new JRadioButton();
    JRadioButton lowLevelRadio = new JRadioButton();
    JLabel jLabel1 = new JLabel();
    JButton okButton = new JButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    JButton buttonLogout = new JButton();

    public ProductSelectDlg() {
        try {
            jbInit();
            setSize(420, 238);
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        productNameComboBox.setBounds(new Rectangle(155, 41, 203, 22));
        highLevelRadio.setText("HighLevel");
        highLevelRadio.setBounds(new Rectangle(50, 87, 103, 26));
        lowLevelRadio.setToolTipText("");
        lowLevelRadio.setSelected(true);
        lowLevelRadio.setText("LowLevel");
        lowLevelRadio.setBounds(new Rectangle(236, 88, 103, 26));
        jLabel1.setText("CourseName");
        jLabel1.setBounds(new Rectangle(39, 44, 85, 18));
        okButton.setText("OK");
        okButton.setBounds(new Rectangle(78, 139, 79, 29));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okButtonActionPerformed(e);
            }
        });
        buttonLogout.setText("Logout");
        buttonLogout.setBounds(new Rectangle(224, 140, 73, 31));
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonLogoutActionPerformed(e);
            }
        });
        this.getContentPane().add(productNameComboBox, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(highLevelRadio, null);
        this.getContentPane().add(lowLevelRadio, null);
        this.getContentPane().add(okButton, null);
        this.getContentPane().add(buttonLogout, null);
        buttonGroup1.add(highLevelRadio);
        buttonGroup1.add(lowLevelRadio);
    }

    public Product showDlg(ProductList courseList) {
        theProductList = courseList;
        ProductIterator theIterator = new ProductIterator(theProductList);
        Product theProduct;
        while ((theProduct = (Product) theIterator.next()) != null) /// end of the list
        {
            productNameComboBox.addItem(theProduct);
        }
        setVisible(true);
        return selectedProduct;
    }

    void okButtonActionPerformed(ActionEvent e) {
        selectedProduct = (Product) productNameComboBox.getSelectedItem();
        if (highLevelRadio.isSelected())
            nProductCategory = 0; // highlevel course: 0
        else
            nProductCategory = 1; // lowlevel course: 1
        setVisible(false);
    }

    public boolean isLogout() {
        return mBLogout;
    }

    void buttonLogoutActionPerformed(ActionEvent e) {
        mBLogout = true;
        setVisible(false);
    }
}
