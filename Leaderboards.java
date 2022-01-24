import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Leaderboards here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leaderboards extends World
{

    /**
     * Constructor for objects of class Leaderboards.
     * 
     */
    public Leaderboards()
    {    
        super(1200,800, 1);
        
        
    }
    
    /*
     public int partition(int[] arr, int lo, int hi) 
    {
            int i = lo; 
            int j = hi + 1;
            while (true) {
                while (arr[++i] < arr[lo])  // Find item on left to swap  
                    if (i == hi) break; 
                while (arr[--j] > arr[lo]) 
                    if (j == lo) break;
                
                if (i >= j) break;  // Check if pointers cross 
                ut.swap(arr, i, j);  // Swap
            } 
            ut.swap(arr, lo, j);  // Swap partitioning element  
            return j;  // Return index of item now know to be in place
    }

    public void quickSort(int[] arr) 
    {
     ut.shuffle(arr); 
     quicksort(arr, 0, arr.length - 1); 
    }

     // quicksort the subarray from a[lo] to a[hi]  
     private void quicksort(int[] arr, int lo, int hi) 
     {
         if (hi <= lo) return;
         int j = partition(arr, lo, hi); 
         quicksort(arr, lo, j-1); 
         quicksort(arr, j+1, hi); 
         drawArray(arr, lo, numE);
     }
     */
}
