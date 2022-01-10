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


  public static void main(String[] args) throws IOException {

    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testCase = Integer.parseInt(br.readLine());

    for (int testNum = 0; testNum < testCase; testNum++) {

      Queue<Pair> queue = new LinkedList<>();

      int size = Integer.parseInt(br.readLine());
      int[][] distance = new int[size][size];

      st = new StringTokenizer(br.readLine());
      queue.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      st = new StringTokenizer(br.readLine());
      Pair target = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

      if (queue.peek().x() == target.x() && queue.peek().y() == target.y()) {
        sb.append(0 + "\n");
        continue;
      }

      int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
      int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

      while (!queue.isEmpty()) {
        Pair now = queue.poll();
        int x = now.x();
        int y = now.y();
        int nowDistance = distance[x][y];

        for (int i = 0; i < 8; i++) {
          int tempX = x + dx[i];
          int tempY = y + dy[i];
          if (pointInBoxCheck(tempX, tempY, size) && distance[tempX][tempY] == 0) {
            distance[tempX][tempY] = nowDistance + 1;
            queue.add(new Pair(tempX, tempY));
          }
        }
      }


      sb.append(distance[target.x()][target.y()] + "\n");
    }
    System.out.print(sb);
  }

  private static boolean pointInBoxCheck(int tempX, int tempY, int size) {
    if (tempX < 0 || tempX >= size || tempY < 0 || tempY >= size)
      return false;
    return true;
  }

}


