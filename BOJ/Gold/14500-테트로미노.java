import java.io.*;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int N, M, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j,0,0);
                exception(i,j);
            }
        }

        System.out.println(max);

    }

    private static boolean isValid(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= M)
            return false;
        return true;
    }

    private static void dfs(int row, int col, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (isValid(nextRow, nextCol) && !visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, depth + 1, sum + map[nextRow][nextCol]);
                visited[nextRow][nextCol] = false;
            }
        }
    }

    private static void exception(int row, int col) {
        int wing = 4;
        int min = 1001;
        int sum = map[row][col];
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            if (wing < 3) return;

            if (!isValid(nextRow, nextCol)) {
                wing -= 1;
                continue;
            }
            min = Math.min(min, map[nextRow][nextCol]);
            sum += map[nextRow][nextCol];
        }
        if(wing == 4){
            sum -= min;
        }
        max = Math.max(max, sum);
    }

}
