import java.io.*;
import java.util.*;

public class Main {

  static long[] tree;
  static int temp;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    int s = 1;
    while (s < 1000000) {
      s *= 2;
    }

    //init
    tree = new long[s * 2];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String type = st.nextToken();
      if (type.equals("1")) {
        int number = Integer.parseInt(st.nextToken());
        query(1, s, 1, number);
        update(1, s, 1, temp, -1);
        sb.append(temp).append("\n");
      } else if (type.equals("2")) {
        int target = Integer.parseInt(st.nextToken());
        long diff = Long.parseLong(st.nextToken());
        update(1, s, 1, target, diff);
      }
    }

    System.out.print(sb);
  }

  static long query(int left, int right, int node, long number) {
    //값보다 작아서 모두 포함할 경우, 리프 노드인 경우
    if (left == right) {
      temp = right;
      return right;
    }
    //자식에게 물어볼 경우
    else if (tree[node] >= number) {
      if (tree[node * 2] < number) {
        return query((left + right) / 2 + 1, right, node * 2 + 1, number - tree[node * 2]);
      } else {
        return query(left, (left + right) / 2, node * 2, number);
      }
    }
    return 0;
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
