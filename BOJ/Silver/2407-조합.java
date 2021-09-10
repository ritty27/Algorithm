import java.io.*;
import java.math.BigInteger;

public class Main {

    static BigInteger[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        BigInteger ans = BigInteger.valueOf(1);
        dp = new BigInteger[n + 2][n + 2];


        ans = combination(n, m);
        System.out.print(ans);

    }

    private static BigInteger combination(int x, int y) {
        if (dp[x][y] != null) {
            return dp[x][y];
        } else if (y == 0 || y == x) {
            dp[x][y] = BigInteger.valueOf(1);
            return dp[x][y];
        } else {

            dp[x][y] = combination(x - 1, y - 1).add(combination(x - 1, y));
            return dp[x][y];
        }
    }
}
