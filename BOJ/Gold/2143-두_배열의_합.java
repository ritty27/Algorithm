import java.io.*;
import java.util.*;


public class Main {

  static ArrayList<Long> sumA, sumB;
  static int T;
  static BufferedReader br;

  public static void main(String[] args) throws IOException {

    br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    T = Integer.parseInt(st.nextToken());

    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int[] array = new int[N + 1];
    for (int i = 0; i < N; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }
    sumA = new ArrayList<>();

    allSum(N, array, sumA);

    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    array = new int[N + 1];
    for (int i = 0; i < N; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }
    sumB = new ArrayList<>();

    allSum(N, array, sumB);

    Collections.sort(sumA);
    Collections.sort(sumB, Comparator.reverseOrder());

    long result = 0;
    int ptA = 0;
    int ptB = 0;

    while (ptA < sumA.size() && ptB < sumB.size()) {
      long currentA = sumA.get(ptA);
      long target = T - currentA;

      if (sumB.get(ptB) == target) {
        long countA = 0;
        long countB = 0;
        while (ptA < sumA.size() && sumA.get(ptA) == currentA) {
          countA++;
          ptA++;
        }
        while (ptB < sumB.size() && sumB.get(ptB) == target) {
          countB++;
          ptB++;
        }
        result += countA * countB;
      } else if (sumB.get(ptB) > target) {
        ptB++;
      } else if (sumB.get(ptB) < target) {
        ptA++;
      }
    }


    System.out.print(result);
  }

  private static void allSum(int N, int[] array, ArrayList<Long> sumArray) {

    for (int low = 0; low < N; low++) {
      long sum = array[low];
      sumArray.add(sum);
      for (int high = low + 1; high < N; high++) {
        sum += array[high];
        sumArray.add(sum);
      }
    }
  }
}
