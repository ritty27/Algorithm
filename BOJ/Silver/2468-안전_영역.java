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

  static int size;
  static int[][] map;
  static boolean[][] visited;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    size = Integer.parseInt(br.readLine());

    map = new int[size][size];
    int max = 0, ans = 0;

    for (int i = 0; i < size; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < size; j++) {
        int temp = Integer.parseInt(st.nextToken());
        map[i][j] = temp;
        max = Math.max(temp, max);
      }
    }

    for (int i = 0; i < max; i++) {
      ans = Math.max(check(i), ans);
    }

    System.out.print(ans);
  }

  private static int check(int check) {
    visited = new boolean[size][size];

    int count = 0;

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (map[i][j] > check && !visited[i][j]) {
          bfs(i, j, check);
          count++;
        }
      }
    }
    return count;
  }

  private static void bfs(int x, int y, int check) {
    Queue<Pair> queue = new LinkedList<>();
    visited[x][y] = true;
    queue.add(new Pair(x, y));

    while (!queue.isEmpty()) {
      Pair poll = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nowX = poll.x() + dx[i];
        int nowY = poll.y() + dy[i];

        if (pointInBoxCheck(nowX, nowY) && map[nowX][nowY] > check && !visited[nowX][nowY]) {
          queue.add(new Pair(nowX, nowY));
          visited[nowX][nowY] = true;
        }
      }
    }
  }

  private static boolean pointInBoxCheck(int tempX, int tempY) {
    if (tempX < 0 || tempX >= size || tempY < 0 || tempY >= size)
      return false;
    return true;
  }
}

