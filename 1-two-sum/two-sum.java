class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int[] ans=new int[2];
        int[] copy=new int[nums.length];
        int len=0;
        for(int m : nums)
        {
            copy[len]=m;
            len++;
        }

        Arrays.sort(nums);
        while(i<j)
        {
            if(nums[i]+nums[j]==target)
            {
                int check=0;
                for(int k=0; k<copy.length; k++)
                {
                    if(copy[k]==nums[i] && check ==0)
                    {
                        ans[0]=k;
                        check=1;
                    }    
                    else if(copy[k]==nums[j])
                        ans[1]=k;
                }
                return ans;
            }
            else if(nums[i]+nums[j]<target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return ans;
    }
}