import java.util.Arrays;

public class Set03 {

    public static void deleteelement(int[] arr, int key) {
        int[] result = new int[arr.length - 1];
        if (key < 0 || key >= arr.length) {
            System.out.println("Invalid key");
            return;
        }
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == key) continue;
            result[j++] = arr[i];
        }
        System.out.print("Delete element at index " + key + ": ");
        printArray(result);
    }

    public static void removealloccurences(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num != target) count++;
        }
        int[] result = new int[count];
        int j = 0;
        for (int num : arr) {
            if (num != target) result[j++] = num;
        }
        System.out.print("Remove all occurrences of " + target + ": ");
        printArray(result);
    }

    public static void replaceelement(int[] arr, int ele, int replace) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                arr[i] = replace;
            }
        }
        System.out.print("Replace " + ele + " with " + replace + ": ");
        printArray(arr);
    }

    public static void swapelements(int[] arr, int index1, int index2) {
        if (index1 < 0 || index1 >= arr.length || index2 < 0 || index2 >= arr.length) {
            System.out.println("Invalid Index");
            return;
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        System.out.print("Swap elements at " + index1 + " and " + index2 + ": ");
        printArray(arr);
    }

    public static void removeDuplicates(int[] arr) {
        if (arr.length == 0) return;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        System.out.print("Remove duplicates (sorted array): ");
        for (int i = 0; i <= j; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void shiftZero(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num != 0) arr[count++] = num;
        }
        while (count < arr.length) {
            arr[count++] = 0;
        }
        System.out.print("Shift zeros to end: ");
        printArray(arr);
    }

    public static void evennoZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) arr[i] = 0;
        }
        System.out.print("Replace even numbers with 0: ");
        printArray(arr);
    }

    public static void negativenumbersquare(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) arr[i] *= arr[i];
        }
        System.out.print("Square odd numbers: ");
        printArray(arr);
    }

    public static void doubleelement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
        System.out.print("Double each element: ");
        printArray(arr);
    }

    public static void replacenumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num <= 1) continue;
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) arr[i] = -1;
        }
        System.out.print("Replace primes with -1: ");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] original = {0, 0, 1, 3, -1, 7, -3, 11, 11, 13};

        deleteelement(Arrays.copyOf(original, original.length), 2);
        removealloccurences(Arrays.copyOf(original, original.length), 11);
        replaceelement(Arrays.copyOf(original, original.length), 1, 6);
        swapelements(Arrays.copyOf(original, original.length), 2, 3);
        removeDuplicates(new int[]{0, 0, 1, 1, 2, 2, 3}); // Must be sorted
        shiftZero(Arrays.copyOf(original, original.length));
        evennoZero(Arrays.copyOf(original, original.length));
        negativenumbersquare(Arrays.copyOf(original, original.length));
        doubleelement(Arrays.copyOf(original, original.length));
        replacenumbers(Arrays.copyOf(original, original.length));
    }
}
