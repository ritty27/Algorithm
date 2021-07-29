import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, ans;
    static int[] stair, max;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stair = new int[N+2];
        max = new int[N+2];

        for (int i = 0; i < N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        ans = func(N);
        System.out.println(ans);

    }

    static int func(int num) {
        max[0] = stair[0];
        max[1] = stair[1] + stair[0];
        max[2] = Math.max(stair[0], stair[1]) + stair[2];

        for (int i = 3; i < N; i++) {
            max[i] = Math.max(max[i - 3] + stair[i - 1], max[i - 2]) + stair[i];
        }
        return max[num-1];
    }

}

