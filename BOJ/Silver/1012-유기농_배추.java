import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int ans = 0;
        for (int i = 0; i < K; i++) {
            String[] str = br.readLine().split(" ");
            map[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1){
                    DFS(i, j);
                    ans++;
                }
            }
        }

        sb.append(ans + "\n");
        }

        System.out.println(sb);
    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (curX < 0 || curX >= N || curY < 0 || curY >= M) continue;
            if (map[curX][curY] == 0) continue;

            map[curX][curY] = 0;
            DFS(curX, curY);
        }
    }

}
