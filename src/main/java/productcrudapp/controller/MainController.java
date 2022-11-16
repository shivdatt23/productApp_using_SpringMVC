package productcrudapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;
import org.springframework.web.servlet.view.RedirectView;
import productcrudapp.model.Product;
import productcrudapp.services.ProductService;
import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.util.List;

@Controller
@RequestMapping("/productcrud")
public class MainController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/")
    public String home(Model model){
        System.out.println("inside home");
        List<Product> products=productService.getAllProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("/add-product")
    public String showProductForm(Model model){
        model.addAttribute("title","Add Product");
        System.out.println("inside product add form");
        return "add_product_form";
    }

    //handle add product form

    @RequestMapping(value = "/handle-product",method = RequestMethod.POST)
    public RedirectView productHandle(@ModelAttribute Product product, HttpServletRequest request){
        System.out.println(product);
        productService.saveProduct(product);
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/productcrud/");
        return redirectView;

    }

    //handle delete product
    @RequestMapping("/delete/{productId}")
    public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request){
        this.productService.deleteProduct(productId);
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/productcrud/");
        return redirectView;
    }

    //handle update product
    @RequestMapping("/update/{productId}")
    public String updateForm(@PathVariable("productId") int id,Model model){
        Product product=this.productService.getProduct(id);
        model.addAttribute("product",product);
        return "update_form";
    }




}
