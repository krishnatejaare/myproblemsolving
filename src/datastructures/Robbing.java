package datastructures;

public class Robbing {
  public int rob(int[] nums) {
    int n = nums.length;
    if(n == 0) return 0;
    if(n < 2) return nums[0];
    int a= rob(nums, 0, n -2); // use first
    int b = rob(nums, 1, n -1);// use last
    return Math.max(a, b);
  }

  public int rob(int[] nums, int l, int r) {
    if(nums.length == 0) return 0;
    int notPick = 0, pick = nums[l];
    for(int i = l+1; i<= r; i++){
      int curPick = notPick + nums[i];
      int curNotPick = Math.max(notPick, pick);
      notPick = Math.max(pick, curNotPick);
      pick= curPick;
    }
    return Math.max(pick, notPick);
  }

  public static void main(String[]args){
    Robbing r = new Robbing();
    int[]arr={2,7,9,3,1};
    System.out.println(r.rob(arr));
  }
}
