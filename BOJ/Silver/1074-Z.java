import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int r = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        sb.append(draw(n,r,c));
        System.out.println(sb);
    }

    public static int draw(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        int half = (int) Math.pow(2, n - 1);
        if (half <= r) {
            if (half <= c) {
                return 3 * half * half + draw(n - 1, r - half, c - half);
            } else {
                return 2 * half * half + draw(n - 1, r - half, c);
            }
        } else {
            if (half <= c) {
                return half * half + draw(n - 1, r, c - half);
            } else {
                return draw(n - 1, r, c);
            }
        }

    }
}
