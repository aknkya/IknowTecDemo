package com.example.demo.DAO;


import com.example.demo.Entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDAO extends JpaRepository<FileEntity,Long> {


    @Query("SELECT u FROM FileEntity u where u.fileId=?1")
    public FileEntity findByFileByID(Long fileId);





}
