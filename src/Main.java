

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Load random numbers from the file
        int[] randomNumbers = FileUtils.readIntegersFromFile("C:\\Users\\Djiby\\OneDrive\\Desktop\\USA1000Cities2024\\src\\usa1000cities2024\\random200000.txt");

        // Sort using Bubble Sort (Group A)
        System.out.println("\nSorting Random200000.txt using Bubble Sort...\n");
        int[] bubbleSorted = Arrays.copyOf(randomNumbers, randomNumbers.length); // Make a copy for sorting
        long startBubble = System.nanoTime(); // Capture start time in nanoseconds
        SortAlgorithms.bubbleSort(bubbleSorted);
        long endBubble = System.nanoTime(); // Capture end time in nanoseconds
        long bubbleTime = endBubble - startBubble; // Calculate time taken
        System.out.println("Bubble Sort Completed. Verified: " + Verification.isSorted(bubbleSorted));
        System.out.println("Bubble Sort Time: " + bubbleTime + " nanoseconds");

        // Sort using Merge Sort (Group B)
        System.out.println("\nSorting Random200000.txt using Merge Sort...\n");
        int[] mergeSorted = Arrays.copyOf(randomNumbers, randomNumbers.length); // Make a copy for sorting
        long startMerge = System.nanoTime(); // Capture start time in nanoseconds
        SortAlgorithms.mergeSort(mergeSorted, 0, mergeSorted.length - 1);
        long endMerge = System.nanoTime(); // Capture end time in nanoseconds
        long mergeTime = endMerge - startMerge; // Calculate time taken
        System.out.println("Merge Sort Completed. Verified: " + Verification.isSorted(mergeSorted));
        System.out.println("Merge Sort Time: " + mergeTime + " nanoseconds");

        // Compare times between sorting algorithms
        if (bubbleTime < mergeTime) {
            System.out.println("\nBubble Sort was faster by " + (mergeTime - bubbleTime) + " nanoseconds.");
        } else if (mergeTime < bubbleTime) {
            System.out.println("\nMerge Sort was faster by " + (bubbleTime - mergeTime) + " nanoseconds.");
        } else {
            System.out.println("\nBoth algorithms took the same time: " + bubbleTime + " nanoseconds.");
        }

        // Print all sorted arrays (for smaller arrays, or use file output for large ones)
        System.out.println("\nBubble Sorted Array (All elements):");
        printArray(bubbleSorted);

        System.out.println("\nMerge Sorted Array (All elements):");
        printArray(mergeSorted);

        // Save the sorted results to files
        FileUtils.writeIntegersToFile(bubbleSorted, "C:\\Users\\Djiby\\OneDrive\\Desktop\\BubbleSortedRandomNumbers.txt");
        FileUtils.writeIntegersToFile(mergeSorted, "C:\\Users\\Djiby\\OneDrive\\Desktop\\MergeSortedRandomNumbers.txt");

    }

    private static void printArray(int[] array) {
        // Print all elements of the array
        System.out.println(Arrays.toString(array));
    }
}
