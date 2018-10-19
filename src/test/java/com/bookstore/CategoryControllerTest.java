package com.bookstore;

import com.bookstore.controller.CategoryController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by ozlemcerensahin on 23.06.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { EcommerceApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryControllerTest {

    @Autowired
    CategoryController categoryController;

    @Test
    public void getCategoriesTest() {

        assertTrue("category size should match.",
                ((ArrayList) categoryController.getCategories()).size() == 24);

    }
    @Test
    public void getCategoriesByPageTest() {

        assertTrue("Category page 1 should match.",
                categoryController.getCategoriesByPage("1").size() == 20);
        assertTrue("Category page 2 should match.",
                categoryController.getCategoriesByPage("2").size() == 4);

    }
    @Test
    public void getCountTest() {

        assertTrue("category size should match.",
                (categoryController.getCount()) == 24);

    }
}
