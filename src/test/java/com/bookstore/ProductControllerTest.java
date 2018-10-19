package com.bookstore;

import com.bookstore.controller.ProductController;
import com.bookstore.dto.ProductResponseDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by ozlemcerensahin on 23.06.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { EcommerceApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    ProductController productController;


    @Autowired private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;


    @Test
    public void getProducts() {
        Assertions
                .assertThat(productController.getProducts())
                .hasSize(39);
    }

    @Test
    public void getProductsByCategory() {
        Assertions
                .assertThat(productController.getProductsByCategory(1L, 1))
                .hasSize(20);

    }

    @Test
    public void getProduct(){
        ResponseEntity<ProductResponseDTO> responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/product/1", HttpMethod.GET, null, new ParameterizedTypeReference<ProductResponseDTO>() {
        });
        ProductResponseDTO product = responseEntity.getBody();

        assertTrue("product author should match.", product.getAuthor().equals("Test Author")  );
        assertTrue("product id should match.", product.getId() == 1L  );
        assertTrue("product categoryId should match.", product.getCategoryId() == 1L );
        assertTrue("product description should match.", product.getDescription().equals("Both survivors of the divorce wars, Christy and Martin don't believe in love at first sight and certainly not on a first date. But from the instant they lock eyes, life becomes a sexy, romantic dream come true.")  );
        assertTrue("product discount should match.", product.getDiscount() == 0.25  );
        assertTrue("product name should match.", product.getName().equals("The Medical Examiner")  );
        assertTrue("product url should match.", product.getPictureUrl().equals("assets/images/4.jpg")  );
        assertTrue("product price should match.", product.getPrice() == 300  );
        assertTrue("product qty should match.", product.getRemainingQuantity() == 9  );
        assertTrue("product review list should match.", product.getReviewList().length == 4);

    }


    @Test
    public void getProductsByPage(){
        Assertions
                .assertThat(productController.getProductsByPage("2"))
                .hasSize(19);
    }

    @Test
    public void getProductCount(){
        Assertions
                .assertThat(productController.getProductCount())
                .isEqualTo(39);

    }

    @Test
    public void getProductCountByCategoryId(){
        Assertions
                .assertThat(productController.getProductCountByCategoryId(1L))
                .isEqualTo(25);
    }

}
