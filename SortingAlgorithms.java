class SortingAlgorithms {

    // 1️ Merge Sort → O(n log n) time, O(n) space
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);      // Sort left half
            mergeSort(arr, mid + 1, right); // Sort right half
            merge(arr, left, mid, right);   // Merge two halves
        }
    }

    // Merge helper for Merge Sort
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // 2️ Quick Sort → O(n log n) avg, O(n^2) worst case, O(1) extra space (in-place)
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition helper for Quick Sort
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }

        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    // Helper to print array
    static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] arr1 = {5, 1, 4, 2, 8};
        int[] arr2 = {5, 1, 4, 2, 8}; // Copy for Quick Sort

        // Merge Sort
        System.out.println("Original Array for Merge Sort:");
        printArray(arr1);

        mergeSort(arr1, 0, arr1.length - 1);

        System.out.println("Sorted Array (Merge Sort):");
        printArray(arr1);

        // Quick Sort
        System.out.println("\nOriginal Array for Quick Sort:");
        printArray(arr2);

        quickSort(arr2, 0, arr2.length - 1);

        System.out.println("Sorted Array (Quick Sort):");
        printArray(arr2);
    }
}
