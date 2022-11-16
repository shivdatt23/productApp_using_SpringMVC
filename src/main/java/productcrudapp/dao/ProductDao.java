package productcrudapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import productcrudapp.model.Product;

import java.util.List;

@Component
public class ProductDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;



    //create
    @Transactional
    public void createProduct(Product product){
        this.hibernateTemplate.saveOrUpdate(product);
    }

    //get all products
    public List<Product> getAllProducts(){
        List<Product> products=this.hibernateTemplate.loadAll(Product.class);
        return products;
    }

    //delete product
    @Transactional
    public int deleteProduct(int pid){
        Product p=this.hibernateTemplate.load(Product.class,pid);
       this.hibernateTemplate.delete(p);
       return pid;
    }

    //get the single product
    public Product getProduct(int pid){
        Product p=this.hibernateTemplate.load(Product.class,pid);
        return p;

    }


//    //update
//    @Transactional
//    public void updateProduct(int pid){
//
//
//    }

}
