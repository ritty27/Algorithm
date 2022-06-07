import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Floor {
  int height;
  int count;

  Floor(int height, int count) {
    this.height = height;
    this.count = count;
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String readLine = br.readLine();

    StringTokenizer st = new StringTokenizer(readLine);

    int floor = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());
    int goal = Integer.parseInt(st.nextToken());
    int up = Integer.parseInt(st.nextToken());
    int down = Integer.parseInt(st.nextToken());

    Queue<Floor> queue = new LinkedList<>();
    int[] ans = new int[floor + 2];

    queue.add(new Floor(start, 0));

    while (!queue.isEmpty()) {
      Floor now = queue.poll();
      if (now.height == goal) {
        System.out.print(now.count);
        return;
      }

      if (now.height + up <= floor && ans[now.height + up] == 0) {
        ans[now.height + up] = now.count + 1;
        queue.add(new Floor(now.height + up, now.count + 1));
      }

      if (now.height - down >= 1 && ans[now.height - down] == 0){
        ans[now.height - down] = now.count + 1;
        queue.add(new Floor(now.height - down, now.count + 1));
      }

    }

    System.out.print("use the stairs");
  }

}
