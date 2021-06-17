import java.awt.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Queue<Point> qu = new LinkedList<Point>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] distance = new int[n][m];
        boolean[][] board = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                int input = line.charAt(j) -'0';
                board[i][j] = (input != 0);
            }
        }

        qu.add(new Point(0, 0));
        distance[0][0] =1;
        while (!qu.isEmpty()) {
            Point p = qu.poll();
            for (int i = 0; i < 4; i++) {
                int curX = p.x + dx[i];
                int curY = p.y + dy[i];
                if(curX < 0 || curX >= n || curY <0 || curY >=m) continue;
                if(distance[curX][curY] > 0 || board[curX][curY] != true) continue;
                distance[curX][curY] = distance[p.x][p.y] +1;
                qu.add(new Point(curX,curY));
            }

        }

        System.out.println(distance[n-1][m-1]);

    }
}
