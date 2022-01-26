import greenfoot.*;    
 /**
     * Write a description of class Utilities here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Utilities  
    {
    
    public Utilities()
    {
    }
    public static void reverseArray(int[] arr)
    {
        int start = 0; 
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start = start + 1;
            end = end - 1;
        }
    }
    public static int partition(int[] arr, int lo, int hi) 
    {
            int i = lo; 
            int j = hi + 1;
            while (true) {
                while (arr[++i] < arr[lo])  // Find item on left to swap  
                    if (i == hi) break; 
                while (arr[--j] > arr[lo]) 
                    if (j == lo) break;
                
                if (i >= j) break;  // Check if pointers cross 
                swap(arr, i, j);  // Swap
            } 
            swap(arr, lo, j);  // Swap partitioning element  
            return j;  // Return index of item now know to be in place
    }
    
    private static void shuffle(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            int a = Greenfoot.getRandomNumber(arr.length - i) + i; 
            swap(arr, i, a); 
        }
    }
    
    private static void swap(int[] arr, int i, int j)
    {
        int placeHolder = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = placeHolder; 
    }
    
    public static void quickSort(int[] arr) 
    {
     shuffle(arr); 
     quicksort(arr, 0, arr.length - 1); 
    }
 
    private static void quicksort(int[] arr, int lo, int hi) 
    {
         if (hi <= lo) return;
         int j = partition(arr, lo, hi); 
         quicksort(arr, lo, j-1); 
         quicksort(arr, j+1, hi); 
    }

}
