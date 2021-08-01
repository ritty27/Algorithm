import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int N, M, K, row, col, ans = 0;
    static int[][] map;
    static int[][] sticker;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);
        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            str = br.readLine().split(" ");
            row = Integer.parseInt(str[0]);
            col = Integer.parseInt(str[1]);
            sticker = new int[row][col];
            for (int j = 0; j < row; j++) {
                str = br.readLine().split(" ");
                for (int k = 0; k < col; k++) {
                    sticker[j][k] = Integer.parseInt(str[k]);
                }
            }
            attach();
        }
        //스티거 자리 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) ans++;
            }
        }
        System.out.println(ans);
    }
    //가능한 시작 위치인지 확인하여 check를 호출함
    static void attach() {
        int y, x;
        boolean check = false;
        for (int rotate = 0; rotate < 4; rotate++) {
            for (int i = 0; i < N * M; i++) {
                y = i / M;
                x = i % M;
                if (y + row - 1 >= N || x + col - 1 >= M) continue;
                check = check(y, x);
                if (check) {
                    return;
                }
            }
            rotation();
        }
    }
    //들어 갈 수 있는지 확인, 들어간다면 map에 넣어주고 리턴
    static boolean check(int y, int x) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[y + i][x + j] == 1 && sticker[i][j] == 1) return false;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (sticker[i][j] == 1) {
                    map[y + i][x + j] = 1;
                }
            }
        }
        return true;
    }
    //시계 방향 90도 회전
    static void rotation() {
        int[][] temp = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                temp[i][j] = sticker[row - 1 - j][i];
            }
        }
        int tmp = col;
        col = row;
        row = tmp;
        sticker = temp;
    }
}
