import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxIdx = 0, maxCnt = 1, cnt = 1;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr);


        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i - 1]) {
                cnt++;
            } else cnt = 1;

            if (cnt > maxCnt) {
                maxCnt = cnt;
                maxIdx = i;
            }
        }
        System.out.println(arr[maxIdx]);
    }
}
