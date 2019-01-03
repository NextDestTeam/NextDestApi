package com.happy.Controllers;

import com.happy.DTO.ImageDTO;
import com.happy.Models.Image;
import com.happy.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/images")
    public List<Image> getAllImages(){
        return imageService.getAllImages();
    }

    @GetMapping("/image/{id}")
    public Image getImage(@PathVariable Integer id){
        return imageService.getImageById(id);
    }

    @PostMapping("/images")
    public Image newImage(@RequestBody ImageDTO image){
        return imageService.newImage(image);
    }

    @PutMapping("/image/{id}")
    public Image addOrReplace(@RequestBody ImageDTO image, @PathVariable Integer id){
        return imageService.addOrReplace(image, id);
    }

    @DeleteMapping("/image/{id}")
    public void deleteImage(@PathVariable Integer id){
        imageService.deleteImageById(id);
    }
}
