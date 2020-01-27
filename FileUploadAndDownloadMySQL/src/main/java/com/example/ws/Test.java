package com.example.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.model.DBFile;
import com.example.service.DBFileStorageService;

@RestController
@RequestMapping("/ws/v1")
public class Test {

	@Autowired
	private DBFileStorageService dbFileStorageService;

	@GetMapping(value = "/files", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DBFile>> employeeList() {

		return new ResponseEntity<>(dbFileStorageService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/file/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DBFile> employeeById(@PathVariable("id") String id) {
		DBFile e = dbFileStorageService.findById(id);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

	@PostMapping("/uploadFile")
	public void uploadFile(@RequestParam("file") MultipartFile file) {

		dbFileStorageService.storeFile(file);

	}
}
