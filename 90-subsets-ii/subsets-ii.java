class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    int[] arr;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        arr = nums;
        Arrays.sort(arr);
        solve(0, new LinkedList<Integer>());
        return ans;
    }

    void solve(int i, List<Integer> curr) {
        if(i == arr.length) {
            ans.add(new LinkedList<Integer>(curr));
            return;
        }

        //select
        curr.add(arr[i]);
        solve(i + 1, curr);

        while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
            i++;
        }

        //not-select
        curr.remove(curr.size() - 1);
        solve(i + 1, curr);
    }
}