import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());

    int ans = 0;

    for (int i = 0; i < count; i++) {
      String sentence = br.readLine();
      Stack<Character> stack = new Stack<>();
      for (int j = 0; j < sentence.length(); j++) {
        if(!stack.isEmpty() && sentence.charAt(j) == stack.peek()){
          stack.pop();
        } else stack.push(sentence.charAt(j));
      }
      if(stack.isEmpty()) ans++;
    }

    System.out.print(ans);
  }
}

