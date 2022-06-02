import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Stack<Character> stack = new Stack<>();

    String line = br.readLine();

    int ans = 0;
    int temp = 1;
    for (int i = 0; i < line.length(); i++) {
      char now = line.charAt(i);

      if (now == '(') {
        stack.push(now);
        temp *= 2;
      } else if (now == '[') {
        stack.push(now);
        temp *= 3;
      } else if (!stack.isEmpty() && now == ')') {
        if (stack.pop() != '(') {
          ans = 0;
          break;
        }
        if (line.charAt(i - 1) == '(') ans += temp;
        temp /= 2;
      } else if (!stack.isEmpty() && now == ']') {
        if (stack.pop() != '[') {
          ans = 0;
          break;
        }
        if (line.charAt(i - 1) == '[') ans += temp;
        temp /= 3;
      } else {
        ans = 0;
        break;
      }
    }

    if(stack.isEmpty()) System.out.print(ans);
    else System.out.print(0);
  }
}
