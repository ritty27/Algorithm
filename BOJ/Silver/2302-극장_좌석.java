import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = new ArrayList<>();
        int max=0,ans = 1;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int cur = 1;
        for (int i = 0; i < M; i++) {
            arr.add(Integer.parseInt(br.readLine()) - cur);
            cur = arr.get(i) + cur + 1;
        }
        arr.add(N-cur + 1);

        max = Collections.max(arr);
        int[] fib = new int[max + 2];

        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= max; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        for (int i = 0; i < arr.size(); i++) {
            ans *= fib[arr.get(i)];
        }

        System.out.println(ans);
    }

 }
