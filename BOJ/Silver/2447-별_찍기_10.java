import java.io.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static boolean[][] img;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        img = new boolean[n][n];

        draw(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img[i][j]) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    public static void draw(int x, int y, int size) {
        if (size == 1) {
            img[x][y] = true;
            return;
        }
        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                } else {
                    draw(x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }
}


