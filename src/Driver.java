import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        // Create a HashMap to store the name-number pairs
        MyHashmaps<String, Integer> nameToNumberMap = new MyHashmaps<>();

        // Read data from a txt file
        try (BufferedReader reader = new BufferedReader(new FileReader("Data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Storing the data inside a hashmap
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int number = Integer.parseInt(parts[1].trim());
                    nameToNumberMap.put(name, number);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from the file: " + e.getMessage());
        }
        // converting the string to an int
        System.out.println(Arrays.toString(nameToNumberMap.Values()));
        int[] intArray = Arrays.stream(nameToNumberMap.Values())
                .mapToInt(Integer::parseInt)
                .toArray();

        // sorting the score
        quickSort.quickSort(intArray,0, intArray.length-1);

        System.out.println(Arrays.toString(intArray));

        // Retrieve the corresponding names from the map
        System.out.println(Arrays.toString(nameToNumberMap.displayScore(intArray)));

    }
}

