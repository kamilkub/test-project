package com.test.project.controller;

import com.test.project.model.Customer;
import com.test.project.model.Market;
import com.test.project.model.Product;
import com.test.project.model.Room;
import com.test.project.repository.ProductRepository;
import com.test.project.service.HotelService;
import com.test.project.service.MarketService;
import com.test.project.service.StorageService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MarketService marketService;

    @Autowired
    private HotelService hotelService;

    private Customer sharedCustomer;



   @GetMapping("/")
   public String showPage(Model model){

       //List<Market> allData = marketService.getAllData();

       //model.addAttribute("data", allData);

       model.addAttribute("customer", new Customer());

       model.addAttribute("product", new Product());


       List<Room> rooms = hotelService.findRoomsByIsReserved(true);

       rooms.forEach(room -> System.out.println(room.getCustomer().getFirstName()));

       if(sharedCustomer != null){
           model.addAttribute("firstName", sharedCustomer.getFirstName());
           model.addAttribute("lastName", sharedCustomer.getLastName());
       }



       return "index";
   }

    @GetMapping("/image")
    public void responseWithImage(HttpServletResponse response, HttpServletRequest request) throws Exception{

        byte [] image = marketService.dataImage();

        response.setContentType("image/jpeg");

        ServletOutputStream servletOS = response.getOutputStream();
        servletOS.write(image);
        servletOS.close();

    }

   @PostMapping("/reserve")
    public String reserveRoom(Model model, @ModelAttribute("Customer")Customer customer){

       sharedCustomer = customer;

       hotelService.reserveARoom(customer);

       return "redirect:/";
   }


   @PostMapping("/check")
    public String checkTheModel(@ModelAttribute("Product") Product product) throws Exception{

       System.out.println(product.getImage().getSize());



       if(!product.getName().isEmpty()){
           product.changeImage(product.getImage());

           marketService.addProduct(product);
       }


       return "redirect:/";
   }


}
