package com.cestar.datastructure;

public class MazeRoute {
    // Inner class representing each position in the route
    private class Position {
        String area; // The area represented by the node
        Position next; // Pointer to the next node in the list

        // Constructor to initialize a position with an area
        Position(String area) {
            this.area = area;
            this.next = null; // Next is initially null
        }
    }

    private Position start; // Head of the linked list, representing the beginning of the route

    // Constructor to initialize the MazeRoute
    public MazeRoute() {
        this.start = null; // Initially, the route is empty
    }

    // Add a new area to the route
    public void addLocation(String area) {
        Position newPosition = new Position(area); // Create a new position for the area
        if (start == null) {
            start = newPosition; // If the list is empty, set the new position as start
        } else {
            Position current = start; // Start traversing from the start
            while (current.next != null) {
                current = current.next; // Traverse to the end of the list
            }
            current.next = newPosition; // Add new position to the end of the list
        }
        System.out.println(area + " added to the route."); // Print confirmation
    }

    // Remove the last visited area from the route
    public void removeLastLocation() {
        if (start == null) {
            System.out.println("No areas to remove."); // No areas in the route
            return;
        }

        if (start.next == null) { // If there's only one position in the list
            System.out.println(start.area + " removed from the route."); // Print confirmation
            start = null; // Remove the only position
        } else {
            Position current = start; // Start traversing from the start
            while (current.next.next != null) {
                current = current.next; // Traverse to the second last position
            }
            System.out.println(current.next.area + " removed from the route."); // Print confirmation
            current.next = null; // Remove the last position
        }
    }

    // Check if the route contains a loop (trap)
    public boolean hasLoop() {
        Position slow = start; // Slow pointer starts at start
        Position fast = start; // Fast pointer starts at start

        // Traverse the list with two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1
            fast = fast.next.next; // Move fast pointer by 2
            if (slow == fast) { // If they meet, a loop is detected
                System.out.println("Loop detected in the route."); // Print confirmation
                return true; // Return true for loop detected
            }
        }
        System.out.println("No loop detected in the route."); // Print confirmation if no loop found
        return false; // Return false if no loop detected
    }

    // Print the entire route
    public void printPath() {
        if (start == null) {
            System.out.println("Route is empty."); // If the route is empty
            return;
        }

        System.out.print("Maze Route: "); // Print the start of the route
        Position current = start; // Start traversing from the start
        while (current != null) {
            System.out.print(current.area + " -> "); // Print current area
            current = current.next; // Move to the next area
        }
        System.out.println("null"); // Indicate the end of the route
    }

    // Main method to test the MazeRoute functionality
    public static void main(String[] args) {
        MazeRoute route = new MazeRoute(); // Create a new MazeRoute instance

        // Add areas to the route
        route.addLocation("Entrance");
        route.addLocation("Hallway");
        route.addLocation("Room A");
        route.addLocation("Room B");

        // Print the current route
        route.printPath();

        // Remove the last visited area
        route.removeLastLocation();

        // Print the route after removal
        route.printPath();

        // Check for loops (should be false at this point)
        route.hasLoop();

        // Create a loop for testing purposes
        route.start.next.next.next = route.start; // Manually create a loop
        route.hasLoop(); // Check for loop again
    }
}
