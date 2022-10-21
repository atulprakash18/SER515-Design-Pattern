package ptbs;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class LowLevelProductMenu extends ProductMenu {

    private static final long serialVersionUID = 1L;

    public LowLevelProductMenu() {
        System.out.println("Lower level course menu implemented");
    }

    void showMenu(Product theProduct) {
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
        optionRadio.setText("LowLevelExperiment");
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
                tradeViewButtonActionPerformed(e);
            }
        });
        optionViewButton.setText("View");
        optionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
        this.getContentPane().add(tradeViewButton, null);
        this.getContentPane().add(optionViewButton, null);
    }

    void showLabel() {
        tradeContentLable.setText("AssigmentContent");
        tradeContentLable.setBounds(new Rectangle(23, 186, 432, 99));
        this.getContentPane().add(tradeContentLable, null);
    }
}