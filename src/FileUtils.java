

import java.io.*;
import java.util.ArrayList;

public class FileUtils {
    public static int[] readIntegersFromFile(String filePath) {
        ArrayList<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); // Remove leading/trailing spaces
                if (!line.isEmpty()) { // Skip empty lines
                    try {
                        list.add(Integer.parseInt(line)); // Parse valid integers
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void writeIntegersToFile(int[] array, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath)))) {
            for (int num : array) {
                bw.write(num + "\n");
                bw.flush();

            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }
}
