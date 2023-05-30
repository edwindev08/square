package com.square.dao;

import com.square.model.TreeNode;

public class CategoryDao {

    public static TreeNode root;

    private static void createCategories() {
        // Create root category
        root = new TreeNode("Home Appliances");
        root.addKeyword("HomeAppliance");
        root.addKeyword("Appliance");

        // Create subcategories
        TreeNode majorAppliances = new TreeNode("Major Appliances");
        majorAppliances.addKeyword("MajorAppliance");
        majorAppliances.addKeyword("Appliance");
        TreeNode minorAppliances = new TreeNode("Minor Appliances");
        minorAppliances.addKeyword("MinorAppliance");
        minorAppliances.addKeyword("Appliance");
        TreeNode kitchenAppliances = new TreeNode("Kitchen Appliances");
        kitchenAppliances.addKeyword("KitchenAppliance");
        kitchenAppliances.addKeyword("Appliance");
        TreeNode generalAppliances = new TreeNode("General Appliances");
        generalAppliances.addKeyword("GeneralAppliance");
        generalAppliances.addKeyword("Appliance");
        TreeNode lawnAndGarden = new TreeNode("Lawn & Garden");
        lawnAndGarden.addKeyword("Lawn");
        lawnAndGarden.addKeyword("Garden");
        lawnAndGarden.addKeyword("GardeningTools");

        // Build category hierarchy
        root.addChild(majorAppliances);
        root.addChild(minorAppliances);
        majorAppliances.addChild(kitchenAppliances);
        majorAppliances.addChild(generalAppliances);
        minorAppliances.addChild(lawnAndGarden);
    }

}
