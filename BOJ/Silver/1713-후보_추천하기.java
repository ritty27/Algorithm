import java.io.*;
import java.util.*;

class Person implements Comparable<Person> {
  int num;
  int count;
  int timeStamp;
  boolean isIn;

  public Person(int num, int count, int timeStamp, boolean isIn) {
    this.num = num;
    this.count = count;
    this.timeStamp = timeStamp;
    this.isIn = isIn;
  }

  @Override
  public int compareTo(Person o) {
    int compareNum = Integer.compare(count, o.count);
    if (compareNum == 0) {
      return Integer.compare(timeStamp, o.timeStamp);
    }
    return compareNum;
  }
}

public class Main {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    Person[] people = new Person[101];
    List<Person> list = new ArrayList<>();

    for (int k = 0; k < K; k++) {
      int num = Integer.parseInt(st.nextToken());
      if (people[num] == null) {
        people[num] = new Person(num, 0, 0, false);
      }

      if (people[num].isIn) {
        people[num].count++;
      } else {
        if (list.size() == N) {
          Collections.sort(list);
          Person p = list.remove(0);
          p.isIn = false;
        }
        people[num].count = 1;
        people[num].isIn = true;
        people[num].timeStamp = k;

        list.add(people[num]);
      }
    }

    Collections.sort(list, Comparator.comparingInt(o -> o.num));

    list.stream().forEach(person -> sb.append(person.num + " "));
    System.out.println(sb);

  }

}
