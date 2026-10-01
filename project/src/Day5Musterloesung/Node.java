public class Node {
    int value;
    Node nextNode;

    public Node(int value) {
        this.value = value;
        this.nextNode = null;
    }

    public int calculateSum(int currentSum) {
        int newSum = currentSum + this.value;

        if (this.nextNode != null) {
            return this.nextNode.calculateSum(newSum);
        }

        return newSum;
    }
}