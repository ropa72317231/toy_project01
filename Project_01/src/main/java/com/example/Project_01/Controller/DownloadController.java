package com.example.Project_01.Controller;



import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project_01.Repository.FileRepository;



@Controller
@RequestMapping("/board")
public class DownloadController {
	@Autowired
	FileRepository fileRepository;

	@GetMapping("/download")
	public ResponseEntity<Resource> download(Long id) throws Exception {
		Optional<com.example.Project_01.Model.File> down = fileRepository.findById(id);
		com.example.Project_01.Model.File down2 = down.get();
		
		File file = new File(down2.getFileName());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity.ok()
				.header("content-disposition", "filename=" + URLEncoder.encode(file.getName(), "utf-8"))
				.contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(resource);
	}	
}