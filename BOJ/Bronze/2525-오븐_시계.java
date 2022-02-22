import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int hour = Integer.parseInt(st.nextToken());
    int min = Integer.parseInt(st.nextToken());

    int requiredTime = Integer.parseInt(br.readLine());

    int myTimeStamp = 60 * hour + min + requiredTime;

    System.out.print(myTimeStamp / 60 % 24 + " " + myTimeStamp % 60);
  }

}

