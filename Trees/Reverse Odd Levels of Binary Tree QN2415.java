//https://leetcode.com/problems/reverse-odd-levels-of-binary-tree
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0; 
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode);
                
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            
            if (level % 2 == 1) {
                int left = 0, right = currentLevelNodes.size() - 1;
                while (left < right) {
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(right).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            
            level++;
        }
        
        return root;

    }
}
