import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class People {
  int seq;
  int height;

  public People(int seq, int height) {
    this.seq = seq;
    this.height = height;
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int countPeople = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    int[] ans = new int[countPeople];
    Stack<People> stack = new Stack<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < countPeople; i++) {
      int height = Integer.parseInt(st.nextToken());
      People now = new People(i, height);

      while (!stack.isEmpty()) {
        if (stack.peek().height < now.height) {
          People temp = stack.pop();
          ans[temp.seq] = now.height;
        } else break;
      }

      stack.add(now);
    }

    for (int i = 0; i < countPeople; i++) {
      if(ans[i] == 0) sb.append("-1 ");
      else sb.append(ans[i] + " ");
    }

    System.out.print(sb);
  }


}

