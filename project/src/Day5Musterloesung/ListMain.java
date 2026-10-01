public class ListMain {
    public static void main(String[] args) {
        List list = new List(new Node(1));
        list.addNode(new Node(2));
        list.addNode(new Node(3));
        list.printList();
        int sum = list.getSum();
        System.out.println("Summe: " + sum);
    }
}
