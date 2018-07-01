package test.com.tjyd.web.dao; 

import com.tjyd.web.dao.ProductDao;
import com.tjyd.web.model.Product;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ProductDao Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 1, 2018</pre> 
* @version 1.0 
*/ 
public class ProductDaoTest { 
private ProductDao productDao;
@Before
public void before() throws Exception {
    productDao=new ProductDao();
} 

@After
public void after() throws Exception {
    productDao=null;
} 


/** 
* 
* Method: update(Product product) 
* 
*/ 
@Test
public void testUpdate() throws Exception {
    Product product=new Product();
    product.setName("xiaomi");
    product.setPrice(1900d);
    product.setRemark("hhhh");
    product.setId(3);
    productDao.update(product);
} 

/** 
* 
* Method: delete(Integer id) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
    productDao.delete(3);
} 

/** 
* 
* Method: save(Product product) 
* 
*/ 
@Test
public void testSave() throws Exception {
    Product product=new Product();
    product.setName("xiaomi");
    product.setPrice(1400d);
    product.setRemark("hhhh");
    product.setId(3);
    productDao.save(product);
} 


} 
