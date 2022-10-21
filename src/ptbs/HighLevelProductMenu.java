package ptbs;

import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class HighLevelProductMenu extends ProductMenu {

    /*
     * JButton AssignmentAddButton = new JButton(); JRadioButton OptionRadio = new
     * JRadioButton(); JComboBox OptionCombo = new JComboBox(); JButton
     * OptionViewButton = new JButton(); JButton OptionAddButton = new JButton();
     */

    private static final long serialVersionUID = 1L;

    public HighLevelProductMenu() {
        System.out.println("High level product menu implemented");
    }

    void showMenu(Product theProduct) {
        showViewButtons();
        showRadios();
        showComboxes();
        setVisible(true);
    }

    void showAddButtons() {
        tradeAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tradeAddButtonActionPerformed(e);
            }
        });
        tradeAddButton.setText("Add");
        tradeAddButton.setBounds(new Rectangle(389, 54, 79, 29));
        optionAddButton.setText("Add");
        optionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
        this.getContentPane().add(tradeAddButton, null);
        this.getContentPane().add(optionAddButton, null);
    }

    void showRadios() {
        tradeRadio.setText("Assignment");
        tradeRadio.setBounds(new Rectangle(21, 55, 103, 26));
        this.getContentPane().add(tradeRadio, null);
        optionRadio.setText("HighLevel Presentation");
        optionRadio.setBounds(new Rectangle(21, 128, 103, 26));
        this.getContentPane().add(optionRadio, null);
    }

    void showComboxes() {
        tradeCombox.setBounds(new Rectangle(140, 57, 126, 22));
        optionCombo.setBounds(new Rectangle(137, 127, 126, 22));
        this.getContentPane().add(tradeCombox, null);
        this.getContentPane().add(optionCombo, null);
        refresh();
    }

    void showViewButtons() {
        tradeViewButton.setText("View");
        tradeViewButton.setBounds(new Rectangle(290, 54, 79, 29));
        tradeViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assignmentViewButtonActionPerformed(e);
            }
        });
        optionViewButton.setText("View");
        optionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
        this.getContentPane().add(tradeViewButton, null);
        this.getContentPane().add(optionViewButton, null);
    }

    void showLabel() {
        tradeContentLable.setText("AssignmentContent");
        tradeContentLable.setBounds(new Rectangle(23, 186, 432, 99));
        this.getContentPane().add(tradeContentLable, null);
    }
}