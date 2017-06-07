package com.saladseller.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.http.Part;

@WebServlet(name = "imageUpload", urlPatterns = "/imageUpload")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
             maxFileSize=1024*1024*10,      // 10MB
             maxRequestSize=1024*1024*50)
public class ImageServlet extends HttpServlet{
	private static final String SAVE_DIR="images";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doProc(req, resp);
	}
	 protected void doProc(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
		 	resp.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = resp.getWriter();
		        String savePath =  "C:\\Users\\5CLASS-184\\Dropbox\\workspace\\test3\\WebContent\\"+SAVE_DIR; //specify your path here
		            File fileSaveDir=new File(savePath);
		            if(!fileSaveDir.exists()){
		                fileSaveDir.mkdir();
		            }

		        Part part=req.getPart("file");
		        String fileName=extractFileName(part);
		        part.write(savePath + File.separator + fileName);
		        
		        getServletContext().getRequestDispatcher("/done.jsp").forward(
	                    req, resp);
		
	}
	 private String extractFileName(Part part) {
		    String contentDisp = part.getHeader("content-disposition");
		    String[] items = contentDisp.split(";");
		    for (String s : items) {
		        if (s.trim().startsWith("filename")) {
		            return s.substring(s.indexOf("=") + 2, s.length()-1);
		        }
		    }
		    return "";
		}

}
