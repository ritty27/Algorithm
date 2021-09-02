import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int N, count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    ans.add(count);
                }
            }
        }

        Collections.sort(ans);
        sb.append(ans.size()).append("\n");
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append("\n");
        }

        System.out.print(sb);

    }

    private static void dfs(int x, int y) {
        if (check(x, y)) {
            if (map[x][y] == 1) {
                map[x][y] = 0;
                count++;
                for (int i = 0; i < 4; i++) {
                    int nowX = x + dx[i];
                    int nowY = y + dy[i];
                    dfs(nowX, nowY);
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
