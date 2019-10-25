package com.test.project.controller;

import com.test.project.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ImageController {


    @Autowired
    private StorageService storageService;

    @GetMapping("/get")
    public String showUploadPage(Model model) {



        model.addAttribute("image", storageService.getImageById(19).getName());

        return "upload";
    }


    @PostMapping("/upload")
    public String uploadImageOnDisk(@RequestParam("imageFile") MultipartFile multipartFile) throws Exception {

        if(multipartFile != null){
            storageService.uploadImage(multipartFile);
            storageService.saveDataAboutImageInDatabase(multipartFile);
        }

        if(multipartFile == null){
            System.out.println(">>>>>>>>>>>>>>>> FUCCKKKEEEEED");
            throw new Exception("Something went fucking wrong again");
        }

        System.out.println("asdasdasdasdasdasdasdsa");

        return "redirect:/get";
    }


}
