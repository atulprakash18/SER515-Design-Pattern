package ptbs;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;


public class OfferingMarkDlg extends JDialog{

    private static final long serialVersionUID = 1L;
    Offering theOffering;
    JLabel jLabel1 = new JLabel();
    JTextField tfGrad = new JTextField();
    JButton buttonOk = new JButton();
    JLabel labelSolutionFileName = new JLabel();

    public OfferingMarkDlg() {
        try {
            jbInit();
            setSize(316, 186);
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText("Offering File Name");
        jLabel1.setBounds(new Rectangle(23, 30, 121, 18));
        this.getContentPane().setLayout(null);
        tfGrad.setBounds(new Rectangle(25, 66, 100, 22));
        buttonOk.setText("OK");
        buttonOk.setBounds(new Rectangle(217, 67, 79, 29));
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonOkActionPerformed(e);
            }
        });
        labelSolutionFileName.setBounds(new Rectangle(212, 34, 163, 18));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tfGrad, null);
        this.getContentPane().add(labelSolutionFileName, null);
        this.getContentPane().add(buttonOk, null);
    }

    void show(Offering offering) {
        theOffering = offering;
        tfGrad.setText("" + theOffering.getMarkInt());
        labelSolutionFileName.setText(theOffering.offeringFileName);
        setVisible(true);
    }

    void buttonOkActionPerformed(ActionEvent e) {
        theOffering.theMark = Integer.parseInt(tfGrad.getText());
        setVisible(false);
    }

    public Offering getTheOffering() {
        return theOffering;
    }
}
