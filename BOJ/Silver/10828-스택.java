import java.io.*;
import java.util.*;


public class Main {


  public static void main(String[] args) throws IOException {

    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    Stack<String> stack = new Stack<>();

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String temp = st.nextToken();
      if (temp.equals("push")) {
        stack.push(st.nextToken());
      } else if (temp.equals("top")) {
        if (stack.isEmpty()) sb.append("-1" + "\n");
        else sb.append(stack.peek() + "\n");
      } else if (temp.equals("pop")) {
        if (stack.isEmpty()) sb.append("-1" + "\n");
        else sb.append(stack.pop() + "\n");
      } else if (temp.equals("size")) {
        sb.append(stack.size() + "\n");
      } else if (temp.equals("empty")) {
        if (stack.isEmpty()) sb.append("1" + "\n");
        else sb.append("0" + "\n");
      }
    }

    System.out.print(sb);
  }

}


