package test.com.tjyd.web.dao;

import com.tjyd.web.dao.ProductDao;
import com.tjyd.web.model.Product;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;

/**
 * ProductDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 1, 2018</pre>
 */
public class ProductDaoTest {
    private ProductDao productDao;

    @Before
    public void before() throws Exception {
        productDao = new ProductDao();
    }

    @After
    public void after() throws Exception {
        productDao = null;
    }


    /**
     * Method: update(Product product)
     */
    @Test
    public void testUpdate() throws Exception {
        Product product = new Product();
        product.setName("xiaomi");
        product.setPrice(1900d);
        product.setRemark("hhhh");
        product.setId(3);
        productDao.update(product);
    }

    /**
     * Method: delete(Integer id)
     */
    @Test
    public void testDelete() throws Exception {
        productDao.delete(3);
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
        productDao.save(product);
    }

    @Test
    public void testGetById() throws Exception {
        Product p=productDao.getById(3);
        System.out.println(p.getName());
    }

    @Test
    public void testGetByName() throws Exception {
        ArrayList<Product> p=productDao.queryByName("");
        for(Product t:p){
            System.out.println(t);
        }
    }

} 
