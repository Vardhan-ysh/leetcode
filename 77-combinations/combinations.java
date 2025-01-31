class Solution {
    int[] selected;
    int max;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int num, int k) {
        max = k;
        n = num;
        selected = new int[n];
        solve(0, selected, 0);
        return ans;
    }

    void solve(int i, int[] selected, int count) {
        if(count > max) {
            return;
        }
        if(i == n) {
            if(count == max) {
                List<Integer> next = new ArrayList<>();
                for(int j = 0; j < n; j++) {
                    if(selected[j] == 1) {
                        next.add(j + 1);
                    }
                }
                ans.add(next);
            }
            return;
        }

        selected[i] = 1;
        solve(i + 1, selected, count + 1);

        selected[i] = 0;
        solve(i + 1, selected, count);
    }
}