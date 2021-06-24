import java.awt.*;
import java.util.*;

public class Main {

    static int[] min = new int[150001];
    static Queue<Integer> qu = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        if(n >= k){
            System.out.println(n-k);
            return;
        }

        qu.add(n);
        while (!qu.isEmpty()) {
            int curN = qu.poll();
            int compareN;


            compareN = curN + 1;
            compare(curN, compareN);
            compareN = curN -1;
            compare(curN, compareN);
            compareN = curN * 2;
            compare(curN, compareN);
        }

        System.out.println(min[k]);

    }

    static public void compare(int curN, int compareN) {
        if (compareN >= 150001 || compareN <= 0)
            return;
        if (min[compareN] == 0) {
            min[compareN] = min[curN] + 1;
            qu.add(compareN);
            return;
        }
    }
}
