package com.example.getmeapi.resource;

import com.example.getmeapi.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileResource {


    @Autowired
    private FileService fileService;

    @PostMapping
    public boolean upload(@RequestParam(name ="file")MultipartFile file){
        return fileService.upload(file);
    }
}
