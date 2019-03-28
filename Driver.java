import java.util.*;

public class Driver{
  public static void main(String[] args) {
    int[] ary = new int[1000];
    Random random = new Random();
    for (int i = 0; i < 1000; i++) {
      ary[i] = Math.abs(random.nextInt()) % 100;
    }
    Quick.quicksort(ary);
    System.out.println(Arrays.toString(ary));
  }
}
