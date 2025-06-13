import java.util.*;
public class Set01{
    //declare and initialize an array
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    //take input and store in array
     public static void inputArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }
    
    //print the array
     public static void printArray() {
        System.out.println("The elements of the array are:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //find the length of array
    public static int length() {
        return arr.length;
    }
     //find specific index kof array
    public static int get(int index) {
        
        return arr[index];
    }
    //sum of all elements in the array
     public static int sum() {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    //average of array elements
    public static String average() {
        int avg = sum() / length();
        return String.valueOf(avg);
    }
    // //find the maximum element in the array
    public static int max() {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    //find the minimum element in the array
    public static int min() {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    //count even and odd numbers in the array
    public static void countEvenOdd() {
        int evenCount = 0;
        int  oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Even Count: " + evenCount  );
        System.out.println(", Odd Count: " + oddCount);
    }
    //reverse the array
    public static void reverse() {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.println("Reversed array:");
        printArray();
    }
    // //copy the array
    public static int[] copy() {
        int[] copyArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArray[i] = arr[i];
        }
        return copyArray;
    }
    // //linear search in the array
    public static int linearSearch(int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; 
            }
        }
        return -1; 
    }
    // //check if array contains a value
    public static boolean contains(int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return true; 
            }
        }
        return false; 
    }
    // //count occurences of an element
     public static void main(String[] args) {
        inputArray();   

        printArray();
        System.out.println("Length: " + length());
        System.out.println("Element at index 2: " + get(2));
        System.out.println("Sum: " + sum());
        System.out.println("Average:"+average());
        System.out.println("Max: " + max());
        System.out.println("Min: " + min());
        countEvenOdd();
        reverse();
        int[] copiedArray = copy();
        System.out.println("Copied array: " + Arrays.toString(copiedArray));
        int key = 5;
        System.out.println("Index of " + key + ": " + linearSearch(key));
        System.out.println("Array contains " + key + ": " + contains(key));
        System.out.println("Occurrences of " + key + ": " + contains(key));
    }

}