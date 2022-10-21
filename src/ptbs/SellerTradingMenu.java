package ptbs;


import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Rectangle;


import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.text.DateFormat;

public class SellerTradingMenu extends TradingMenu {

    private static final long serialVersionUID = 1L;
    private Offering theOffering;
    private Trade theTrade;
    JComboBox<Offering> comboBoxSolutionList = new JComboBox<Offering>();

    JTextField tbTradeName = new JTextField();
    JTextField tbDueDate = new JTextField();
    JTextField tbSuggestedOffering = new JTextField();

    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JButton buttonMark = new JButton();
    JButton buttonView = new JButton();
    JButton buttonClose = new JButton();

    public SellerTradingMenu() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText("Trade Name");
        jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
        this.getContentPane().setLayout(null);
        tbTradeName.setText("jTextField1");
        tbTradeName.setBounds(new Rectangle(192, 31, 341, 22));
        jLabel2.setText("Due Date");
        jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
        tbDueDate.setText("tbDueDate");
        tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
        jLabel3.setText("Suggested Solution");
        jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
        tbSuggestedOffering.setText("jTextField2");
        tbSuggestedOffering.setBounds(new Rectangle(197, 149, 339, 22));
        buttonGrade.setText("Grade");
        buttonGrade.setBounds(new Rectangle(458, 199, 79, 29));
        buttonGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMarkActionPerformed(e);
            }
        });
        buttonReport.setText("Report");
        buttonReport.setBounds(new Rectangle(365, 249, 79, 29));
        buttonReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonReportActionPerformed(e);
            }
        });
        buttonClose.setText("Close");
        buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonCloseActionPerformed(e);
            }
        });
        comboBoxSolutionList.setBounds(new Rectangle(32, 204, 413, 22));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tbTradeName, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(tbDueDate, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(tbSuggestedOffering, null);
        this.getContentPane().add(buttonClose, null);
        this.getContentPane().add(comboBoxSolutionList, null);
        this.getContentPane().add(buttonGrade, null);
        this.getContentPane().add(buttonReport, null);
    }

    public void showMenu(Trade trade, Person person) {
        theTrade = trade;
        tbTradeName.setText(theTrade.tradeName);
        DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        tbDueDate.setText(theDateFormat.format(theTrade.dueDate));
        tbSuggestedOffering.setText(theTrade.suggestOffering.offeringFileName);
        refreshOfferingList();
        setVisible(true);
    }

    void buttonCloseActionPerformed(ActionEvent e) {
        theTrade.tradeName = tbTradeName.getText();
        DateFormat tempDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        try {
            theTrade.dueDate = tempDateFormat.parse(tbDueDate.getText());
        } catch (Exception ee) {
        }
        ;
        theTrade.suggestOffering.offeringFileName = tbSuggestedOffering.getText();
        setVisible(false);
    }

    void buttonGradeActionPerformed(ActionEvent e) {
        Offering theOffering = (Offering) comboBoxOfferingList.getSelectedItem();
        if (theOffering == null)
            return;
        OfferingMarkDlg dlg = new OfferingMarkDlg();
        dlg.show(theOffering);
        refreshOfferingList();
    }

    void buttonReportActionPerformed(ActionEvent e) {
        OfferingIterator iter = new OfferingIterator(theTrade.theOfferingList);
        while (iter.hasNext()) {
            Offering asolution = (Offering) iter.next();
            asolution.setReported(true);
        }
        refreshOfferingList();
    }

    private void refreshOfferingList() {
        comboBoxOfferingList.removeAllItems();
        OfferingIterator SolIter = new OfferingIterator(theTrade.theOfferingList);
        while (SolIter.hasNext()) {
            theOffering = (Offering) SolIter.next();
            comboBoxOfferingList.addItem(theOffering);
        }
    }

}
