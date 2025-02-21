//https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

class FindElements {
    private Set<Integer> present = new HashSet<>();
    
    private void dfs(TreeNode root, int parentVal, boolean left) {
        if (root == null) return;
        
        root.val = left ? (2 * parentVal + 1) : (2 * parentVal + 2);
        present.add(root.val);
        
        dfs(root.left, root.val, true);
        dfs(root.right, root.val, false);
    }
    
    public FindElements(TreeNode root) {
        root.val = 0;
        present.add(0);
        dfs(root.left, 0, true);
        dfs(root.right, 0, false);
    }
    
    public boolean find(int target) {
        return present.contains(target);
    }
}