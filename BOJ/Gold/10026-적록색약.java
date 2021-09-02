import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int[][] visited;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new int[N][N];

        //입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
                map[i] = str.toCharArray();
        }

        //일반인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    ans++;
                    dfs(i, j, map[i][j]);
                }
            }
        }
        sb.append(ans + " ");

        //족록색약
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }

        visited = new int[N][N];
        ans =0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    ans++;
                    dfs(i, j, map[i][j]);
                }
            }
        }

        sb.append(ans + " ");
        System.out.print(sb);

    }

    private static void dfs(int x, int y, char color) {
        if (check(x, y)) {
            if (map[x][y] == color && visited[x][y] == 0) {
                visited[x][y] = 1;
                for (int i = 0; i < 4; i++) {
                    int nowX = x + dx[i];
                    int nowY = y + dy[i];
                    dfs(nowX, nowY, color);
                }
            }
        }
    }


    private static boolean check(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }
        return true;
    }
}
