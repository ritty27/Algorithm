import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static int[] arr;
    public static boolean[] isUsed;
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        arr = new int[m];

        func(0, 0);

        System.out.println(sb);


    }

    static void func(int at, int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + 1).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = at; i < n; i++) {
            arr[k] = i;
            func(i + 1, k + 1);
        }
    }
}


