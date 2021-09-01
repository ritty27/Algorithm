import java.io.*;
import java.util.Arrays;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] tmp;
    static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        tmp = new int[M];


        dfs(1, 0);

        System.out.print(sb);

    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(tmp[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            tmp[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
