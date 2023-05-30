package com.square.model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String name;
    private List<String> keywords;
    private List<TreeNode> children;

    public TreeNode(String name) {
        this.name = name;
        this.keywords = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addKeyword(String keyword) {
        keywords.add(keyword);
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public List<TreeNode> getChildren() {
        return children;
    }
}
