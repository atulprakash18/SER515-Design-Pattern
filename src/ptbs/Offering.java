package ptbs;

import java.util.Date;

public class Offering {

    String thePerson = "";
    String offeringFileName = "";
    Date theSubmitData = new Date();
    int theMark;
    boolean reported = false;

    public Offering() {
        System.out.println("offering Implemented ");
    }

    public String getThePerson() {
        return thePerson;
    }

    @Override
    public String toString() {
        String string = thePerson + " " + offeringFileName + " Grade = " + getMarkInt();
        if (isReported())
            string += " reported.";
        else
            string += " not reported.";
        return (string);
    }

    public void setOfferingFileName(String offeringFileName) {
        this.offeringFileName = offeringFileName;
    }

    public void setThePerson(String thePerson) {
        this.thePerson = thePerson;
    }

    String getMarkString() {
        if (isReported())
            return "" + theMark;
        else
            return "-1";
    }

    int getMarkInt() {
        return theMark;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }

    public boolean isReported() {
        return reported;
    }

}
