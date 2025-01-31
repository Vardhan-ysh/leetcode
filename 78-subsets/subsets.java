class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    int[] arr;
    public List<List<Integer>> subsets(int[] nums) {
        arr = nums;
        solve(0, new LinkedList<Integer>());
        return ans;
    }

    void solve(int i, List<Integer> curr) {
        if(i == arr.length) {
            ans.add(new LinkedList<>(curr));
            return;
        }

        //select
        curr.add(arr[i]);
        solve(i + 1, curr);

        //not-select
        curr.remove(curr.size() - 1);
        solve(i + 1, curr);
    }
}