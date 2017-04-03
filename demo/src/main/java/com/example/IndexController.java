package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@EnableAutoConfiguration
public class IndexController implements ErrorController {

	 private static final String PATH = "/error";

	 @RequestMapping(value = "/", method = RequestMethod.GET)
	    public ModelAndView hello() {
	        ModelAndView mav = new ModelAndView();
	        mav.setViewName("welcome");
	        
	        String str = "Hello World!";
	        mav.addObject("message", str);

	        return mav;
	    }
	 
		
		@PostMapping("/demo/rest/upload")
	    public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file,
	                                   RedirectAttributes redirectAttributes) {

			System.out.println("-----------------");
	  //      storageService.store(file);
	        redirectAttributes.addFlashAttribute("message",
	                "You successfully uploaded " + file.getOriginalFilename() + "!");
	        String workingDir = System.getProperty("user.dir");
	    	BufferedReader br = null;
	    
	       try {
			FileWriter fw = new FileWriter("file");
			
			System.out.println(file.getInputStream().toString());
			br = new BufferedReader(new InputStreamReader(file.getInputStream()));

			StringBuilder sb = new StringBuilder();

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				fw.write(line);
			}

			fw.close();
			//fw.write(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	       
	        
	 	   System.out.println("Current working directory : " + workingDir);
	        ModelAndView mav = new ModelAndView();
	        mav.setViewName("fileUpload");
	        
	        String str = "Success " + file.getOriginalFilename().toString() + " Uploaded Successfully";
	      
	        str += "  File size:  " + file.getSize();
	        
	        mav.addObject("message", str);

	        return mav;
	    }
//		
		 @Scheduled(fixedRateString = "${poll.data.changes}", initialDelayString = "${poll.data.delay}") // reset cache every hr, with delay of 1hr after app start
		    public void reportCurrentTime() {
		       System.out.println("___________________");
		    }
//	    @RequestMapping(value = PATH)
//	    public String error() {
//	        return "Error handling";
//	    }

    public String getErrorPath() {
        return PATH;
    }
}