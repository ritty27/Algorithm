import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static StringBuilder sb = new StringBuilder();
    public static Character[][] img;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        img = new Character[n][2 * n - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(img[i], ' ');
        }

        draw(0, n - 1, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                sb.append(img[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void draw(int y, int x, int size) {
        if (size == 3) {
            img[y][x] = '*';
            img[y + 1][x - 1] = img[y + 1][x + 1] = '*';
            img[y + 2][x - 2] = img[y + 2][x - 1] = img[y + 2][x] = img[y + 2][x + 1] = img[y + 2][x + 2] = '*';
        } else {
            int newSize = size / 2;
            draw(y, x, newSize);
            draw(y + newSize, x - newSize, newSize);
            draw(y + newSize, x + newSize, newSize);
        }


    }
}
