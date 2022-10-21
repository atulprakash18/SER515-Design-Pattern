package ptbs;

public class OfferingIterator {

    OfferingList offeringlist;

    /// CurrentSolutionNumber: point to the location before the first element
    int currentOfferingNumber = -1;

    public int getCurrentOfferingNumber() {
        return currentOfferingNumber;
    }

    public OfferingIterator() {
        System.out.println("Offering Iterator Implemented");
    }

    public OfferingIterator(OfferingList theofferinglist) {
        offeringlist = theofferinglist;
        moveToHead();
    }

    public void moveToHead() {
        /// CurrentSolutionNumber: point to the location before the first element
        currentOfferingNumber = -1;
    }

    public boolean hasNext() {
        /** @todo: Implement this java.util.Iterator method */
        if (currentOfferingNumber >= offeringlist.size() - 1)
            return false;
        else
            return true;
        // throw new java.lang.UnsupportedOperationException("Method hasNext() not yet
        // implemented.");
    }

    public Offering next() {
        /** @todo: Implement this java.util.Iterator method */
        if (hasNext() == true) {
            currentOfferingNumber++;
            return offeringlist.get(currentOfferingNumber);
        } else {
            return null;
        }
        // throw new java.lang.UnsupportedOperationException("Method next() not yet
        // implemented.");
    }

    /// get the next Solution that fits the Username;
    public Object next(String UserName) {
        Offering theOffering;
        theOffering = (Offering) next();
        while (theOffering != null) {
            if (UserName.compareTo(theOffering.thePerson) == 0) {
                return theOffering;
            }
            theOffering = (Offering) next();
        }
        return null;
    }

    public void remove() {
        /** @todo: Implement this java.util.Iterator method */
        offeringlist.remove(currentOfferingNumber);
//    throw new java.lang.UnsupportedOperationException("Method remove() not yet implemented.");
    }

}
