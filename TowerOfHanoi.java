import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int disks = 3; // Number of disks

        System.out.println("Tower Of Hanoi");
        System.out.println("Number of disks: " + disks);

        recursiveHanoi(disks, 'A', 'C', 'B');
        System.out.println("");
        iterativeHanoi(disks, 'A', 'C', 'B');
    }

    // Recursive Tower Of Hanoi
    public static void recursiveHanoi(int disks, char source, char destination, char auxiliary) {
        if (disks == 1) {
            System.out.println("Move disk from " + source + " to " + destination);
            return;
        }

        recursiveHanoi(disks - 1, source, auxiliary, destination);
        System.out.println("Move disk " + "from " + source + " to " + destination);
        recursiveHanoi(disks - 1, auxiliary, destination, source);
    }

    // Iterative Tower Of Hanoi
    public static void iterativeHanoi(int disks, char source, char destination, char auxiliary) {
        Stack<Move> stack = new Stack<>();
        stack.push(new Move(disks, source, destination, auxiliary));

        while (!stack.isEmpty()) {
            Move move = stack.pop();

            if (move.disks == 1) {
                System.out.println("Move disk from " + move.source + " to " + move.destination);
            } else {
                stack.push(new Move(move.disks - 1, move.auxiliary, move.destination, move.source));
                stack.push(new Move(1, move.source, move.destination, move.auxiliary));
                stack.push(new Move(move.disks - 1, move.source, move.auxiliary, move.destination));
            }
        }
    }

    // Iterative: Class representing a move of a disk from one tower to another
    // Inspiration from linkedlist
    private static class Move {
        int disks;
        char source;
        char destination;
        char auxiliary;

        public Move(int disks, char source, char destination, char auxiliary) {
            this.disks = disks;
            this.source = source;
            this.destination = destination;
            this.auxiliary = auxiliary;
        }
    }
}
