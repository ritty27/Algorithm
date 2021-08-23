import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        int ans = 0;
        for (int i = 1; i <= N; i++) {
        String[] input = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                   if(Integer.parseInt(input[j-1]) == 1) {
                       map[i][j] = Math.min(map[i][j-1] , map[i-1][j]);
                       map[i][j] = Math.min(map[i][j] , map[i-1][j-1]) + 1;
                       ans = Math.max(ans, map[i][j]);
                   }

            }
        }
        System.out.println(ans * ans);
    }
}
