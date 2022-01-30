import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    int[] fibonacci = new int[num + 2];
    fibonacci[1] = 1;
    fibonacci[2] = 3;

    for (int i = 3; i <= num; i++) {
      fibonacci[i] = (fibonacci[i - 1] + 2* fibonacci[i - 2]) % 10007;
    }

    System.out.print(fibonacci[num]);
  }
}
