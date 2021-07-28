import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static boolean[][] map = new boolean[5][5];
    static int[] isPicked = new int[7];
    static int count;

    static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j) == 'S';
            }
        }
        func(0, 0);


        System.out.println(count);


    }

    public static void func(int at, int depth) {
        if (depth == 7) {
            isNeighbor();
            return;
        }
        if (at == 25) {
            return;
        }
        for (int i = at; i < 25; i++) {
            isPicked[depth] = i;
            func(i + 1, depth + 1);
        }


    }

    public static void isNeighbor() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] check = new boolean[5][5];
        boolean[][] visited = new boolean[5][5];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 1, s = 0;

        for (int i = 0; i < 7; i++) {
            check[isPicked[i] / 5][isPicked[i] % 5] = true;
            if (map[isPicked[i] / 5][isPicked[i] % 5]) s++;
        }
        q.add(new Pair(isPicked[0] / 5, isPicked[0] % 5));
        visited[isPicked[0] / 5][isPicked[0] % 5] = true;

        while (!q.isEmpty()) {
            Pair now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (!check[ny][nx] || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                q.add(new Pair(ny, nx));
                cnt++;

            }
        }

        if (cnt == 7 && s >= 4) {
            count++;
        }


    }
}

