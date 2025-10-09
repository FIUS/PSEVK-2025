public class List {
    private Node startNode;

    public List(Node startNode) {
        this.startNode = startNode;
    }

    public void addNode(Node node) {
        Node tempNode = startNode;

        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }

    public void removeNode(Node node){
        Node tempNode = startNode;
        while(tempNode.nextNode != node){
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node.nextNode;
    }

    public void printList(){
        Node tempNode = startNode;
        while(tempNode != null){
            System.out.println(tempNode.value);
            tempNode = tempNode.nextNode;
        }
    }

    public int getSum() {
        return startNode.calculateSum(0);
    }
}