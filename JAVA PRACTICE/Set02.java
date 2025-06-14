import java.util.*;
public class Set02 {
    public static int secondlargest(int[]arr){
        int max= Integer.MIN_VALUE;
        int sec_max=-1;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max, arr[i]);
            }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>sec_max &&arr[i]!=max){
                sec_max = arr[i];
            }
        }
            return sec_max;
    }
    public static  int secondsmallest(int[] arr){
        int min=Integer.MAX_VALUE;
        int sec_min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            min=Math.min(min,arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<sec_min&& arr[i]!=min){
                sec_min=arr[i];
            }
        }
        return sec_min;
    }
    public static int[] sortarray(int[]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }

        }
        return arr;
    }
    public static int[] descendingorder(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
    public static int[] removeduplicates(int[] arr) {
    if (arr.length == 0 || arr.length == 1) {
        return arr;
    }

    int[] temp = new int[arr.length];
    int j = 0;

    for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] != arr[i + 1]) {
            temp[j++] = arr[i];
        }
    }

   
    temp[j++] = arr[arr.length - 1];

    
    int[] result = new int[j];
    for (int i = 0; i < j; i++) {
        result[i] = temp[i];
    }

    return result;
}
public static int[] mergearrays(int[] arr, int[] arr1) {
    int[] result= new int[arr.length + arr1.length];
    for (int i = 0; i < arr.length; i++) {
        result[i] = arr[i];
    }   
    for (int i = 0; i < arr1.length; i++) {
        result[arr.length + i] = arr1[i];
    }
    return result;
}
public static int[] comparearrays(int[] arr, int[] arr1) {
    int[] result = new int[Math.min(arr.length, arr1.length)];
    for (int i = 0; i < result.length; i++) {
        if (arr[i] > arr1[i]) {
            result[i] = arr[i];
        } else {
            result[i] = arr1[i];
        }
    }
    return result;
}
public static int[] leftrotate(int[] arr, int d) {
    int n = arr.length;
    d = d % n; 
    int[] rotated = new int[n];
    for (int i = 0; i < n; i++) {
        rotated[i] = arr[(i + d) % n];
    }
    return rotated;
}
public static int[] rightrotate(int[] arr, int d) {
    int n = arr.length;
    d = d % n;
    int[] rotated = new int[n];
    for (int i = 0; i < n; i++) {
        rotated[i] = arr[(i - d + n) % n];
    }
    return rotated;
}
public static  int frequency(int[] arr, int key) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == key) {
            count++;
        }
    }
    return count;

}
public static int evenpostionelements(int[] arr) {
    
    for (int i = 0; i < arr.length; i++) {
        if (i % 2 == 0) {
            return arr[i];
        }
    }
    return -1; 
}
public static int oddpostionelements(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        if (i % 2 != 0) {
            return arr[i];
        }
    }
    return -1;
}
public static int[] swapfirstandlast(int[] arr) {
    if (arr.length < 2) {
        return arr; 
    }
    int temp = arr[0];
    arr[0] = arr[arr.length - 1];   
    arr[arr.length - 1] = temp;
    return arr;
}

public static int[] seperateEvenAndOdd(int[] arr) {
      int evenCount = 0, oddCount = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            }
            else 
            {
                oddCount++;
            }
        }
        int[] result = new int[evenCount + oddCount];
        int evenIndex = 0, oddIndex = evenCount;
        for (int num : arr) {
            if (num % 2 == 0) {
                result[evenIndex++] = num;
            } else {
                result[oddIndex++] = num;
            }
        }
        return result;
    }
    public static int missingNumber(int[] nums){
        int n=nums.length;
        for(int i=1;i<=n;i++){
            int flag=0;
            for(int j=0;j<n;j++){
                if(nums[j]==i){
                    flag=1;
                    break;
                }
            }
                if(flag==0){
                    return i ;
                }
            }

        
        return -1;
    }



    


    

    

        
    
    public static void main(String args[]){
        int[] arr={3,5,1,4,4,8};
        int[] arr1={2,6,7,8,9};
        int[] nums={1,2,3,5,6,7,8,9,10};
        System.out.println(secondlargest(arr));
        System.out.println(secondsmallest(arr));
        
       System.out.println("Sorted array in ascending order:" + Arrays.toString(sortarray(arr)));
        System.out.println("Sorted array in descending order:" +Arrays.toString(descendingorder(arr)));
        System.out.println("Array after removing duplicates:" +Arrays.toString(removeduplicates(arr)));
        System.out.println("Merged array:" + Arrays.toString(mergearrays(arr, arr1)));
        System.out.println("Compared array:" + Arrays.toString(comparearrays(arr, arr1)));
        System.out.println("Left rotated array:" + Arrays.toString(leftrotate(arr, 2)));
        System.out.println("Right rotated array:" + Arrays.toString(rightrotate(arr, 2)));
        System.out.println("Frequency of 4 in the array: " + frequency(arr, 4));
        System.out.println("Frequency of 10 in the array: " + frequency(arr, 10));
        System.out.println("Frequency of 1 in the array: " + frequency(arr, 1));
        System.out.println("Frequency of 3 in the array: " + frequency(arr, 3));    
        System.out.println("Frequency of 5 in the array: " + frequency(arr, 5));
        System.out.println("Frequency of 8 in the array: " + frequency(arr, 8));
        System.out.println("Element at even position: " + evenpostionelements(arr));
        System.out.println("Element at odd position: " + oddpostionelements(arr));
        System.out.println("Array after swapping first and last elements: " + Arrays.toString(swapfirstandlast(arr)));
        System.out.println("Array after separating even and odd elements: " + Arrays.toString(seperateEvenAndOdd(arr)));
        System.out.println("Missing number in the array: " + missingNumber(nums));


    }
    
}
