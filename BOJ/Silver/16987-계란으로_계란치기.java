import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, ans=0;
    static int[] S, W;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        W = new int[N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            S[i] = Integer.parseInt(str[0]);
            W[i] = Integer.parseInt(str[1]);
        }
        func(0);
        
        System.out.println(ans);


    }

    public static void func(int now) {
        if (now == N) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (S[i] <= 0) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
            return;
        }

        if(S[now] <= 0){
            func(now+1);
        }else {
            boolean callFunc = false;
            for (int i = 0; i <N ; i++) {
                if(S[i] <=0 || i==now) continue;
                callFunc=true;
                S[i]-=W[now];
                S[now]-=W[i];
                func(now+1);
                S[i]+=W[now];
                S[now]+=W[i];
            }
            if(callFunc==false)func(now+1);
        }
    }


}

