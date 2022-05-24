package com.example.demo.DAO;


import com.example.demo.Entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDAO extends JpaRepository<FileEntity,Long> {
}
