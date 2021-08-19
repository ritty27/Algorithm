import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        String[] tmp = br.readLine().split(" ");
        arr[0] = Integer.parseInt(tmp[0]);
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(tmp[i]) + arr[i - 1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 2;
            int end = Integer.parseInt(st.nextToken()) - 1;

            if (start < 0) sb.append(arr[end] + "\n");
            else sb.append(arr[end] - arr[start] + "\n");
        }

        System.out.println(sb);


    }
}
