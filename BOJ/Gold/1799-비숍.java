import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] res = new int[2]; // black = 0, white = 1
    public static int[][] arr;
    public static boolean[] upLeft;
    public static boolean[] upRight;
    public static int size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        arr = new int[size][size];
        upRight = new boolean[size * 2 - 1];
        upLeft = new boolean[size * 2 - 1];

        for (int i = 0; i < size; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                arr[i][j] = str[j].charAt(0) - '0';
            }
        }

        func(0, true, 0);
        func(1, false, 0);
        System.out.println(res[0] + res[1]);

    }

    static void func(int locate, boolean black, int count) {
        res[black ? 0 : 1] = Math.max(res[black ? 0 : 1], count);
        int y, x;
        for (int i = locate; i < size * size; i++) {
            y = i / size;
            x = i % size;

            if ((x + y) % 2 != (black ? 0 : 1) || upLeft[y - x + size - 1] || upRight[y + x] || arr[y][x] == 0)
                continue;

            upLeft[y - x + size - 1] = true;
            upRight[y + x] = true;
            func(i + 1, black, count + 1);
            upLeft[y - x + size - 1] = false;
            upRight[y + x] = false;
        }

    }

}

