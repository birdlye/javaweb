package test.com.tjyd.web.dao;

import com.tjyd.web.dao.ProductDao;
import com.tjyd.web.model.Product;
import com.tjyd.web.service.ProductService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * ProductDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 1, 2018</pre>
 */
public class ProductDaoTest {
    ProductService productService;
//ProductDao productDao;

    @Before
    public void before() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        productService=context.getBean("productService",ProductService.class);
    }

    @After
    public void after() throws Exception {
        productService = null;
    }


    /**
     * Method: update(Product product)
     */
    @Test
    public void testUpdate() throws Exception {
        Product product = new Product();
        product.setName("xiaomi");
        product.setPrice(1800d);
        product.setRemark("hhhh");
        product.setId(3);
        ;

    }

    /**
     * Method: delete(Integer id)
     */
    @Test
    public void testDelete() throws Exception {
        productService.delete(3);
    }

    /**
     * Method: save(Product product)
     */
    @Test
    public void testSave() throws Exception {
        Product product = new Product();
        product.setName("xiaomi");
        product.setPrice(1700d);
        product.setRemark("hhhh");
        productService.save(product);
    }

    @Test
    public void testGetById() throws Exception {

    }

    @Test
    public void testGetByName() throws Exception {
        ArrayList<Product> p=productService.queryByName("");
        for(Product t:p){
            System.out.println(t);
        }
    }

} 
