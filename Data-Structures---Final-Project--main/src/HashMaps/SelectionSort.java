package HashMaps;

import ArrayList.MyArrayList;

public class SelectionSort {
    public static void selectionSort(int[] list) {
        int n = list.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part of the list
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }
}

