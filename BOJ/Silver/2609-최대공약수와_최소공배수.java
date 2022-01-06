import java.io.*;
import java.util.*;


public class Main {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int gcd = gcd(a, b);

    System.out.println(gcd);
    System.out.print(a / gcd * b);
  }

  static int gcd(int a, int b) {
    while (b != 0) {
      int temp = a % b;

      a = b;
      b = temp;
    }
    return a;
  }

}


