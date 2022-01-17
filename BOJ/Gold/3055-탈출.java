import java.io.*;
import java.util.*;

class Point {
  private int x;
  private int y;
  private char type;

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  public char type() {
    return type;
  }

  public Point(int x, int y, char type) {
    this.x = x;
    this.y = y;
    this.type = type;
  }
}

public class Main {

  static StringBuilder sb = new StringBuilder();

  static int R, C;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    Queue<Point> queue = new LinkedList<>();
    int[][] map = new int[R][C];
    int[][] distance = new int[R][C];
    Point source = null;

    for (int i = 0; i < R; i++) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        char temp = str.charAt(j);
        if (temp == '*') {
          queue.add(new Point(i, j, 'W'));
          map[i][j] = -1;
        } else if (temp == 'D') {
          map[i][j] = -2;
        } else if (temp == 'S') {
          source = new Point(i, j, 'S');
        } else if (temp == 'X') {
          map[i][j] = -3;
        }
      }
    }


    queue.add(source);

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    while (!queue.isEmpty()) {
      Point p = queue.poll();
      int value = distance[p.x()][p.y()];

      for (int i = 0; i < 4; i++) {
        int nowX = p.x() + dx[i];
        int nowY = p.y() + dy[i];

        if (inMapCheck(nowX, nowY)) {
          if (p.type() == 'S') {
            if (map[nowX][nowY] == -2) {
              System.out.print(value + 1);
              return;
            } else if (map[nowX][nowY] == 0) {
              map[nowX][nowY] = -1;
              distance[nowX][nowY] = value + 1;
              queue.add(new Point(nowX, nowY, 'S'));
            }
          }
          if (p.type() == 'W') {
            if (map[nowX][nowY] != -1 && map[nowX][nowY] != -2 && map[nowX][nowY] != -3) {
              map[nowX][nowY] = -1;
              queue.add(new Point(nowX, nowY, 'W'));
            }

          }
        }
      }
    }

    System.out.print("KAKTUS");
  }

  static boolean inMapCheck(int x, int y) {
    if (x < 0 || x >= R || y < 0 || y >= C) return false;
    return true;
  }
}
