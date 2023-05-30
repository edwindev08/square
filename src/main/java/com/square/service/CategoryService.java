package com.square.service;

import com.square.model.TreeNode;
import java.util.List;

public interface CategoryService {

    public List<String> getKeywordsForCategory(String categoryName);

    public int getCategoryLevel(String categoryName);

    public int calculateCategoryLevel(TreeNode node, int level);

}
