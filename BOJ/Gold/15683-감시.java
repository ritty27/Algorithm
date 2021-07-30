import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, cctvCount, ans = 999999;
    static int[][] map, temp;
    static int[] cctv = new int[8];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (1 <= map[i][j] && map[i][j] < 6) {
                    cctv[cctvCount++] = i * M + j;
                }
            }
        }
//

        for (int i = 0; i < Math.pow(4, cctvCount); i++) {
            temp = deepCopy(map);
            int check = 0, cur = i;
            for (int num = 0; num < cctvCount; num++) {
                func(num, cur % 4);
                cur /= 4;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (temp[j][k] == 0) {
                        check++;
                    }
                }
            }
            ans = Math.min(check, ans);
        }

        System.out.println(ans);


    }

    static void func(int num, int dir) {
        int y = cctv[num] / M;
        int x = cctv[num] % M;
        int cctvKind = map[y][x];
        if (cctvKind == 1) {
            draw(y, x, dir);
        } else if (cctvKind == 2) {
            draw(y, x, dir);
            draw(y, x, dir + 2);
        } else if (cctvKind == 3) {
            draw(y, x, dir);
            draw(y, x, dir + 1);
        } else if (cctvKind == 4) {
            draw(y, x, dir);
            draw(y, x, dir + 1);
            draw(y, x, dir + 2);
        } else if (cctvKind == 5) {
            draw(y, x, dir);
            draw(y, x, dir + 1);
            draw(y, x, dir + 2);
            draw(y, x, dir + 3);
        }
    }

    static void draw(int y, int x, int dir) {
        dir %= 4;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int ny = y, nx = x;

        while (true) {
            ny = ny + dy[dir];
            nx = nx + dx[dir];
            if (ny < 0 || ny >= N || nx < 0 || nx >= M) return;
            if (temp[ny][nx] == 6) return;
            if (temp[ny][nx] == 0) {
                temp[ny][nx] = -1;
            }
        }
    }

    public static int[][] deepCopy(int[][] src) {
        if (src == null) return null;
        int[][] dest = new int[src.length][src[0].length];

        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, src[0].length);
        }
        return dest;
    }

}

