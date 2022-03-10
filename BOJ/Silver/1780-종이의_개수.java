import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int[] ans = new int[3];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int size = Integer.parseInt(br.readLine());
    map = new int[size][size];

    for (int i = 0; i < size; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < size; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    check(0, 0, size);
    for (int i = 0; i < 3; i++) {
      System.out.println(ans[i]);
    }
  }

  static void check(int y, int x, int size) {
    int temp = map[y][x];
    boolean check = true;

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (map[y + i][x + j] != temp) {
          check = false;
        }
      }
      if (!check) break;
    }
    if (check) {
      ans[temp + 1]++;
    } else {
      int fixSize = size / 3;
      check(y, x, fixSize);
      check(y, x + fixSize, fixSize);
      check(y, x + 2 * fixSize, fixSize);
      check(y + fixSize, x, fixSize);
      check(y + fixSize, x + fixSize, fixSize);
      check(y + fixSize, x + 2 * fixSize, fixSize);
      check(y + 2 * fixSize, x, fixSize);
      check(y + 2 * fixSize, x + fixSize, fixSize);
      check(y + 2 * fixSize, x + 2 * fixSize, fixSize);
    }
  }
}

