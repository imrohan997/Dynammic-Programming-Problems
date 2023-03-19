/**
 * Program for 0-1 Knapsack with memoization.
 */
public class Main {
    public static void main(String[] args) {
        int wt[] = {4,5,6};
        int val[] = {1,2,3};
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

        return knapSack0_1(W, wt, val, n, dp);
    }

    public static int knapSack0_1(int W, int wt[], int val[], int n, int dp[][]) {

        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            dp[n][W] = max(val[n - 1] + knapSack0_1(W - wt[n - 1], wt, val, n - 1, dp),
                    knapSack0_1(W, wt, val, n - 1, dp));
            return dp[n][W];
        } else {
            dp[n][W] = knapSack0_1(W, wt, val, n - 1, dp);
            return dp[n][W];
        }
    }

    private static int max(int val1, int val2) {
        if (val1 > val2) {
            return val1;
        } else {
            return val2;
        }
    }
}