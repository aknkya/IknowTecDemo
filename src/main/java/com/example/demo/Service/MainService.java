package com.example.demo.Service;

import com.example.demo.DAO.FileDAO;
import com.example.demo.Entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.io.File;

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

    public void deleteFileOnDataBaseById(Long fileId){
        fileDAO.deleteById(fileId);
    }

    public void deleteFileOnLocalSystem(String filename){


        File file=new File(filename);
        if(file.exists()){
            file.delete();
        }

    }

    public String findFileByIdOnLocalSystem(Long fileId){

     FileEntity fileEntity=fileDAO.findByFileByID(fileId);

     return fileEntity.getFilePath();

    }

}
