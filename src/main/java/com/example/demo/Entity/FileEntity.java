package com.example.demo.Entity;


import javax.persistence.*;

@Entity
@Table(name = "Dosyalar")

public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;
    @Column(name="filePath")
    private String filePath;
    @Column(name = "fileSize")
    private Long fileSize;
    @Column(name="fileType")
    private String fileType;


    public FileEntity() {

    }

    public FileEntity(String filePath, Long fileSize, String fileType) {
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileType = fileType;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
