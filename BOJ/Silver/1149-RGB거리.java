import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans =10000001;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Math.min(arr[i-1][(j+1)%3], arr[i-1][(j+2)%3]) + arr[i][j];
            }
        }
        for (int num : arr[N-1]) {
            ans = Math.min(ans, num);
        }
        System.out.println(ans);

    }
}
