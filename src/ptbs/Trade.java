package ptbs;

import java.text.DateFormat;
import java.util.Date;

public class Trade {

    protected String tradeName;
    protected String stringTradeFilename;
    protected Date dueDate = new Date();
    protected String tradeSpecification;
    protected OfferingList theOfferingList = new OfferingList();
    protected Offering suggestOffering = new Offering();
    boolean accepted = false;

    public boolean isAccepted() {
        return accepted;
    }

    public Trade() {
        System.out.println("Trade Accomplished");
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public void setDueDate(Date theDueDate) {
        this.dueDate = theDueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setTradeSpecification(String theSpec) {
        this.tradeSpecification = theSpec;
    }

    public String getTradeSpecification() {
        return tradeSpecification;
    }

    public boolean isOverDue() {
        Date today = new Date();
        if (today.after(this.dueDate)) {
            return true;
        } else {
            return false;
        }
    }

    public Offering addOffering() {
        Offering myOffering = new Offering();
        return myOffering;
    }

    // add the theSolution to the Solution list
    public void addOffering(Offering theOffering) {
        theOfferingList.add(theOffering);
    }

    public OfferingList getTheSolutionList() {
        return theOfferingList;
    }

    public void submitOffer() {
        System.out.println(" Your offer is submitted");
    }

    public void getOfferingList() {
        System.out.println("Get offering Implemented");
    }

    // return the solution of the give name
    public Offering getOffering(String personName) {
        OfferingIterator Iterator = getOfferingIterator();
        return (Offering) Iterator.next(personName);
    }

    public Offering getSuggestOffering() {
        return suggestOffering;
    }

    public OfferingIterator getOfferingIterator() {
        OfferingIterator theOfferingIterator = new OfferingIterator(theOfferingList);
        return theOfferingIterator;
    }

    public String toString() {
        return tradeName;
    }

    public String getDueDateString() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        return dateFormat.format(dueDate);
    }

    public void accept(NodeVisitor visitor) {
        visitor.visitTrade(this);
        accepted = true;
    }


}
