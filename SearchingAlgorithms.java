class SearchingAlgorithms {

    // 1. Binary Search (Iterative) → O(log n)
    static int binarySearchIterative(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // 2. Binary Search (Recursive) → O(log n)
    static int binarySearchRecursive(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == key)
            return mid;
        else if (arr[mid] > key)
            return binarySearchRecursive(arr, low, mid - 1, key);
        else
            return binarySearchRecursive(arr, mid + 1, high, key);
    }

    // 3. Recursive Linear Search → O(n)
    static int linearSearchRecursive(int[] arr, int index, int key) {
        if (index == arr.length)
            return -1;

        if (arr[index] == key)
            return index;

        return linearSearchRecursive(arr, index + 1, key);
    }

    // 4. Find Minimum using recursion → O(n)
    static int findMin(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];

        return Math.min(arr[index], findMin(arr, index + 1));
    }

    // 4. Find Maximum using recursion → O(n)
    static int findMax(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];

        return Math.max(arr[index], findMax(arr, index + 1));
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {3, 8, 12, 20, 25, 30};

        System.out.println("Binary Search Iterative (20): "
                + binarySearchIterative(arr, 20));

        System.out.println("Binary Search Recursive (25): "
                + binarySearchRecursive(arr, 0, arr.length - 1, 25));

        System.out.println("Recursive Linear Search (12): "
                + linearSearchRecursive(arr, 0, 12));

        System.out.println("Minimum value: " + findMin(arr, 0));
        System.out.println("Maximum value: " + findMax(arr, 0));
    }
}
