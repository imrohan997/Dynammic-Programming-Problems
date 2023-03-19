/**
 * 0-1 Knapsack with Bottom-up Approach
 */
public class Main {
    public static void main(String[] args) {
        int wt[] = {5, 1, 1};
        int val[] = {1, 2, 3};
        int W = 3;

        System.out.println(knapSack0_1(W, wt, val, wt.length));
    }

    public static int knapSack0_1(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];

        //Filling array with -1
        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < W + 1; ++j) {
                dp[i][j] = -1;
            }
        }
        return knapSack0_1BottomUp(W, wt, val, n, dp);
    }

    public static int knapSack0_1BottomUp(int W, int wt[], int val[], int n, int dp[][]) {

        //Setting 0 at i==0 || j==0
        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < W + 1; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < W + 1; ++j) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    private static int max(int val1, int val2) {
        if (val1 > val2) {
            return val1;
        } else {
            return val2;
        }
    }
}