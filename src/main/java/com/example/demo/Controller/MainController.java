package com.example.demo.Controller;


import com.example.demo.DAO.FileDAO;
import com.example.demo.Entity.FileEntity;
import com.example.demo.Service.MainService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class MainController {

   @Autowired
    private MainService mainService;



   @GetMapping("/deletefile/{fileId}")
   public String deleteFile(@PathVariable("fileId") Long fileid){


       mainService.deleteFileOnLocalSystem(mainService.findFileByIdOnLocalSystem(fileid));


        mainService.deleteFileOnDataBaseById(fileid);

       return "mainpage";
   }


@GetMapping("/filespage")
public String getFilesPage(Model model){





     List<FileEntity> files=mainService.getAllFiles();
    model.addAttribute("files",files);

    return "filespage";
}

    @GetMapping("/")
    public String getMainPage(){

        return "mainpage";
    }

    @GetMapping("/uploader")
    public String getUploaderPage(){

        return "uploader";
    }

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file ) throws IOException {


        Path filepath = Paths.get("src/files", file.getOriginalFilename());

        File f = new File("src/files/" +file.getOriginalFilename());


        long fileSize = f.length();


        if (fileSize>5242880){
        f.delete();
            return new ResponseEntity(HttpStatus.CONFLICT);
        }


        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
        String ext1 = FilenameUtils.getExtension(f.getAbsolutePath()); // returns "txt"
        mainService.addNewFile("src/files/" +file.getOriginalFilename(),f.length(),ext1);

        return ResponseEntity.ok("File uploaded successfully.");

    }
}
