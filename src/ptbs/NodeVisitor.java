package ptbs;

abstract public class NodeVisitor {

    public NodeVisitor() {
        System.out.println("Node Visitor Implemented");
    }

    public NodeVisitor(Object visitee) {
        System.out.println("Node Visitor with object " + visitee + " Implemented");
    }

    abstract public void visitFacade(Facade facade);

    abstract public void visitProduct(Product product);

    abstract public void visitTrade(Trade trade);

}
