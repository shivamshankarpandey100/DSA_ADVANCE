//https://www.geeksforgeeks.org/problems/construct-tree-1/1

class Solution {
    static int preIndex = 0;
    
    public static Node buildTree(int inorder[], int preorder[]) {
        preIndex = 0; // Reset preIndex for each test case
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return constructTree(preorder, inorderMap, 0, inorder.length - 1);
    }
    
    private static Node constructTree(int[] preorder, Map<Integer, Integer> inorderMap, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        
        int rootValue = preorder[preIndex++];
        Node root = new Node(rootValue);
        
        int inIndex = inorderMap.get(rootValue);
        
        root.left = constructTree(preorder, inorderMap, inStart, inIndex - 1);
        root.right = constructTree(preorder, inorderMap, inIndex + 1, inEnd);
        
        return root;
    }
}
