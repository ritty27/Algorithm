import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static char[] arr;
    public static int l, c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        l = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);
        arr = new char[c];

        str = br.readLine().split(" ");
        Arrays.sort(str);
        for (int i = 0; i < c; i++) {
            arr[i] = str[i].charAt(0);
        }

        func(0, "");

        System.out.println(sb);
    }

    static void func(int at, String str) {
        if (str.length() == l) {
            if (isAvailable(str)) {
                sb.append(str).append("\n");
            }
            return;
        }
        if(at == c)
            return;

        func(at + 1, str + arr[at]);
        func(at + 1, str);
    }

    static boolean isAvailable(String str) {
        int vowel = 0;
        for (int i = 0; i < l; i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                vowel += 1;
            }
        }
        if (vowel >= 1 && l - vowel >= 2)
            return true;
        return false;
    }
}

