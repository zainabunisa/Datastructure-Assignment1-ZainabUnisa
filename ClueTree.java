package com.cestar.datastructure;

public class ClueTree {

    // Inner class representing each node in the binary tree
    static class Node {
        String hint;
        Node leftChild, rightChild;

        Node(String hint) {
            this.hint = hint;
            leftChild = null;
            rightChild = null;
        }
    }

    private Node rootNode;  // Root of the tree

    public ClueTree() {
        rootNode = null;  // Initialize with an empty tree
    }

    // Method to insert a new clue into the binary tree
    public void addClue(String clue) {
        rootNode = addClueRecursively(rootNode, clue);
        System.out.println("Clue added: " + clue);
    }

    private Node addClueRecursively(Node current, String clue) {
        if (current == null) {
            return new Node(clue);  // Create a new node if none exists
        }
        if (clue.compareTo(current.hint) < 0) {
            current.leftChild = addClueRecursively(current.leftChild, clue);  // Insert in the left subtree
        } else if (clue.compareTo(current.hint) > 0) {
            current.rightChild = addClueRecursively(current.rightChild, clue);  // Insert in the right subtree
        }
        return current;
    }

    // Method for in-order traversal (left-root-right)
    public void displayInOrder() {
        System.out.print("In-order traversal: ");
        inOrderTraversal(rootNode);
        System.out.println();
    }

    private void inOrderTraversal(Node current) {
        if (current != null) {
            inOrderTraversal(current.leftChild);  // Traverse left subtree
            System.out.print(current.hint + " ");  // Visit root
            inOrderTraversal(current.rightChild);  // Traverse right subtree
        }
    }

    // Method for pre-order traversal (root-left-right)
    public void displayPreOrder() {
        System.out.print("Pre-order traversal: ");
        preOrderTraversal(rootNode);
        System.out.println();
    }

    private void preOrderTraversal(Node current) {
        if (current != null) {
            System.out.print(current.hint + " ");  // Visit root
            preOrderTraversal(current.leftChild);  // Traverse left subtree
            preOrderTraversal(current.rightChild);  // Traverse right subtree
        }
    }

    // Method for post-order traversal (left-right-root)
    public void displayPostOrder() {
        System.out.print("Post-order traversal: ");
        postOrderTraversal(rootNode);
        System.out.println();
    }

    private void postOrderTraversal(Node current) {
        if (current != null) {
            postOrderTraversal(current.leftChild);  // Traverse left subtree
            postOrderTraversal(current.rightChild);  // Traverse right subtree
            System.out.print(current.hint + " ");  // Visit root
        }
    }

    // Method to find a specific clue in the tree
    public boolean containsClue(String clue) {
        return containsClueRecursively(rootNode, clue);
    }

    private boolean containsClueRecursively(Node current, String clue) {
        if (current == null) {
            return false;  // Base case: reached end of tree
        }
        if (current.hint.equals(clue)) {
            return true;  // Clue found
        }
        return clue.compareTo(current.hint) < 0 
            ? containsClueRecursively(current.leftChild, clue)  // Search left subtree
            : containsClueRecursively(current.rightChild, clue);  // Search right subtree
    }

    // Method to count total clues in the tree
    public int totalClues() {
        return countCluesRecursively(rootNode);
    }

    private int countCluesRecursively(Node current) {
        if (current == null) {
            return 0;  // Base case: no nodes
        }
        return 1 + countCluesRecursively(current.leftChild) + countCluesRecursively(current.rightChild);  // Count nodes
    }

    // Main method for demonstration
    public static void main(String[] args) {
        ClueTree clueTree = new ClueTree();

        // Add clues
        clueTree.addClue("The hidden treasure is beneath the old oak tree.");
        clueTree.addClue("Look for the key under the welcome mat.");
        clueTree.addClue("The map leads to the riverbank.");
        clueTree.addClue("Search near the ancient ruins.");
        clueTree.addClue("Follow the trail of footprints.");

        // Display traversals
        clueTree.displayInOrder();
        clueTree.displayPreOrder();
        clueTree.displayPostOrder();

        // Search for a specific clue
        String clueToFind = "Look for the key under the welcome mat.";
        if (clueTree.containsClue(clueToFind)) {
            System.out.println("Clue found: " + clueToFind);
        } else {
            System.out.println("Clue not found: " + clueToFind);
        }

        // Count total clues
        System.out.println("Total clues in the tree: " + clueTree.totalClues());
    }
}
