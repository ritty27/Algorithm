import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            int[][] max = new int[N][2];

            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[j][0] = Integer.parseInt(str[j]);
            }
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[j][1] = Integer.parseInt(str[j]);
            }

            if (N == 1) {
                sb.append(Math.max(arr[0][0], arr[0][1])).append("\n");
            } else {
                max[0][0] = arr[0][0];
                max[0][1] = arr[0][1];
                max[1][0] = arr[0][1] + arr[1][0];
                max[1][1] = arr[0][0] + arr[1][1];
                for (int j = 2; j < N; j++) {
                    int tmp = Math.max(max[j - 2][0], max[j - 2][1]);
                    max[j][0] = Math.max(max[j - 1][1], tmp) + arr[j][0];
                    max[j][1] = Math.max(max[j - 1][0], tmp) + arr[j][1];
                }

                sb.append(Math.max(max[N - 1][0], max[N - 1][1])).append("\n");
            }
        }

        System.out.print(sb);
    }

}
