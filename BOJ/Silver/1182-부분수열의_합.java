import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static int[] arr;
    public static int n, target, count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        target = Integer.parseInt(str[1]);
        arr = new int[n];

        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }


        func(0, 0);
        if (target == 0) count -= 1;
        System.out.println(count);

    }

    static void func(int at, int sum) {
        if (at == n) {
            if (sum == target)
                count += 1;
            return;
        }
        func(at + 1, sum + arr[at]);
        func(at + 1, sum);
    }
}

