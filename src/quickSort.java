import java.util.Random;

public class quickSort {
    public int[] array;
    public int start;
    public int end;

    public quickSort(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public static void quickSort(int[] array, int start, int end){
        if(start >= end){ // this is so that the number wont compare itself over and over again
            return;
        }

        int pivotIndex = new Random().nextInt(end - start + 1) + start;
        int pivot = array[pivotIndex]; // I should change this to choose randomly inside the hashmap bcz its faster

        int leftPointer = partition(array, start, end, pivot);

        quickSort(array,start,leftPointer-1); //lower partition
        quickSort(array,leftPointer,end); //higher partition
    }

    private static int partition(int[] array, int start, int end, int pivot) {
        int leftPointer = start;
        int rightPointer = end;
        while(leftPointer<=rightPointer){
            while(array[leftPointer] < pivot){//keeps incrementing if pivot is less
                leftPointer++;
            }
            while(array[rightPointer] > pivot){//keeps incrementing if pivot is bigger
                rightPointer--;
            }
            if (leftPointer <= rightPointer) { // Swap elements and move pointers
                swap(array, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }
        return leftPointer;
    }

    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
