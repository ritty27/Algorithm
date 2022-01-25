import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    int[] array = new int[num];
    int[] gcdLtoR = new int[num];
    int[] gcdRtoL = new int[num];

    int max = -1;
    int maxIndex = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < num; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }

    gcdLtoR[0] = array[0];
    for (int i = 1; i < num; i++) {
      gcdLtoR[i] = gcd(array[i], gcdLtoR[i - 1]);
    }
    gcdRtoL[num - 1] = array[num - 1];
    for (int i = num - 2; i >= 0; i--) {
      gcdRtoL[i] = gcd(array[i], gcdRtoL[i + 1]);
    }


    for (int i = 0; i < num; i++) {
      int gcd = 0;
      if (i == 0) {
        gcd = gcdRtoL[1];
      } else if (i == num - 1) {
        gcd = gcdLtoR[num - 2];
      } else {
        gcd = gcd(gcdLtoR[i - 1], gcdRtoL[i + 1]);
      }

      if (array[i] % gcd != 0 && gcd > max) {
        max = gcd;
        maxIndex = i;
      }
    }

    if (max == -1) {
      System.out.print(max);
    } else {
      System.out.print(max + " " + array[maxIndex]);
    }
  }

  static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}
