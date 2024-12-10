import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create an instance of FileUtils
        FileUtils fileUtils = new FileUtils();

        // Load random numbers from the file
        int[] randomNumbers = readIntegersFromFile("random200000.txt");

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

        // Save the sorted results to files
        fileUtils.saveFile("BubbleSortedRandomNumbers.txt", bubbleSorted);
        fileUtils.saveFile("MergeSortedRandomNumbers.txt", mergeSorted);
    }

    private static int[] readIntegersFromFile(String filename) {
        // Read integers from a file and return as an array
        try {
            File file = new File(filename);
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                ArrayList<Integer> numbersList = new ArrayList<>();
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    for (String part : parts) {
                        numbersList.add(Integer.parseInt(part.trim()));
                    }
                }
                br.close();
                return numbersList.stream().mapToInt(Integer::intValue).toArray();
            } else {
                System.out.println("File not found: " + filename);
                return new int[0];
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + e.getLocalizedMessage());
            return new int[0];
        }
    }
}
