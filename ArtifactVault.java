package com.cestar.artifactvault;
import java.util.Arrays;

public class ArtifactVault {
    private String[] collection;  // Array to store artifacts
    private int totalItems;       // Current number of artifacts in storage

    // Constructor to initialize the storage with a specified capacity
    public ArtifactVault(int capacity) {
        collection = new String[capacity];  // Create an array with the defined capacity
        totalItems = 0;  // Start with no artifacts
    }

    // Method to add an artifact to the next available slot
    public void addArtifact(String artifact) {
        if (totalItems < collection.length) {  // Check if there is space available
            collection[totalItems] = artifact;  // Place the artifact in the next slot
            totalItems++;  // Increment the count of artifacts
            Arrays.sort(collection, 0, totalItems);  // Sort the array by artifact names
            System.out.println(artifact + " successfully added to storage.");  // Confirm addition
        } else {
            System.out.println("Storage is full. Cannot add " + artifact);  // Notify if storage is full
        }
    }

    // Method to remove an artifact by its name
    public void removeArtifact(String artifactName) {
        int index = findArtifactByLinearSearch(artifactName);  // Search for the artifact using linear search
        if (index >= 0) {  // If the artifact is found
            for (int i = index; i < totalItems - 1; i++) {
                collection[i] = collection[i + 1];  // Shift artifacts to fill the gap
            }
            collection[totalItems - 1] = null;  // Clear the last artifact
            totalItems--;  // Decrease the count of artifacts
            System.out.println(artifactName + " removed from storage.");  // Confirm removal
        } else {
            System.out.println(artifactName + " not found in storage.");  // Notify if the artifact is not found
        }
    }

    // Method to find an artifact using linear search
    public int findArtifactByLinearSearch(String artifactName) {
        for (int i = 0; i < totalItems; i++) {  // Iterate through the collection
            if (collection[i].equals(artifactName)) {  // Check for a match
                System.out.println(artifactName + " found at index " + i + " via Linear Search.");  // Confirm finding
                return i;  // Return the index of the found artifact
            }
        }
        System.out.println(artifactName + " not found via Linear Search.");  // Notify if not found
        return -1;  // Return -1 to indicate not found
    }

    // Method to find an artifact using binary search
    public int findArtifactByBinarySearch(String artifactName) {
        int left = 0, right = totalItems - 1;  // Set left and right pointers for the search range
        while (left <= right) {  // Continue while the search range is valid
            int mid = left + (right - left) / 2;  // Find the middle index
            int comparison = collection[mid].compareTo(artifactName);  // Compare the middle artifact

            if (comparison == 0) {  // If found
                System.out.println(artifactName + " found at index " + mid + " via Binary Search.");  // Confirm finding
                return mid;  // Return the index of the found artifact
            } else if (comparison < 0) {  // If the middle artifact is less than the target
                left = mid + 1;  // Move the left pointer to the right
            } else {  // If the middle artifact is greater than the target
                right = mid - 1;  // Move the right pointer to the left
            }
        }
        System.out.println(artifactName + " not found via Binary Search.");  // Notify if not found
        return -1;  // Return -1 to indicate not found
    }

    // Method to display all artifacts in storage
    public void showCollection() {
        System.out.println("Current Collection:");
        for (int i = 0; i < totalItems; i++) {  // Iterate through the collection
            System.out.println(collection[i]);  // Print each artifact
        }
    }

    // Main method for testing the ArtifactVault functionality
    public static void main(String[] args) {
        // Create an ArtifactVault with a capacity of 5
        ArtifactVault vault = new ArtifactVault(5);

        // Add artifacts to storage
        vault.addArtifact("Golden Idol");
        vault.addArtifact("Ancient Vase");
        vault.addArtifact("Silver Coin");
        vault.addArtifact("Bronze Statue");

        // Display the current collection
        vault.showCollection();

        // Search for an artifact using linear search
        vault.findArtifactByLinearSearch("Silver Coin");

        // Search for an artifact using binary search
        vault.findArtifactByBinarySearch("Ancient Vase");

        // Remove an artifact from storage
        vault.removeArtifact("Ancient Vase");

        // Display collection after removal
        vault.showCollection();

        // Add another artifact
        vault.addArtifact("Emerald Gem");

        // Display final state of storage
        vault.showCollection();
    }
}
