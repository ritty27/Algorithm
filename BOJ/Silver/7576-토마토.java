import java.awt.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Queue<Point> qu = new LinkedList<Point>();

        Scanner sc = new Scanner(System.in);

        int max = 0;
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] distance = new int[n][m];
        int[][] board = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
//                System.out.println(board[i][j]);
                if (board[i][j] == 1) {
                    qu.add(new Point(i, j));
                    distance[i][j] = 0;
                }
            }

        }

        while (!qu.isEmpty()) {
            Point p = qu.poll();
            for (int i = 0; i < 4; i++) {
                int curX = p.x + dx[i];
                int curY = p.y + dy[i];
                if (curX < 0 || curX >= n || curY < 0 || curY >= m) continue;
                if (distance[curX][curY] > 0 || board[curX][curY] != 0) continue;
                distance[curX][curY] = distance[p.x][p.y] + 1;
//                    System.out.println("max는: " + max + "curX: " + curX+ "curY: " +curY);
                if (max < distance[curX][curY]) {
                    max = distance[curX][curY];
                }

                qu.add(new Point(curX, curY));
            }

        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && distance[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }

        }


        System.out.println(max);

    }
}
