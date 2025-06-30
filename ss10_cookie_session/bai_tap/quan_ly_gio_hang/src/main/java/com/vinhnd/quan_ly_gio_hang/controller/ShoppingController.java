package com.vinhnd.quan_ly_gio_hang.controller;

import com.vinhnd.quan_ly_gio_hang.entity.Cart;
import com.vinhnd.quan_ly_gio_hang.entity.Product;
import com.vinhnd.quan_ly_gio_hang.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ShoppingController {
    private final IProductService productService;

    public ShoppingController(IProductService productService) {
        this.productService = productService;
    }


    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute(name = "cart", required = false) Cart cart){
        if(cart == null){
            cart = new Cart();
        }
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("/shopping-cart/remove")
    public String removeProduct (@RequestParam Long id, @ModelAttribute("cart") Cart cart){
        Optional<Product> productOptional = productService.findById(id);
        cart.removeProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/shopping-cart/decrease")
    public String decreaseQuantity(@RequestParam Long id, @ModelAttribute("cart") Cart cart){
        Optional<Product> productOptional = productService.findById(id);
        cart.decreaseQuantity(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/shopping-cart/increase")
    public String increaseQuantity(@RequestParam Long id, @ModelAttribute("cart") Cart cart){
        Optional<Product> productOptional = productService.findById(id);
        cart.increaseQuantity(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/shopping-cart/payment")
    public String payment( @ModelAttribute("cart") Cart cart){
        cart.cleanAll();
        return "redirect:/shopping-cart";
    }
}
