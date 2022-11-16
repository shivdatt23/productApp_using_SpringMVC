package productcrudapp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;




    public void saveProduct(Product product){

        this.productDao.createProduct(product);

    }


    public int deleteProduct(int pid){
        return this.productDao.deleteProduct(pid);
    }
    //get the single product
    public Product getProduct(int pid){
        Product p=this.productDao.getProduct(pid);
        return p;
    }



    //get all products
    public List<Product> getAllProducts(){
        List<Product> products=this.productDao.getAllProducts();
        return products;
    }

}
