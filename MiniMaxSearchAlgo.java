package game_alphabeta_student;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
	// Sort children based on alphabetical order
	Collections.sort(node.getChildren(), Node.LabelComparator);

	// Invoke the MiniMax algorithm starting with the root node
	int value = maxValue(node);

	// Print the result at the root node
	System.out.println("Result at node " + node.getLabel() + ": " + value);
}

	public int maxValue(Node node) {
		if (node.isTerminal()) {
            return node.getValue();
        }
		return Integer.MIN_VALUE;
	}
	// Sort children based on alphabetical order
	Collections.sort(node.getChildren(), Node.LabelComparator);

	for (Node child : node.getChildren()) {
		int minValue = minValue(child);
		max = Math.max(max, minValue);
	}

	return max;
}

	public int minValue(Node node) {
		if (node.isTerminal()) {
            return node.getValue();
        }

		return Integer.MAX_VALUE;
		// Sort children based on alphabetical order
        Collections.sort(node.getChildren(), Node.LabelComparator);

        for (Node child : node.getChildren()) {
            int maxValue = maxValue(child);
            min = Math.min(min, maxValue);
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

        // Create the MiniMaxSearchAlgo instance and execute the algorithm
        MiniMaxSearchAlgo miniMaxSearchAlgo = new MiniMaxSearchAlgo();
        miniMaxSearchAlgo.execute(nodeA);

        // Print values at nodes B, C, and D
        System.out.println("Value at node B: " + nodeB.getValue());
        System.out.println("Value at node C: " + nodeC.getValue());
        System.out.println("Value at node D: " + nodeD.getValue());
    }

