import java.io.*;
import java.util.*;


class Pair {
  private int x;
  private int y;

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}


public class Main {


  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  static int M;
  static int N;
  static boolean[][] map;

  public static void main(String[] args) throws IOException {

    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;


    st = new StringTokenizer(br.readLine());

    //편의를 위해 M, N 바꿈
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    map = new boolean[M][N];

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int startX = Integer.parseInt(st.nextToken());
      int startY = Integer.parseInt(st.nextToken());
      int endX = Integer.parseInt(st.nextToken());
      int endY = Integer.parseInt(st.nextToken());

      for (int nowX = startX; nowX < endX; nowX++) {
        for (int nowY = startY; nowY < endY; nowY++) {
          map[nowX][nowY] = true;
        }
      }
    }

    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (!map[i][j]) {
          ans.add(bfs(i, j));
        }
      }
    }

    sb.append(ans.size() + "\n");

    Collections.sort(ans);

    for (int i = 0; i < ans.size(); i++) {
      sb.append(ans.get(i) + " ");
    }

    System.out.print(sb);
  }

  private static int bfs(int x, int y) {
    Queue<Pair> queue = new LinkedList<>();
    map[x][y] = true;
    queue.add(new Pair(x, y));

    int size = 1;
    while (!queue.isEmpty()) {
      Pair poll = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nowX = poll.x() + dx[i];
        int nowY = poll.y() + dy[i];

        if (pointInBoxCheck(nowX, nowY) && !map[nowX][nowY]) {
          queue.add(new Pair(nowX, nowY));
          map[nowX][nowY] = true;
          size++;
        }
      }
    }

    return size;
  }


  private static boolean pointInBoxCheck(int tempX, int tempY) {
    if (tempX < 0 || tempX >= M || tempY < 0 || tempY >= N)
      return false;
    return true;
  }

}

