package ptbs;

import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.Rectangle;

public class Reminder {

    private static final long serialVersionUID = 1L;
    ProductList courseList;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    java.awt.List listUpcoming = new java.awt.List();
    java.awt.List listOverDue = new java.awt.List();
    Button buttonOk = new Button();

    public Reminder() {
        try {
            jbInit();
            setModal(true);
            setSize(400, 386);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText("Upcoming trade window");
        jLabel1.setBounds(new Rectangle(38, 40, 159, 17));
        this.getContentPane().setLayout(null);
        jLabel2.setText("passed trade");
        jLabel2.setBounds(new Rectangle(39, 160, 161, 17));
        listUpcoming.setBounds(new Rectangle(29, 65, 340, 79));
        listOverDue.setBounds(new Rectangle(31, 187, 337, 85));
        buttonOk.setLabel("OK");
        buttonOk.setBounds(new Rectangle(149, 308, 67, 37));
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonOkActionPerformed(e);
            }
        });
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(listUpcoming, null);
        this.getContentPane().add(listOverDue, null);
        this.getContentPane().add(buttonOk, null);
    }

    void showReminder(ProductList productList) {
        ReminderVisitor visitor = new ReminderVisitor(this);
        visitor.visitFacade(Hacs.theFacade);
        setVisible(true);
    }

    void buttonOkActionPerformed(ActionEvent e) {
        setVisible(false);
    }


}
