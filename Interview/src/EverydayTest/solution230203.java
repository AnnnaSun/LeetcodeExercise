package src.EverydayTest;

 class TreeNode {
      int val;
      treeNode left;
      treeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, treeNode left, treeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class solution230203 {
    //x 是第一玩家的起点， n是节点数
    private int x, lsz, rsz;//lsz是左子树大小，rsz是右子树大小

    public boolean btreeGameWinningMove(treeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        return Math.max(Math.max(lsz, rsz), n - 1 - lsz - rsz) * 2 > n;
        //取左子树和右子树相对较大的，和父节点处大小比较
        // n2=max(lsz,rsz,n−1−lsz−rsz),n2>n-n2=>2n2>n
    }

    private int dfs(treeNode node) {
        if (node == null)
            return 0;
        int ls = dfs(node.left);
        int rs = dfs(node.right);
        if (node.val == x) {
            lsz = ls;
            rsz = rs;
        }
        return ls + rs + 1;
    }

}
