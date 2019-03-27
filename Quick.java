import java.util.*;

public class Quick{
    /*return the value that is the kth smallest value of the array. k=0 is the smallest
   */
   public static int quickselect(int[] data, int k) {
     int start = 0;
     int end = data.length - 1;
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

   public static void quicksort(int[] ary) {
     quickSortH(ary, 0, ary.length-1);
   }

   public static void quickSortH(int[] ary, int start, int end) {
     if (end - start > 10) {
       insertionSort(ary,start,end);
       return;
     }
     int current = partition(ary, start, end);
     quickSortH(ary, start, current - 1);
     quickSortH(ary, current + 1, end);
   }

   private static void insertionSort(int[] ary, int start, int end) {
     int len = end - start + 1;
     for (int i = 1; i < len; i++) {
       int hold = data[i+start];
       int index = i-1;
       while (index >= i && ary[index+start] > hold) {
         ary[index+start] = ary[index+start];
         index-=1;
       }
       data[index+start] = hold;
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
     if (end == start) {
       return ary[start];
     }
     Random random = new Random();
     int rand = Math.abs(random.nextInt()) % (end - start) + start;

     //System.out.println(rand);
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
       if (target == ary[start]) {
         int num = Math.abs(random.nextInt()) % 2;
         if (num == 0) {
           int swap = ary[end];
           ary[end] = ary[start];
           ary[start] = swap;
           end--;
         }
         else {
           start++;
         }
       }
     }
     //System.out.println(start);
     //System.out.println(Arrays.toString(ary));
     if (target >= ary[start]) {
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

   /*public static void main(String[] args) {
     Random random = new Random();
     int[] ary = new int[Integer.parseInt(args[0])];
     for (int i = 0; i < Integer.parseInt(args[0]); i++) {
       ary[i] = random.nextInt() % 10;
     }
     int f = partition(ary,0,19);
     System.out.println("index: " + f);
     System.out.println(Arrays.toString(ary));
   }
   */
   public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}


}
