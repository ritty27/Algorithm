import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

  static int dp[][] = new int[201][201];
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    if (K > combination(N + M, N)) {
      System.out.println(-1);
    } else {
      query(N, M, K);
      System.out.print(sb.toString().trim());
    }

  }

  static void query(int n, int m, int target) {
    if(n+m ==0){
      return;
    } else if(n==0){
      sb.append("z");
      query(n, m - 1, target);
    } else if(m==0){
      sb.append("a");
      query(n - 1, m, target);
    } else {
      int leftSum = combination(n + m - 1, m);
      if(leftSum >= target){
        sb.append("a");
        query(n - 1, m, target);
      } else {
        sb.append("z");
        query(n, m - 1, target - leftSum);
      }
    }
  }

  static int combination(int n, int r) {
    if (n == r || r == 0) {
      return 1;
    } else if (dp[n][r] != 0) {
      return dp[n][r];
    } else
      return dp[n][r] = Math.min((int) 1e9 + 1, combination(n - 1, r - 1) + combination(n - 1, r));
  }
}
