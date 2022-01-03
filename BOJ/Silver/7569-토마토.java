import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
  int x;
  int y;
  int z;

  public Point(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    int[][][] box = new int[N][M][H];
    Queue<Point> qu = new LinkedList<>();

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < M; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < N; k++) {
          box[k][j][i] = Integer.parseInt(st.nextToken());
          if (box[k][j][i] == 1) {
            qu.add(new Point(k, j, i));
          }
        }
      }
    }


    int ans = bfs(N, M, H, box, qu);

    System.out.print(ans);
  }

  private static int bfs(int N, int M, int H, int[][][] box, Queue<Point> qu) {
    int[] dx = {-1, 0, 1, 0, 0, 0};
    int[] dy = {0, 1, 0, -1, 0, 0};
    int[] dz = {0, 0, 0, 0, -1, 1};

    int ans = 0;

    while (!qu.isEmpty()) {
      Point point = qu.poll();

      for (int i = 0; i < 6; i++) {
        int tempX = point.x + dx[i];
        int tempY = point.y + dy[i];
        int tempZ = point.z + dz[i];

        if (0 <= tempX && tempX < N && 0 <= tempY && tempY < M && 0 <= tempZ && tempZ < H) {
          if (box[tempX][tempY][tempZ] == 0) {
            qu.add(new Point(tempX, tempY, tempZ));
            box[tempX][tempY][tempZ] = box[point.x][point.y][point.z] + 1;
          }
        }
      }

    }
    
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < M; j++) {
        for (int k = 0; k < N; k++) {
          if (box[k][j][i] == 0) return -1;
          ans = Math.max(box[k][j][i], ans);
        }
      }
    }
    if (ans == 1) return 0;

    return ans - 1;
  }


}


