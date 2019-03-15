import java.util.*;

public class Driver{
  public static void main(String[] args) {
    int[] ary = new int[10];
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      ary[i] = Math.abs(random.nextInt()) % 100;
    }
    int f = Quick.quickselect(ary,4);
    System.out.println(f);
    System.out.println(Arrays.toString(ary));
  }
}
