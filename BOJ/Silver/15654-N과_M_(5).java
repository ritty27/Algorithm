import java.io.*;
import java.util.*;


public class Main {

  static int n;
  static int m;

  static int[] input;
  static int[] temp;
  static boolean[] visited;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    input = new int[n];
    temp = new int[n];
    visited = new boolean[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(input);
    dfs(0);
    System.out.print(sb);

  }

  static void dfs(int depth) {
    if (depth == m) {
      for (int i = 0; i < m; i++) {
        sb.append(temp[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        temp[depth] = input[i];
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }
}
