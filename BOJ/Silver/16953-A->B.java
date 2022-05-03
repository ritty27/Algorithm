import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int cnt = 0;
    while (true) {
      cnt++;
      if (a > b) {
        System.out.print("-1");
        return;
      } else if (a == b) {
        System.out.print(cnt);
        return;
      } else if (b % 10 == 1) {
        b /= 10;
      } else if (b % 2 == 0) {
        b /= 2;
      } else {
        System.out.print("-1");
        return;
      }
    }
  }

}

