class RecursionProblems {

    // 1️ Factorial
    // Base case: n == 1, return 1
    // Recursive case: n * factorial(n-1)
    static int factorial(int n) {
        if (n == 1) return 1; // base case
        return n * factorial(n - 1); // recursive case
    }

    // 2️ Fibonacci
    // Base case: n <= 1, return n
    // Recursive case: fib(n-1) + fib(n-2)
    static int fibonacci(int n) {
        if (n <= 1) return n; // base case
        return fibonacci(n - 1) + fibonacci(n - 2); // recursive case
    }

    // 3️ Sum of array elements
    // Base case: index == arr.length, return 0
    // Recursive case: arr[index] + sum(arr, index+1)
    static int sumArray(int[] arr, int index) {
        if (index == arr.length) return 0; // base case
        return arr[index] + sumArray(arr, index + 1); // recursive case
    }

    // 4️ Check if array is sorted
    // Base case: index == arr.length - 1, return true
    // Recursive case: arr[index] <= arr[index+1] && isSorted(arr, index+1)
    static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) return true; // base case
        return arr[index] <= arr[index + 1] && isSorted(arr, index + 1); // recursive case
    }

    // 5️ Find minimum element in array
    // Base case: index == arr.length - 1, return arr[index]
    // Recursive case: min(arr[index], min(arr, index+1))
    static int findMin(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index]; // base case
        return Math.min(arr[index], findMin(arr, index + 1)); // recursive case
    }

    // 5️ Find maximum element in array
    // Base case: index == arr.length - 1, return arr[index]
    // Recursive case: max(arr[index], max(arr, index+1))
    static int findMax(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index]; // base case
        return Math.max(arr[index], findMax(arr, index + 1)); // recursive case
    }

    // Main method
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8};
        int[] arr2 = {3, 5, 7, 9};

        // Factorial
        System.out.println("Factorial of 5: " + factorial(5));

        // Fibonacci
        System.out.println("Fibonacci at position 6: " + fibonacci(6));

        // Sum of array
        System.out.println("Sum of array {2,4,6,8}: " + sumArray(arr1, 0));

        // Check if sorted
        System.out.println("Is array {3,5,7,9} sorted? " + isSorted(arr2, 0));

        // Min and Max
        System.out.println("Minimum of array {2,4,6,8}: " + findMin(arr1, 0));
        System.out.println("Maximum of array {2,4,6,8}: " + findMax(arr1, 0));
    }
}
