package ptbs;

import java.util.Iterator;
import java.util.Calendar;
import java.util.Date;

public class ReminderVisitor extends NodeVisitor {

    Reminder mReminder;

    public ReminderVisitor() {
        System.out.println("Reminder Visitor Implemented");
    }

    public ReminderVisitor(Reminder reminder) {
        mReminder = reminder;
    }

    public Reminder getmReminder() {
        return mReminder;
    }

    public void visitFacade(Facade facade) {
        ProductIterator productList = new ProductIterator(facade.theProductList);
        while (productList.hasNext()) {
            Product course = (Product) productList.next();
            course.accept(this);
        }
    }

    public void visitProduct(Product product) {
        Iterator<Trade> tradeList = product.tradeList.listIterator();
        while (tradeList.hasNext()) {
            Trade assignment = (Trade) tradeList.next();
            assignment.accept(this);
        }
    }

    public void visitAssignment(Trade trade) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(trade.dueDate);
        int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
        if (mReminder != null) {
            if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday) /// upcoming
            {
                mReminder.listUpcoming.add("today is " + today.toString() + " " + trade.tradeName
                        + " Due Date is " + trade.getDueDateString());
            }
            if (nDueDate < ntoday) {
                // put to the
                mReminder.listOverDue.add(trade.tradeName + " Due Date is " + trade.getDueDateString());
            }
        }
    }

}