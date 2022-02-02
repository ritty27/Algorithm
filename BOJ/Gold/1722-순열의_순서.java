import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();


    int N = Integer.parseInt(br.readLine());
    long[] fact = new long[21];
    fact[0] = 1;
    for (int i = 1; i <= 20; i++) {
      fact[i] = fact[i - 1] * i;
    }

    boolean[] visited = new boolean[N + 1];


    StringTokenizer st = new StringTokenizer(br.readLine());
    int problem = Integer.parseInt(st.nextToken());

    if (problem == 1) {
      long target = Long.parseLong(st.nextToken());
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (visited[j]) continue;

          if (target > fact[N - i]) {
            target -= fact[N - i];
          } else {
            sb.append(j + " ");
            visited[j] = true;
            break;
          }
        }
      }
      System.out.print(sb.toString().trim());
    } else if (problem == 2) {
      int[] nums = new int[N];
      for (int i = 0; i < N; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
      }
      long ans = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 1; j < nums[i]; j++) {
          if (!visited[j]) ans += fact[N - i - 1];
        }
        visited[nums[i]] = true;
      }

      System.out.print(ans + 1);
    }
  }
}
