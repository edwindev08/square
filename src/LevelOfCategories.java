import java.util.LinkedList;
import java.util.Queue;

public class LevelOfCategories {

    public static void getLevelOfCategory(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) { // while the queue is not empty get the level of the nodes
            //Init the level of nodes with the queue size
            int nodesAtLevel = queue.size();

            for (int i = 0; i < nodesAtLevel; i++) {
                TreeNode node = queue.poll();
                System.out.println("Node: " + node.val + ", Level: " + level);

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            level++;
        }

    }

}
