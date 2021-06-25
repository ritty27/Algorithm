import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        sb.append((int) Math.pow(2, n) - 1 + "\n");
        hanoi(1, 3, n);
        System.out.println(sb);
    }


    public static void hanoi(int a, int b, int n) {
        if (n == 1) {
            sb.append(a + " " + b + "\n");
            return;
        }
        hanoi(a, 6 - a - b, n - 1);
        sb.append(a + " " + b + "\n");
        hanoi(6 - a - b, b, n - 1);
    }
}
