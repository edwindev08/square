public class Main {

    public static void main(String[] args) {

        // Creating a TreeNode with the sample categories
        TreeNode root = new TreeNode("Home Appliances");
        root.left = new TreeNode("Major Appliances");
        root.right = new TreeNode("Minor Appliances");
        root.left.left = new TreeNode("Kitchen Appliances");
        root.left.right = new TreeNode("General Appliances");



        LevelOfCategories.getLevelOfCategory(root);

        TreeNode rootNull = new TreeNode(null);
        //Testing when the root is equals to null must return null and the level 0
        LevelOfCategories.getLevelOfCategory(rootNull);

        //Testing the search of categories by value and node
        TreeNode result = FindCategories.findCategory("Home Appliances",root);
        System.out.println("result = " + result.val);
        


    }

}