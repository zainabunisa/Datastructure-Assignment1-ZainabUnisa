package com.cestar.datastructure;

import java.util.LinkedList;

public class ManuscriptStack {
    private LinkedList<String> scrolls;

    public ManuscriptStack() {
        this.scrolls = new LinkedList<>();
    }

    // Add a new scroll to the top of the stack
    public void add(String title) {
        scrolls.addFirst(title);
        System.out.println("Pushed scroll: " + title);
    }

    // Remove the top scroll from the stack
    public String remove() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        String title = scrolls.removeFirst();
        System.out.println("Popped scroll: " + title);
        return title;
    }

    // View the top scroll without removing it
    public String viewTop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return null;
        }
        return scrolls.getFirst();
    }

    // Check if a specific scroll title exists in the stack
    public boolean hasScroll(String title) {
        return scrolls.contains(title);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return scrolls.isEmpty();
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        ManuscriptStack manuscriptStack = new ManuscriptStack();

        // Add some scrolls onto the stack
        manuscriptStack.add("NightMare");
        manuscriptStack.add("Demon");
        manuscriptStack.add("Cindrella and the four Knights");

        // View the top scroll
        System.out.println("Top scroll: " + manuscriptStack.viewTop());

        // Check if a specific scroll exists
        String searchTitle = "The Iliad";
        if (manuscriptStack.hasScroll(searchTitle)) {
            System.out.println("Scroll titled '" + searchTitle + "' exists in the stack.");
        } else {
            System.out.println("Scroll titled '" + searchTitle + "' does not exist in the stack.");
        }

        // Remove a scroll from the stack
        manuscriptStack.remove();

        // View again after removing
        System.out.println("Top scroll after popping: " + manuscriptStack.viewTop());
    }
}
