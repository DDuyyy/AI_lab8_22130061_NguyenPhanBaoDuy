import java.util.Collections;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo {

    @Override
    public void execute(Node node) {
        int result = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);

        // Print the result at the root node
        System.out.println("Result at node " + node.getLabel() + ": " + result);
    }

    @Override
    public int maxValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int max = Integer.MIN_VALUE;

        // Sort children based on alphabetical order
        Collections.sort(node.getChildren(), Node.LabelComparator);

        // Reverse the order for right-to-left mode
        Collections.reverse(node.getChildren());

        for (Node child : node.getChildren()) {
            max = Math.max(max, minValue(child, alpha, beta));
            alpha = Math.max(alpha, max);

            // Alpha-Beta pruning
            if (beta <= alpha) {
                System.out.println("Pruned node: " + child.getLabel());
                break;
            }
        }

        return max;
    }

    @Override
    public int minValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int min = Integer.MAX_VALUE;

        // Sort children based on alphabetical order
        Collections.sort(node.getChildren(), Node.LabelComparator);

        // Reverse the order for right-to-left mode
        Collections.reverse(node.getChildren());

        for (Node child : node.getChildren()) {
            min = Math.min(min, maxValue(child, alpha, beta));
            beta = Math.min(beta, min);

            // Alpha-Beta pruning
            if (beta <= alpha) {
                System.out.println("Pruned node: " + child.getLabel());
                break;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        // Create a sample tree
        Node nodeA = new Node("A");
        Node nodeB = new Node("B", 3);
        Node nodeC = new Node("C", 2);
        Node nodeD = new Node("D", 2);

        nodeA.addChild(nodeB);
        nodeA.addChild(nodeC);
        nodeA.addChild(nodeD);

        // Create the AlphaBetaRightToLeftSearchAlgo instance and execute the algorithm
        AlphaBetaRightToLeftSearchAlgo alphaBetaRightToLeftSearchAlgo = new AlphaBetaRightToLeftSearchAlgo();
        alphaBetaRightToLeftSearchAlgo.execute(nodeA);
    }
}
