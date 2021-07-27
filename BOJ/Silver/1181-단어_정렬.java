import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static int size;
    public static String[] str;
    public static int[] temp = new int[6];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        str = new String[size];

        for (int i = 0; i < size; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str, new Comparator<String>() {

            @Override
            public int compare(String  s1, String s2) {
                if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }
                else {
                    return s1.length() - s2.length();
                }
            }
        });

        sb.append(str[0]).append("\n");
        for (int i = 1; i < size; i++) {
            if(!str[i].equals(str[i-1]))
            sb.append(str[i]).append("\n");
        }

        System.out.println(sb);
    }
}

