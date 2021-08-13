import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] first, second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        first = new int[N];
        second = new int[M];

        str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            first[i] = Integer.parseInt(str[i]);
        }
        str = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            second[i] = Integer.parseInt(str[i]);
        }

        int n = 0, m = 0;
        for (int i = 0; i < N + M; i++) {
            if (n == N || m == M) break;
            if (first[n] <= second[m]) {
                sb.append(first[n++] + " ");
            } else sb.append(second[m++] + " ");
        }

        if (n == N) {
            for (int i = m; i < M; i++) {
                sb.append(second[i] + " ");
            }
        } else {
            for (int i = n; i < N; i++) {
                sb.append(first[i] + " ");
            }
        }


        System.out.println(sb);
    }

}
