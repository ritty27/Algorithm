import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        if (n == 1) {
            System.out.println(0);
            System.out.print(1 + " ");
            return;
        }

        int[] arr = new int[n + 2];
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i <= n; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 2 == 0) arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            if (i % 3 == 0) arr[i] = Math.min(arr[i], arr[i / 3] + 1);
        }
        sb.append(arr[n] + "\n");


        while (n>1){
            sb.append(n+ " ");
            if (n % 2 == 0 && arr[n] == arr[n/2] + 1) {
                n /= 2;
                continue;
            }
            if (n % 3 == 0&& arr[n]-1 == arr[n/3]) {
                n /= 3;
                continue;
            }
            if (arr[n]-1 == arr[n-1]) {
                n -= 1;
                continue;
            }
        }
        sb.append(1);

        System.out.print(sb);

    }
}
