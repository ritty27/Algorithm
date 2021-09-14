import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {


    static int[][] map, visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, ans;


    static class Place {
        int x, y, distance;
        int clash;

        public Place(int x, int y, int distance, int clash) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.clash = clash;
        }
    }


    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                visited[i][j] = 9999;
            }
        }

        ans = bfs(0,0);

        System.out.print(ans);
    }

    private static int bfs(int x, int y) {
        Queue<Place> qu = new LinkedList<>();
        qu.add(new Place(x, y,1, 0));

        while (!qu.isEmpty()) {
            Place pl = qu.poll();
            if(pl.x == N-1 && pl.y == M-1){
                return pl.distance;
            }
            for (int i = 0; i < 4; i++) {
                int curX = pl.x + dx[i];
                int curY = pl.y + dy[i];

                if (!checkValid(curX, curY)) continue;
                if(visited[curX][curY] > pl.clash){
                    if(map[curX][curY] == 0){
                        qu.add(new Place(curX, curY, pl.distance +1, pl.clash));
                        visited[curX][curY] = pl.clash;
                    }else if(pl.clash == 0){
                        qu.add(new Place(curX, curY, pl.distance + 1,  pl.clash +1));
                        visited[curX][curY] = pl.clash + 1;
                    }
                }
            }

        }
        return -1;
    }


    private static boolean checkValid(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        return true;
    }
}
