import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    boolean isNotPrime[] = new boolean[N + 1];
    List<Integer> primeList = new ArrayList<>();

    isNotPrime[0] = isNotPrime[1] = true;
    for (int i = 2; i*i <= N; i++) {
      if (!isNotPrime[i]) {
        for (int j = i * i; j <= N; j += i) {
          isNotPrime[j] = true;
        }
      }
    }

    for (int i = 0; i <= N; i++) {
      if (!isNotPrime[i]) {
        primeList.add(i);
      }
    }

    int size = primeList.size();
    int left = 0;
    int right = 0;
    int sum = 0;

    int count = 0;
    while (true) {
      if (sum >= N) {
        sum -= primeList.get(left++);
      } else if (right == primeList.size()) {
        break;
      } else {
        sum += primeList.get(right++);
      }

      if (sum == N) {
        count++;
      }
    }
    System.out.print(count);
  }
}
