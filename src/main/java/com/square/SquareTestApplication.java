package com.square;


import com.square.model.TreeNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static com.square.dao.CategoryDao.createCategories;
import static com.square.dao.CategoryDao.root;
import static com.square.service.CategoryService.*;

@SpringBootApplication
public class SquareTestApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SquareTestApplication.class, args);
        //Create categories
        createCategories();

        // Test case
        String categoryName = "Lawn & Garden";
        List<String> categoryKeywords = getKeywordsForCategory(categoryName);
        int categoryLevel = getCategoryLevel(categoryName);

        System.out.println("Category: " + categoryName);
        System.out.println("Keywords: " + categoryKeywords);
        System.out.println("Level: " + categoryLevel);
        System.out.println();

        // Find categories by keyword
        String keyword = "Kitchen";
        List<TreeNode> categoriesWithKeyword = searchCategoriesByKeyword(root, keyword);

        // Print the categories that have the keyword
        for (TreeNode category : categoriesWithKeyword) {
            System.out.println("Category: " + category.getName());
        }
    }
}
