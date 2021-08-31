import java.io.*;
import java.util.Arrays;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] tmp;
    static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        arr = new int[N];
        tmp = new int[M];
        str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);

        dfs(0, 0);

        System.out.print(sb);

    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            if (check()) {

                for (int i = 0; i < M; i++) {
                    sb.append(tmp[i] + " ");
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = start; i < N; i++) {
            tmp[depth] = arr[i];
            dfs(start + 1, depth + 1);
        }
    }

    private static boolean check(){
        for (int i = 0; i < M -1; i++) {
            if(tmp[i] >= tmp[i+1]) return false;
        }
        return true;
    }

}
