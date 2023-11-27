import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
    private String label;
    private int value;
    private List<Node> children = new ArrayList<>();
    private Node bestMove;  // New field to store the best move

    public Node(String label) {
        this.label = label;
    }

    public Node(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public void addChild(Node that) {
        this.children.add(that);
    }

    public boolean isTerminal() {
        return this.children.size() == 0;
    }

    public String getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getBestMove() {
        return bestMove;
    }

    public void setBestMove(Node bestMove) {
        this.bestMove = bestMove;
    }

    public static Comparator<Node> LabelComparator = Comparator.comparing(Node::getLabel);

    // Other methods...
}
