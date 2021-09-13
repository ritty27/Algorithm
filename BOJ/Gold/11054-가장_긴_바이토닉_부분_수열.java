import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    private static int[] map;
    private static int[] preCount;
    private static int[] postCount;
    private static int N;


    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        preCount = new int[N];
        postCount = new int[N];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(str[i]);
        }


        int ans = 0;
        for (int i = 0; i < N; i++) {
            preCheck(i);
            postCheck(N - i -1);
        }

        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, preCount[i] + postCount[i] +1);
        }

        System.out.print(ans);
    }

    private static void preCheck(int now){
        for (int i = 0; i < now; i++) {
            if(map[now] > map[i]) {
                preCount[now] = Math.max(preCount[now], preCount[i]+1);
            }
        }
    }

    private static void postCheck(int now){
        for (int i = N-1; i > now; i--) {
            if(map[now] > map[i]) {
                postCount[now] = Math.max(postCount[now], postCount[i]+1);
            }
        }
    }
}
