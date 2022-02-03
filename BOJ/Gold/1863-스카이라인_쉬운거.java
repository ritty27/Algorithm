import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int ans = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      st.nextToken();
      int y = Integer.parseInt(st.nextToken());
      while (!stack.isEmpty() && stack.peek() > y){
        stack.pop();
        ans++;
      }
      if(!stack.isEmpty() && stack.peek() == y) continue;
      stack.push(y);
    }

    while (!stack.isEmpty()){
      if(stack.pop() != 0) ans++;
    }
    System.out.print(ans);
  }
}
