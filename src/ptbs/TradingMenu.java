package ptbs;

import javax.swing.JDialog;


    abstract public class TradingMenu extends JDialog {

        private static final long serialVersionUID = 1L;

        abstract void showMenu(Trade trade, Person person);

        public TradingMenu() {
            setModal(true);
            setSize(575, 330);
        }
    }
