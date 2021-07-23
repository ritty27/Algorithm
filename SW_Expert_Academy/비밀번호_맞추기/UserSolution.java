import java.util.function.IntBinaryOperator;
import java.util.function.ToIntBiFunction;

class UserSolution {
    public final static int N = 4;
    private static Solution.Result result;
    private static boolean check = false;

    public void doUserImplementation(int guess[]) {
        int valid_Num[] = new int[N];

        checkNum(guess);

        for (int i = 0; i < N; i++) {
            valid_Num[i] = guess[i];
        }

        int tmp[] = new int[N];
        boolean visited[] = new boolean[N];
        perm(valid_Num, guess, tmp, visited, 0, N, N);
        check=false;


    }

    private void checkNum(int guess[]) {
        for (int i = 0; i < N; i++) {
            guess[i] = i;
        }
        while (true) {
            for (int i = 0; i < 10; i++) {
                guess[0] = i;
                for (int j = i + 1; j < 10; j++) {
                    guess[1] = j;
                    for (int k = j + 1; k < 10; k++) {
                        guess[2] = k;
                        for (int l = k + 1; l < 10; l++) {
                            guess[3] = l;
                            result = Solution.query(guess);
                            if (result.hit + result.miss == N) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }


    static void perm(int valid_Num[], int guess[], int tmp[], boolean visited[], int depth, int n, int r) {

        if (depth == r) {
            if (result.hit != N) {
                result = Solution.query(tmp);
            }
            if (result.hit == N && !check) {
                for (int i = 0; i < N; i++) {
                    guess[i] = tmp[i];
                }
                check=true;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                tmp[depth] = valid_Num[i];
                perm(valid_Num, guess, tmp, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}