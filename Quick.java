import java.util.*;

public class Quick{
    /*return the value that is the kth smallest value of the array. k=0 is the smallest
   */
   public static int quickselect(int[] data, int k) {
     int start = 0;
     int end = data.length - 1;
     System.out.println(Arrays.toString(data));
     while (true) {
       int current = partition(data, start, end);
       System.out.println("\n" + current);
       System.out.println(Arrays.toString(data));
       if (current > k) {
         end = current - 1;
       }
       if (current < k) {
         start = current - 1;
       }
       if (current == k) {
         return data[current];
       }
     }
   }

   /*Modify the array such that:
  *1. Only the indices from start to end inclusive are considered in range
  *2. A random index from start to end inclusive is chosen, the corresponding
  *   element is designated the pivot element.
  *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
  *4. all elements in range that are larger than the pivot element are placed after the pivot element.
  *@return the index of the final position of the pivot element.
  */
   public static int partition(int[] ary, int start, int end) {
     Random random = new Random();
     int rand = Math.abs(random.nextInt()) % (end - start);
     int target = ary[rand];
     //System.out.println("rand: " + rand + "target: "  + target);
     ary[rand] = ary[start];
     ary[start] = target;
     int begin = start;
     start++;
     while (start < end) {

       if (target > ary[start]) {
         start++;
       }
       if (target < ary[start]) {
         int swap = ary[end];
         ary[end] = ary[start];
         ary[start] = swap;
         end--;
       }
     }
     if (target > ary[start]) {
       ary[begin] = ary[start];
       ary[start] = target;
       return start;
     }
     if (target < ary[start]) {
       ary[begin] = ary[start-1];
       ary[start-1] = target;
       return start-1;
     }
     return 0;
   }

   public static void main(String[] args) {
     int[] ary = new int[] {1123,222,54,16,32,543,433,1213,43534,65435,6554,12,65,14,87,43,123,765};
     quickselect(ary,8);
   }
}
