import java.io.*;
import java.util.*;


public class Main {

  static long[] tree;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int s = 1;
    while (s < N) {
      s *= 2;
    }

    //init
    tree = new long[s * 2];
    for (int i = 0; i < N; i++) {
      tree[s + i] = Long.parseLong(br.readLine());
    }

    for (int i = s - 1; i > 0; i--) {
      tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());
      String type = st.nextToken();
      if (type.equals("1")) {
        int target = Integer.parseInt(st.nextToken());
        long diff = Long.parseLong(st.nextToken()) - tree[s + target - 1];
        update(1, s, 1, target, diff);
      }
      else if (type.equals("2")) {
        sb.append(query(1, s, 1, Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()))).append("\n");
      }
    }

    System.out.print(sb);
  }

  static long query(int left, int right, int node, int queryLeft, int queryRight) {
    //상관 없을 때
    if (queryRight < left || right < queryLeft) {
      return 0;
    }
    //판단 가능 ->값을 줄 때
    else if (queryLeft <= left && right <= queryRight) {
      return tree[node];
    }
    // 자식에게 값을 물어볼 때
    else {
      int mid = (left + right) / 2;
      long tempLeft = query(left, mid, node * 2, queryLeft, queryRight);
      long tempRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
      return tempLeft + tempRight;
    }
  }

  static void update(int left, int right, int node, int target, long diff) {
    //타켓이 범위 밖이라면 return
    if (target < left || right < target) {
      return;
    }
    //타켓이 범위 안에 있을 때
    else {
      tree[node] += diff;
      //리프 노드가 아니라면
      if (left != right) {
        int mid = (left + right) / 2;
        update(left, mid, node * 2, target, diff);
        update(mid + 1, right, node * 2 + 1, target, diff);
      }
    }
  }
}
