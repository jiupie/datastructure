package jz.carl.tree;

/**
 * @author 南顾北衫
 * @date 2023/5/16
 */
public class _32_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length);
    }

    public TreeNode recursion(int[] nums, int left, int right) {
        if (right - left < 1) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }
        int mid = (right + left) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = recursion(nums, left, mid);
        treeNode.right = recursion(nums, mid + 1, right);
        return treeNode;
    }
}
