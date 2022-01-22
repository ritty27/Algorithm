import java.io.*;
import java.util.StringTokenizer;


public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    long[] x = new long[num + 1];
    long[] y = new long[num + 1];

    for (int i = 0; i < num; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      x[i] = Long.parseLong(st.nextToken());
      y[i] = Long.parseLong(st.nextToken());
    }

    x[num] = x[0];
    y[num] = y[0];

    long sumA = 0, sumB = 0;
    for (int i = 0; i < num; i++) {
      sumA += x[i] * y[i + 1];
      sumB += x[i+1] * y[i];
    }

    String area = String.format("%.1f", (Math.abs(sumA - sumB)) / 2.0);
    System.out.print(area);
  }
}
