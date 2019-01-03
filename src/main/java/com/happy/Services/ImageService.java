package com.happy.Services;

import com.happy.DTO.ImageDTO;
import com.happy.Exceptions.ActivityTypeNotFoundException;
import com.happy.Exceptions.ImageNotFoundException;
import com.happy.Models.Activity;
import com.happy.Models.Image;
import com.happy.Repositories.ActivityRepository;
import com.happy.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ActivityRepository activityRepository;

    public List<Image> getAllImages(){
        return imageRepository.findAll();
    }

    public Image getImageById(Integer id){
        return imageRepository.findById(id)
                .orElseThrow(() -> new ImageNotFoundException(id));
    }

    public Image newImage(ImageDTO img){
        return getImage(img);
    }

    public Image addOrReplace(ImageDTO newImage, Integer id){
        return imageRepository.findById(id)
                .map(image -> {
                    image.setImageid(newImage.getImageId());
                    image.setName(newImage.getName());

                    return imageRepository.save(image);
                }).orElseGet(() -> {
                    return getImage(newImage);
                });
    }

    public void deleteImageById(Integer id){
        imageRepository.deleteById(id);
    }

    private Image getImage(ImageDTO newImage) {
        Image image = new Image();
        Activity activity = activityRepository.findById(newImage.getActivityId())
                .orElseThrow(() -> new ActivityTypeNotFoundException(newImage.getActivityId()));
        image.setImageid(newImage.getImageId());
        image.setName(newImage.getName());
        image.setActivityImageId(activity);

        return imageRepository.save(image);
    }
}
