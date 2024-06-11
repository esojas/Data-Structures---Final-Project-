
import HashMaps.HeapSort;
import HashMaps.MyHashmaps;
import HashMaps.QuickSort;
import HashMaps.SelectionSort;
import SortingAlgorithm.LinearSearch;
import SortingAlgorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello what do you want to choose?");
        MyHashmaps<String, Integer> MyHashMaps = new MyHashmaps<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Hashmap");
            System.out.println("2. ArrayList");
            System.out.println("3. LinkedList");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            switch (mainChoice) {
                case 1:
                    while (true) {
                        System.out.println("1. Load data from file");
                        System.out.println("2. Add");
                        System.out.println("3. Remove");
                        System.out.println("4. Exit");
                        System.out.println("5. Sort");
                        int hashmapChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume the newline
                        switch (hashmapChoice) {
                            case 1:
                                System.out.println("Enter the file name:");
                                String fileName = scanner.nextLine();
                                 // Reinitialize the map for new file data
                                long startforFileHasmap = System.currentTimeMillis();

                                try (BufferedReader reader = new BufferedReader(new FileReader("Data-Structures---Final-Project--main/src/Data/"+fileName))) {
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        String[] parts = line.split(",");
                                        // Storing the data inside a hashmap
                                        if (parts.length == 2) {
                                            String name = parts[0].trim();
                                            int number = Integer.parseInt(parts[1].trim());
                                            MyHashMaps.put(name, number);
                                        }
                                    }
                                } catch (IOException e) {
                                    System.err.println("Error reading data from the file: " + e.getMessage());
                                }
                                long endforFileHasmap = System.currentTimeMillis();

                                System.out.println("Data loaded from " + fileName);

                                System.out.println("It takes "+(endforFileHasmap - startforFileHasmap) / 1000.+" Seconds");
                                break;
                            case 2:
                                long startforAddHasmap = System.currentTimeMillis();

                                System.out.println("Enter key to add:");
                                String addKey = scanner.nextLine();
                                System.out.println("Enter value to add:");
                                Integer addValue = Integer.valueOf(scanner.nextLine());
                                MyHashMaps.put(addKey, addValue);

                                long endforAddHasmap = System.currentTimeMillis();
                                System.out.println("Updated Hashmap: " + MyHashMaps);
                                System.out.println("It takes "+(endforAddHasmap - startforAddHasmap) / 1000.+" Seconds");
                                break;
                            case 3:
                                long startforRemovHasmap = System.currentTimeMillis();
                                System.out.println("Enter key to remove:");
                                String removeKey = scanner.nextLine();
                                MyHashMaps.remove(removeKey);
                                System.out.println("After remove Hashmap: " + MyHashMaps);
                                long endforRemovHasmap = System.currentTimeMillis();
                                System.out.println("It takes "+(endforRemovHasmap - startforRemovHasmap) / 1000.+" Seconds");
                                break;
                            case 4:
                                System.out.println("Exiting...");
                                return;
                            case 5:
                                System.out.println("1. Select");
                                System.out.println("2. Heap");
                                System.out.println("3. Quick");
                                int hashmapsortChoice = scanner.nextInt();
                                scanner.nextLine();
                                switch (hashmapsortChoice) {
                                    case 1:
                                        long startforSelectionHasmap = System.currentTimeMillis();

                                        int[] intArrayforSelectionHasmap  = Arrays.stream(MyHashMaps.values())
                                                .mapToInt(Integer::parseInt)
                                                .toArray();

                                        SelectionSort.selectionSortInt(intArrayforSelectionHasmap);

                                        long endforSelectionHasmap = System.currentTimeMillis();
                                        System.out.println("It takes "+(endforSelectionHasmap - startforSelectionHasmap) / 1000.+" Seconds");
                                        System.out.println(Arrays.toString(MyHashMaps.displayScore(intArrayforSelectionHasmap)));
                                        System.out.println("Enter the username you want to find");
                                        String hashmapselectiontargetName = scanner.nextLine();
                                        System.out.println("1. Linear");
                                        System.out.println("2. Binary");
                                        int hashmapsearchChoice = scanner.nextInt();
                                        if (hashmapsearchChoice == 1) {
                                            long startforSelectionLinearHasmap = System.currentTimeMillis();
                                            String[] stringArray = MyHashMaps.keySet();
                                            SelectionSort.selectionSortString(stringArray);
                                            if (LinearSearch.linearSearchString(stringArray, stringArray.length, hashmapselectiontargetName) == -1) {
                                                System.out.println("not found");
                                            } else {
                                                System.out.println("This person score is" + " " + MyHashMaps.get(hashmapselectiontargetName));
                                            }
                                            long endforSelectionLinearHasmap = System.currentTimeMillis();
                                            System.out.println("It takes "+(endforSelectionLinearHasmap - startforSelectionLinearHasmap) / 1000.+" Seconds");
                                            break;
                                        } else if (hashmapsearchChoice == 2) {
                                            long startforSelectionBinaryHasmap = System.currentTimeMillis();
                                            String[] stringArray = MyHashMaps.keySet();
                                            SelectionSort.selectionSortString(stringArray);
                                            if (BinarySearch.binarySearch(stringArray, hashmapselectiontargetName) == -1) {
                                                System.out.println("not found");
                                            } else {
                                                System.out.println("This person score is" + " " + MyHashMaps.get(hashmapselectiontargetName));
                                            }
                                            long endforSelectionBinaryHasmap = System.currentTimeMillis();
                                            System.out.println("It takes "+(endforSelectionBinaryHasmap - startforSelectionBinaryHasmap) / 1000.+" Seconds");
                                            break;
                                        } else {
                                            System.out.println("err");
                                        }
                                    case 2:
                                        long startforHeapHasmap = System.currentTimeMillis();

                                        int[] intArrayforHeapHasmap = Arrays.stream(MyHashMaps.values())
                                                .mapToInt(Integer::parseInt)
                                                .toArray();

                                        HeapSort.heapSortInt(intArrayforHeapHasmap);

                                        long endforHeapHasmap = System.currentTimeMillis();
                                        System.out.println("It takes "+(endforHeapHasmap - startforHeapHasmap) / 1000.+" Seconds");
                                        System.out.println(Arrays.toString(MyHashMaps.displayScore(intArrayforHeapHasmap )));
                                        System.out.println("Enter the username you want to find");
                                        String hashmapheaptargetName = scanner.nextLine();
                                        System.out.println("1. Linear");
                                        System.out.println("2. Binary");
                                        int hashmapsearchChoice2 = scanner.nextInt();
                                        if (hashmapsearchChoice2 == 1) {
                                            long startforHeapLinearHasmap = System.currentTimeMillis();
                                            String[] stringArray = MyHashMaps.keySet();
                                            HeapSort.heapSortString(stringArray);
                                            if (LinearSearch.linearSearchString(stringArray, stringArray.length, hashmapheaptargetName) == -1) {
                                                System.out.println("not found");
                                            } else {
                                                System.out.println("This person score is" + " " + MyHashMaps.get(hashmapheaptargetName));
                                            }
                                            long endforHeapLinearHasmap = System.currentTimeMillis();
                                            System.out.println("It takes "+(endforHeapLinearHasmap - startforHeapLinearHasmap) / 1000.+" Seconds");
                                            break;
                                        } else if (hashmapsearchChoice2 == 2) {
                                            long startforHeapBinaryHasmap = System.currentTimeMillis();
                                            String[] stringArray = MyHashMaps.keySet();
                                            HeapSort.heapSortString(stringArray);
                                            if (BinarySearch.binarySearch(stringArray, hashmapheaptargetName) == -1) {
                                                System.out.println("not found");
                                            } else {
                                                System.out.println("This person score is" + " " + MyHashMaps.get(hashmapheaptargetName));
                                            }
                                            long endforHeapBinaryHasmap = System.currentTimeMillis();
                                            System.out.println("It takes "+(endforHeapBinaryHasmap - startforHeapBinaryHasmap) / 1000.+" Seconds");
                                            break;
                                        } else {
                                            System.out.println("err");
                                        }
                                    case 3:
                                        long startforQuickHasmap = System.currentTimeMillis();

                                        int[] intArrayforQuickHasmap = Arrays.stream(MyHashMaps.values())
                                                .mapToInt(Integer::parseInt)
                                                .toArray();

                                        QuickSort.quickSortInt(intArrayforQuickHasmap,0,intArrayforQuickHasmap.length-1);

                                        long endforQuickHasmap = System.currentTimeMillis();
                                        System.out.println("It takes "+(endforQuickHasmap - startforQuickHasmap) / 1000.+" Seconds");
                                        System.out.println(Arrays.toString(MyHashMaps.displayScore(intArrayforQuickHasmap )));
                                        System.out.println("Enter the username you want to find");
                                        String hashmapquicktargetName = scanner.nextLine();
                                        System.out.println("1. Linear");
                                        System.out.println("2. Binary");
                                        int choice6 = scanner.nextInt();
                                        if (choice6 == 1) {
                                            long startforQuickLinearHasmap = System.currentTimeMillis();
                                            String[] stringArray = MyHashMaps.keySet();
                                            QuickSort.quickSortString(stringArray,0,stringArray.length-1);
                                            if (LinearSearch.linearSearchString(stringArray, stringArray.length, hashmapquicktargetName) == -1) {
                                                System.out.println("not found");
                                            } else {
                                                System.out.println("This person score is" + " " + MyHashMaps.get(hashmapquicktargetName));
                                            }
                                            long endforQuickLinearHasmap = System.currentTimeMillis();
                                            System.out.println("It takes "+(endforQuickLinearHasmap - startforQuickLinearHasmap) / 1000.+" Seconds");
                                            break;
                                        } else if (choice6 == 2) {
                                            long startforQuickBinaryHasmap = System.currentTimeMillis();
                                            String[] stringArray = MyHashMaps.keySet();
                                            QuickSort.quickSortString(stringArray,0,stringArray.length-1);
                                            if (BinarySearch.binarySearch(stringArray, hashmapquicktargetName) == -1) {
                                                System.out.println("not found");
                                            } else {
                                                System.out.println("This person score is" + " " + MyHashMaps.get(hashmapquicktargetName));
                                            }
                                            long endforQuickBinaryHasmap = System.currentTimeMillis();
                                            System.out.println("It takes "+(endforQuickBinaryHasmap - startforQuickBinaryHasmap) / 1000.+" Seconds");
                                            break;
                                        } else {
                                            System.out.println("err");
                                        }
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                }
                        }
                    }
                case 2:

                case 3:
                    // write your code here brandon
            }
        }
    }
}