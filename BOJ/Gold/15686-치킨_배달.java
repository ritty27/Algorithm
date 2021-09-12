import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    private static int[][] map;
    private static final ArrayList<Point> home = new ArrayList<>();
    private static final ArrayList<Point> chicken = new ArrayList<>();
    private static final ArrayList<Point> choose = new ArrayList<>();
    private static int N, M, ans = 99999999;

    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(str[j]);
                if (num == 2) {
                    chicken.add(new Point(i, j));
                } else if (num == 1) {
                    home.add(new Point(i, j));
                }
            }
        }

        distance(0, 0);
        System.out.println(ans);

    }

    private static void distance(int start, int count) {
        if (count == M) {
            int sum = 0;
            for (int i = 0; i < home.size(); i++) {
                int min = 999999999;
                for (int j = 0; j < M; j++) {
                    min = Math.min(min, (Math.abs(choose.get(j).x - home.get(i).x) + Math.abs(choose.get(j).y - home.get(i).y)));
                }
                sum += min;
            }
            ans = Math.min(ans, sum);
        } else if (start >= chicken.size()) {
            return;
        } else {
            distance(start + 1, count);
            choose.add(chicken.get(start));
            distance(start + 1, count + 1);
            choose.remove(choose.size() - 1);
        }
    }
}
