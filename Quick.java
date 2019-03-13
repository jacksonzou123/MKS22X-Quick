import java.util.*;

public class Quick{
    /*return the value that is the kth smallest value of the array. k=0 is the smallest
   */
   public static int quickSelect(int[] data, int k) {
     int start = 0;
     int end = data.length - 1;
     System.out.println(Arrays.toString(data));
     int current = 0;
     while (current != k) {
       current = partition(data, start, end);
       //System.out.println("\n" + current);
       //System.out.println(Arrays.toString(data));
       if (current > k) {
         end = current - 1;
       }
       if (current < k) {
         start = current + 1;
       }
     }
     return data[current];
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
     if (end == start) {
       return ary[start];
     }
     Random random = new Random();
     int rand = Math.abs(random.nextInt()) % (end - start);
     //System.out.println(rand);
     int target = ary[rand];
     //System.out.println("rand: " + rand + "target: "  + target);
     ary[rand] = ary[start];
     ary[start] = target;
     int begin = start;
     start++;
     while (start < end) {
       if (target >= ary[start]) {
         start++;
       }
       if (target < ary[start]) {
         int swap = ary[end];
         ary[end] = ary[start];
         ary[start] = swap;
         end--;
       }
     }
     //System.out.println(start);
     //System.out.println(Arrays.toString(ary));
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
     Random random = new Random();
     int[] ary = new int[Integer.parseInt(args[0])];
     for (int i = 0; i < Integer.parseInt(args[0]); i++) {
       ary[i] = random.nextInt() % 100;
     }
     int f = quickSelect(ary,15);
     boolean correct = true;
     for (int j = 0; j < 15; j++) {
       if (ary[j] > ary[15]) {
         correct = false;
       }

     }
     System.out.println(correct);
   }
}
