import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    char[][] map = new char[R + 2][C + 2];
    for (int i = 1; i <= R; i++) {
      String column = br.readLine();
      for (int j = 1; j <= C; j++) {
        map[i][j] = column.charAt(j - 1);
      }
    }

    int[][] leftDown = new int[R + 2][C + 2];
    int[][] rightDown = new int[R + 2][C + 2];

    for (int i = R; i >= 1; i--) {
      for (int j = 1; j <= C; j++) {
        if (map[i][j] == '1') {
          rightDown[i][j] = rightDown[i + 1][j + 1] + 1;
          leftDown[i][j] = leftDown[i + 1][j - 1] + 1;
        }
      }
    }
    int ans = 0;
    for (int i = 1; i <= R; i++) {
      for (int j = 1; j <= C; j++) {
        int possibleSize = Math.min(leftDown[i][j], rightDown[i][j]);

        if (possibleSize == 1) {
          ans = Math.max(ans, 1);
        } else {
          for (; possibleSize > 1; possibleSize--) {
            int move = possibleSize - 1;
            if (possibleSize > ans
              && leftDown[i + move][j + move] >= possibleSize
              && rightDown[i + move][j - move] >= possibleSize) {
              ans = possibleSize;
            }
          }
        }
      }
    }
    System.out.print(ans);
  }
}
