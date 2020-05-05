package EverydayTest;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树(BST)。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class binaryTreeDemo {

    public boolean helper(LTreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST(LTreeNode root) {
        return helper(root, null, null);
    }
}
//leetcode官方定义的treenode
class LTreeNode{
    int val;
    LTreeNode left;
    LTreeNode right;
    LTreeNode(int x){val = x;}
}
