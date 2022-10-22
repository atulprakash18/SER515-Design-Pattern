package ptbs;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import ptbs.UserInfoItem.USER_TYPE;

public class Login extends JDialog{

    private static final long serialVersionUID = 1L;
    boolean mBExit = false;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JButton loginButton = new JButton();
    JButton buttonExit = new JButton();
    JTextField userNameText = new JTextField();
    JPasswordField passwordText = new JPasswordField();

    JRadioButton buyerRadio = new JRadioButton();

    JRadioButton sellerRadio = new JRadioButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    private String userBox = null;
    private USER_TYPE userType = USER_TYPE.Buyer; // default to Student

    public Login() {
        try {
            jbInit();
            setSize(300, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        System.out.println("creating login window");
        this.getContentPane().setLayout(null);
        jLabel1.setText("UserName");
        jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
        jLabel2.setText("Password");
        jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
        loginButton.setText("Login");
        loginButton.setBounds(new Rectangle(31, 212, 85, 28));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButtonActionPerformed(e);
            }
        });
        buttonExit.setText("Exit");
        buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonExitActionPerformed(e);
            }
        });
        userNameText.setBounds(new Rectangle(119, 52, 144, 22));
        passwordText.setBounds(new Rectangle(118, 119, 147, 22));
        buyerRadio.setSelected(true);
        buyerRadio.setText("Buyer");
        buyerRadio.setBounds(new Rectangle(37, 164, 103, 26));
        sellerRadio.setText("Seller");
        sellerRadio.setBounds(new Rectangle(177, 162, 103, 26));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(loginButton, null);
        this.getContentPane().add(buttonExit, null);
        this.getContentPane().add(userNameText, null);
        this.getContentPane().add(passwordText, null);
        this.getContentPane().add(buyerRadio, null);
        this.getContentPane().add(sellerRadio, null);
        buttonGroup1.add(buyerRadio);
        buttonGroup1.add(sellerRadio);
    }

    void loginButtonActionPerformed(ActionEvent e) {
        BufferedReader file;
        mBExit = false;
        System.out.println("User Logged In");
        try {
            if (buyerRadio.isSelected() == true)//// student
            {
                userType = USER_TYPE.Buyer; /// 0 for student
                file = new BufferedReader(new FileReader("BuyerInfo.txt"));
            } else// instructor
            {
                userType = USER_TYPE.Seller; // 1 for instructor
                file = new BufferedReader(new FileReader("SellerInfo.txt"));
            }
            userBox = userNameText.getText();
            String PasswordBox = new String(passwordText.getPassword());
            String LoginName = null;
            String aline = null, UserName = null, Password = null;
            while ((aline = file.readLine()) != null) {
                UserName = getUserName(aline);
                Password = getPassword(aline);
                if (UserName.compareTo(userBox) == 0 && Password.compareTo(PasswordBox) == 0)
                    LoginName = UserName;
            }
            if (LoginName != null) {
                this.setVisible(false);
            }
        } catch (Exception ee) {
            ;
        }

    }

    /*
     * get the user name from aline UserName:Password
     */
    private String getUserName(String aline) {
        int Sep = aline.lastIndexOf(':');
        return aline.substring(0, Sep);
    }

    /*
     * get the password from aline UserName:Password
     */
    private String getPassword(String aline) {
        int Sep = aline.lastIndexOf(':');
        return aline.substring(Sep + 1, aline.length());
    }

    /* after login get the UserName of the login interface */
    public String getUserName() {
        return userBox;
    }

    /* after login get the userType of the login interface */
    public USER_TYPE getUserType() {
        return userType;
    }

    public boolean isExit() {
        return mBExit;
    }

    void buttonExitActionPerformed(ActionEvent e) {
        mBExit = true;
        setVisible(false);
    }


}
