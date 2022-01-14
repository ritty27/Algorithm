import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int num = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    int top = 0;

    for (int i = 0; i < num; i++) {
      int target = Integer.parseInt(br.readLine());

      if (top < target) {
        for (int j = top + 1; j <= target; j++) {
          sb.append("+").append("\n");
          stack.push(j);
        }
        top = target;
      } else if (stack.peek() != target) {
        System.out.println("NO");
        return;
      }
      stack.pop();
      sb.append("-").append("\n");
    }


    System.out.print(sb);
  }
}
