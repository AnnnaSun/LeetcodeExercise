//package EverydayTest;
//
//import javax.swing.tree.TreeNode;
//
///**
// * Definition for a binary tree node.
// *给定两个非空二叉树 s 和 t，检验s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
// *
// */
//
//public class IsSubTreeNode {
//
//    private boolean isEqual(LTreeNode l, LTreeNode r){
//        if(l == null && r == null) return true;//两树均空自然相等
//        if(l == null || r == null) return false;//一空一非空，自然不等
//        if(l.val == r.val)//递归判断
//            return isEqual(l.left,r.left) && isEqual(l.right,r.right);
//        return false;
//    }
//
//    /**
//     * 判断 t 树是否是 s 树的子树
//     * @param s
//     * @param t
//     * @return
//     */
//    public boolean isSubtree(LTreeNode s, LTreeNode t) {
//        if(s == null && t == null)
//            return true;
//        if(s == null || t == null) return false;
//        if(s.val == t.val){
//            return isEqual(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t);
//        }
//        // 根节点不同，那么就不同考虑s和t相等的情形了
//        return isSubtree(s.left, t) || isSubtree(s.right, t);
//    }
//}
