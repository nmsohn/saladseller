<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    

<body>
  <form action="show.jsp" method="post" enctype= "multipart/form-data" >
  
                        <input type="file" value="upload" class="btn btn-primary">
                   <%
                            request.setCharacterEncoding("UTF-8");

                            int maxSize  = 1024*1024*100;

                          /*   String root = request.getSession().getServletContext().getRealPath("/");
 */
                            String savePath = "C:\\Users\\5CLASS-184\\Dropbox\\workspace\\test3\\WebContent\\images\\";
                      /*       config.getServletContext().getRealPath("/images"); */
                            /* application.getRealPath("/images/"); */
                                    //root + "upload";

                            String uploadFile = "";

                            String newFileName = "";

                            int read = 0;
                            byte[] buf = new byte[1024];
                            FileInputStream fin = null;
                            FileOutputStream fout = null;
/*                             long currentTime = System.currentTimeMillis();
                            SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss"); */
                            MultipartRequest multi = null;
                            try{                  
                               
                                multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
                                		 
                                /* Enumeration formNames=multi.getFileNames(); */
                                String title = multi.getParameter("title");
                                title = new String(title.getBytes("8859_1"), "UTF-8");
                                uploadFile = multi.getFilesystemName("uploadFile");                           
                                newFileName = uploadFile.substring(uploadFile.lastIndexOf(".")+1);                               
                                File oldFile = new File(savePath + uploadFile);                          
                                File newFile = new File(savePath + newFileName);
                             
                                if(!oldFile.renameTo(newFile)){

                                  
                                    buf = new byte[1024];
                                    fin = new FileInputStream(oldFile);
                                    fout = new FileOutputStream(newFile);
                                    read = 0;
                                    while((read=fin.read(buf,0,buf.length))!=-1){
                                        fout.write(buf, 0, read);
                                    }

                                    fin.close();
                                    fout.close();
                                    oldFile.delete();
                                }
                                		 

                            }catch(Exception e){
                                e.printStackTrace();
                            }

       
                            %>
                             <input type="submit" value="add" class="btn btn-primary">
</form>
</body>
</html>