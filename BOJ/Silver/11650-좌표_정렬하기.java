import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Main {

  static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;

    List<Point> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));


    }
    Collections.sort(list, new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        if(o1.x == o2.x) return o1.y - o2.y;
        return o1.x - o2.x;
      }
    });

    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i).x + " " + list.get(i).y + "\n");
    }

    System.out.print(sb);
  }


}


