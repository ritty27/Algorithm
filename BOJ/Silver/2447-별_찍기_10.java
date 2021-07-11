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
                if (img[i][j]){
                    sb.append("*");
                }else{
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    public static void draw(int x, int y, int size) {

        if (size == 3) {
            img[x][y] = true;
            img[x][y + 1] = true;
            img[x][y + 2] = true;

            img[x + 1][y] = true;
            img[x + 1][y + 2] = true;

            img[x + 2][y] = true;
            img[x + 2][y + 1] = true;
            img[x + 2][y + 2] = true;
            return;
        }
        int newSize = size / 3;

        draw(x, y, newSize);
        draw(x, y + newSize, newSize);
        draw(x, y + 2 * newSize, newSize);

        draw(x + newSize, y, newSize);
        draw(x + newSize, y + 2 * newSize, newSize);

        draw(x + 2 * newSize, y, newSize);
        draw(x + 2 * newSize, y + newSize, newSize);
        draw(x + 2 * newSize, y + 2 * newSize, newSize);
    }
}


