import java.awt.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Queue<Point> qu = new LinkedList<Point>();

        Scanner sc = new Scanner(System.in);

        final int MAX_NUM = 99999999;

        int min = MAX_NUM;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};


        Point start = null;
        boolean[][] fVisited = new boolean[n][m];
        int[][] fDistance = new int[n][m];
        int[][] jDistance = new int[n][m];
        int[][] board = new int[n][m];


        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                char input = line.charAt(j);
                if (input == '#') {
                    board[i][j] = -1;
                } else if (input == 'F') {
                    qu.add(new Point(i, j));
                    fVisited[i][j] = true;
                    board[i][j] = -1;
                } else if (input == 'J') {
                    start = new Point(i, j);
                }
            }
        }

        while (!qu.isEmpty()) {
            Point p = qu.poll();
            for (int i = 0; i < 4; i++) {
                int curX = p.x + dx[i];
                int curY = p.y + dy[i];
                if (curX < 0 || curX >= n || curY < 0 || curY >= m) continue;
                if (fDistance[curX][curY] > 0 || board[curX][curY] != 0) continue;
                fDistance[curX][curY] = fDistance[p.x][p.y] + 1;
                fVisited[curX][curY] = true;
                qu.add(new Point(curX, curY));
            }
        }

        qu.add(start);
        while (!qu.isEmpty()) {
            Point p = qu.poll();
            for (int i = 0; i < 4; i++) {
                int curX = p.x + dx[i];
                int curY = p.y + dy[i];
                if (curX < 0 || curX >= n || curY < 0 || curY >= m) continue;
                if (jDistance[curX][curY] > 0 || board[curX][curY] != 0) continue;
                if (jDistance[p.x][p.y] + 1 >= fDistance[curX][curY] && fVisited[curX][curY] == true) continue;
                jDistance[curX][curY] = jDistance[p.x][p.y] + 1;

                qu.add(new Point(curX, curY));
            }
        }

        for (int i = 0; i < n; i++) {
            if (jDistance[i][0] != 0 && jDistance[i][0] < min)
                min = jDistance[i][0];
            if (jDistance[i][m - 1] != 0 && jDistance[i][m - 1] < min)
                min = jDistance[i][m - 1];
        }

        for (int i = 0; i < m; i++) {
            if (jDistance[0][i] != 0 && jDistance[0][i] < min)
                min = jDistance[0][i];
            if (jDistance[n - 1][i] != 0 && jDistance[n - 1][i] < min)
                min = jDistance[n - 1][i];

        }

        if (min == MAX_NUM) {
            if (start.x == 0 || start.x == n - 1 || start.y == 0 || start.y == m - 1) {
                System.out.println(1);
                return;
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        System.out.println(min + 1);
    }
}
