
import java.io.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static boolean[][] img;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        img = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) - '0' == 1)
                    img[i][j] = true;
            }
        }
        tree(0, 0, n);

        System.out.println(sb);
    }


    public static void tree(int x, int y, int size) {
        if (divide(x, y, size)) {
            int printNum = (img[x][y]) ? 1 : 0;
            sb.append(printNum);
            return;
        }

        sb.append("(");
        int newSize = size / 2;
        tree(x, y, newSize);
        tree(x, y + newSize, newSize);
        tree(x + newSize, y, newSize);
        tree(x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    public static boolean divide(int x, int y, int size) {
        boolean vale = img[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (vale != img[i][j])
                    return false;
            }
        }
        return true;
    }
}


