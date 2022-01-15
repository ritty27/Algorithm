import java.io.*;
import java.util.*;


public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    long ans = 0;

    Stack<Integer> stack = new Stack<>();


    for (int i = 1; i <= num; i++) {
    int height = Integer.parseInt(br.readLine());

      while (!stack.isEmpty() && stack.peek() <= height){
        stack.pop();
      }

      ans += stack.size();
      stack.push(height);
    }


    System.out.print(ans);
  }
}
