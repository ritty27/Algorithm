import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String P = st.nextToken();
    int K = Integer.parseInt(st.nextToken());

    boolean[] isNotPrime = new boolean[K];
    isNotPrime[0] = isNotPrime[1] = true;

    for (int i = 1; i * i < K; i++) {
      if (isNotPrime[i] == false) {
        for (int j = i * 2; j < K; j += i) {
          isNotPrime[j] = true;
        }
      }
    }

    List<Integer> primeList = new ArrayList<>();
    for (int i = 1; i < K; i++) {
      if (isNotPrime[i] == false) primeList.add(i);
    }

    for (int i = 0; i < primeList.size(); i++) {
      Integer prime = primeList.get(i);
      int number = P.charAt(0) - '0';
      for (int j = 1; j < P.length(); j++) {
        number %= prime;
        int temp = P.charAt(j) - '0';
        number = 10 * number + temp;
      }
      if (number % prime == 0) {
        System.out.print("BAD " + prime);
        return;
      }
    }
    System.out.print("GOOD");
  }
}

