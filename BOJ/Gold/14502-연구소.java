import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, copied;
    static int N, M, count, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        setWall(0, 0, 0);
        System.out.print(max);
    }

    private static void setWall(int x, int y, int depth) {
        if (depth == 3) {
            copyMap();

            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 2) {
                        spreadVirus(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    getSafe(i, j);
                }
            }

            max = Math.max(count, max);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    setWall(i, j, depth + 1);
                    map[i][j] = 0;
                }
            }
        }


    }

    private static void copyMap() {
        copied = new int[N][M];
        for (int i = 0; i < N; i++) {
            copied[i] = Arrays.copyOf(map[i], map[i].length);
        }
    }

    private static void spreadVirus(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];


            if (!checkValue(curX, curY)) continue;

            if (copied[curX][curY] == 0) {
                copied[curX][curY] = 2;
                spreadVirus(curX, curY);
            }
        }
    }

    private static void getSafe(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (!checkValue(curX, curY)) continue;

            if (copied[curX][curY] == 0) {
                copied[curX][curY] = 1;
                getSafe(curX, curY);
                count++;
            }
        }
    }


    private static boolean checkValue(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }


}
