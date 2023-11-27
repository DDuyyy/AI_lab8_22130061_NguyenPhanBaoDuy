import java.util.Collections;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

    @Override
    public void execute(Node node) {
        int result = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Result at node " + node.getLabel() + ": " + result);
        System.out.println("Best move at node " + node.getLabel() + ": " + node.getBestMove().getLabel());
    }

    @Override
    public int maxValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int max = Integer.MIN_VALUE;

        Collections.sort(node.getChildren(), Node.LabelComparator);
        Collections.reverse(node.getChildren());

        for (Node child : node.getChildren()) {
            int minValue = minValue(child, alpha, beta);
            if (minValue > max) {
                max = minValue;
                node.setBestMove(child);  // Update the best move
            }
            alpha = Math.max(alpha, max);

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

        Collections.sort(node.getChildren(), Node.LabelComparator);
        Collections.reverse(node.getChildren());

        for (Node child : node.getChildren()) {
            int maxValue = maxValue(child, alpha, beta);
            if (maxValue < min) {
                min = maxValue;
                node.setBestMove(child);  // Update the best move
            }
            beta = Math.min(beta, min);

            if (beta <= alpha) {
                System.out.println("Pruned node: " + child.getLabel());
                break;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B", 3);
        Node nodeC = new Node("C", 2);
        Node nodeD = new Node("D", 2);

        nodeA.addChild(nodeB);
        nodeA.addChild(nodeC);
        nodeA.addChild(nodeD);

        AlphaBetaSearchAlgo alphaBetaSearchAlgo = new AlphaBetaSearchAlgo();
        alphaBetaSearchAlgo.execute(nodeA);
    }
}
