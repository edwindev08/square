package com.square.service;

import com.square.model.TreeNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.square.dao.CategoryDao.root;

@Service
public class CategoryService {

    public static List<String> getKeywordsForCategory(String categoryName) {
        TreeNode categoryNode = findCategoryByName(root, categoryName);
        return collectKeywords(categoryNode);
    }

    public static int getCategoryLevel(String categoryName) {
        TreeNode categoryNode = findCategoryByName(root, categoryName);
        return calculateCategoryLevel(categoryNode, 0);
    }

    private static TreeNode findCategoryByName(TreeNode node, String categoryName) {
        if (node.getName().equals(categoryName)) {
            return node;
        }

        for (TreeNode child : node.getChildren()) {
            TreeNode foundNode = findCategoryByName(child, categoryName);
            if (foundNode != null) {
                return foundNode;
            }
        }

        return null;
    }

    private static List<String> collectKeywords(TreeNode node) {
        List<String> keywords = new ArrayList<>(node.getKeywords());

        if (keywords.isEmpty()) {
            TreeNode parentNode = findParentCategory(node);
            if (parentNode != null) {
                keywords.addAll(collectKeywords(parentNode));
            }
        }

        return keywords;
    }

    private static TreeNode findParentCategory(TreeNode node) {
        // Find the parent category of the given node
        for (TreeNode child : root.getChildren()) {
            TreeNode parent = findParentCategory(child, node);
            if (parent != null) {
                return parent;
            }
        }

        return null;
    }

    private static TreeNode findParentCategory(TreeNode current, TreeNode target) {
        if (current == target) {
            return null; // Found the target node, so no parent category
        }

        for (TreeNode child : current.getChildren()) {
            if (child == target) {
                return current;
            }

            TreeNode parent = findParentCategory(child, target);
            if (parent != null) {
                return parent;
            }
        }

        return null;
    }

    public static int calculateCategoryLevel(TreeNode node, int level) {
        if (node == null) {
            return -1; // Category not found in the hierarchy
        }

        if (node == root) {
            return level;
        }

        TreeNode parent = findParentCategory(root, node);
        if (parent != null) {
            return calculateCategoryLevel(parent, level + 1);
        }

        return -1; // Category not found in the hierarchy
    }

    public static List<TreeNode> searchCategoriesByKeyword(TreeNode node, String keyword) {
        List<TreeNode> result = new ArrayList<>();

        if (node.getKeywords().contains(keyword)) {
            result.add(node);
        }

        for (TreeNode child : node.getChildren()) {
            List<TreeNode> childResult = searchCategoriesByKeyword(child, keyword);
            result.addAll(childResult);
        }

        return result;
    }

}
