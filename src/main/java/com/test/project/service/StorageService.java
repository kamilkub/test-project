package com.test.project.service;

import com.test.project.model.Image;
import com.test.project.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {


    private final String UPLOAD_PATH  = "C://Users//dell//Desktop//test-project//src//main//resources//static//images//";

    private ImageRepository imageRepository;

    public StorageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    public void uploadImage(MultipartFile mFile) throws Exception{

        byte [] mFileBytes = mFile.getBytes();
        Path path = Paths.get(UPLOAD_PATH + mFile.getOriginalFilename());

        Files.write(path, mFileBytes);
    }

    public void saveDataAboutImageInDatabase(MultipartFile mFile){
        Image imageUpload = new Image();

        imageUpload.setName(mFile.getOriginalFilename());
        imageUpload.setPath(UPLOAD_PATH+mFile.getOriginalFilename());

        imageRepository.save(imageUpload);
    }

    public Image getImageById(int id){
        return imageRepository.findById(id);
    }


}
