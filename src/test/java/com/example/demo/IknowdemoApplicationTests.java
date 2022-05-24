package com.example.demo;

import com.example.demo.DAO.FileDAO;
import com.example.demo.Entity.FileEntity;
import com.example.demo.Service.MainService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
class IknowdemoApplicationTests {

	@Mock
	MainService mainService;

	@MockBean
	FileDAO fileDAO;

	@Test
	void contextLoads() {
	}


	@Test
	void deleteByIdTest(){

		FileEntity fileEntity=new FileEntity("deneme",24L,"txt");
		fileEntity.setFileId(666L);


		mainService.addNewFile(fileEntity.getFilePath(), fileEntity.getFileSize(), fileEntity.getFileType());

		mainService.deleteFileOnDataBaseById(fileEntity.getFileId());
		FileEntity fileEntity1=fileDAO.findByFileByID(fileEntity.getFileId());



		Assert.assertEquals(fileEntity1,null);

	}

    @Test
	void insertFileTest(){
		FileEntity fileEntity=new FileEntity("deneme",24L,"txt");

		mainService.addNewFile(fileEntity.getFilePath(), fileEntity.getFileSize(), fileEntity.getFileType());

		FileEntity fileEntity1=fileDAO.findfileByName(fileEntity.getFilePath());

		Assert.assertEquals(fileEntity1.getFilePath(),fileEntity.getFilePath());
  }




}
