
public class KthLargestElement {

	public static int findKthLargest(int[] nums, int k) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int i1 = 0; i1 < nums.length - 1 - i ; i1++) {
				if (nums[i1] < nums[i1 + 1]){
					int tmp = nums[i1];
					nums[i1] = nums[i1 + 1];
					nums[i1 + 1] = tmp;
				}
			}
		}
		return nums[k - 1];
	}
}
