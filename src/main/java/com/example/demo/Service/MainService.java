package com.example.demo.Service;

import com.example.demo.DAO.FileDAO;
import com.example.demo.Entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MainService {
    @Autowired
    FileDAO fileDAO;

    public String addNewFile(String filePath,Long size,String fileType){
        FileEntity fileEntity=new FileEntity(filePath,size,fileType);
        fileDAO.save(fileEntity);
        return "file saved";
    }


    public List<FileEntity> getAllFiles(){

        List<FileEntity> files=fileDAO.findAll();

        return files;
    }

}
