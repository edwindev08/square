public class FindCategories {
    public static TreeNode findCategory(String val, TreeNode node) {
        TreeNode result = null;
        if (node.val.equals(val)){
            result = node;
        }
        return result;
    }
}
