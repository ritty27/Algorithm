import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String sentence = br.readLine();

    int nowPipe = 0;
    char before = '(';

    int ans = 0;

    for (int i = 1; i < sentence.length(); i++) {
      char now = sentence.charAt(i);
      if (before == '(' && now == ')') {
        ans += nowPipe;
        before = ')';
      } else if (before == '(' && now == '(') {
        nowPipe++;
        ans++;
        before = '(';
      }
      else if (before == ')' && now == ')') {
        nowPipe--;
        before = ')';
      } else before = now;
    }
    System.out.print(ans);
  }

}

