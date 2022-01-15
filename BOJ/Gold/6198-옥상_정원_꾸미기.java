import java.io.*;
import java.util.*;

class Building {
  private int index;
  private int height;

  public Building(int index, int height) {
    this.index = index;
    this.height = height;
  }

  public int index() {
    return index;
  }

  public int height() {
    return height;
  }
}

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    long ans = 0;

    Stack<Building> stack = new Stack<>();

    int height = Integer.parseInt(br.readLine());
    stack.push(new Building(1, height));

    for (int i = 2; i <= num; i++) {
      height = Integer.parseInt(br.readLine());

      while (!stack.isEmpty() && stack.peek().height() <= height){
        ans += (i - stack.pop().index() - 1);
      }

      stack.push(new Building(i, height));
    }

    while (!stack.isEmpty()){
      ans += (num - stack.pop().index());
    }

    System.out.print(ans);
  }
}
