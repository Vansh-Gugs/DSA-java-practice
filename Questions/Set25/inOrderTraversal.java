import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return result;
        }
        result = inorderTraversal(root.left);
        result.add(root.val);
        result = inorderTraversal(root.right);
        return result;
    }
}

public class inOrderTraversal {
    public static void main(String[] args) {

        Solution sol = new Solution();

        /*
                1
                 \
                  2
                 /
                3
        */

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = sol.inorderTraversal(root);

        System.out.println("Inorder Traversal:");
        System.out.println(result);
    }
}
