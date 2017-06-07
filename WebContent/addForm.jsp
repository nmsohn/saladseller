<%@ include file="/layout/header.jsp" %>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import="java.io.*" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

<div id="fh5co-contact">
    <div class="container">
        <div class="col-md-6 animate-box">
            <h3>AddProduct</h3>
            <form action="product.jsp" method="post" enctype="multipart/form-data">
                <div class="row form-group">
                    <div class="col-md-6">
                        <input type="text" name="name" class="form-control" placeholder="name">
                        //html version
                        <select name="category">
                            <c:forEach items="${category}" var="category" >
                                <option value="${category.c_id}">${category.name}</option>

                            </c:forEach>

                        </select>
                        //bootstrap version
                        <button class="btn btn-primary dropdown-toggle" id="category" type="button" data-toggle="dropdown">Category
                            <span class="caret"></span></button>
                        <div>


                        <ul class="dropdown-menu">
<c:forEach items="${category}" var="category" >
                            <li><a href="#" value="${category.name}">${category.name}</a></li>
                            <%--<li><a href="#" value="">즉석식품</a></li>--%>
                            <%--<li><a href="#">디저트</a></li>--%>
</c:forEach>

                            //get selecteditem from dropdown list
                            <%
                            String selectedItem;
                            selectedItem = request.getParameter("category");
                            if(selectedItem ==null){
                                System.out.println("selected item is null");
                            }
                            if(selectedItem.length() ==0){
                                System.out.println("selected item is empty");
                            }
                            %>

                            //javascript version
                            //get selected item from dropdown list

                            <script>
                                var text;
                                var selectedItem = '';
                                var param = document.getElementById("category");
                                selectedItem = param.options[param.selectedIndex].text;
                                if(selectedItem == '가공식품'){
                                    text = '가공식품';
                                }else if(selectedItem == '즉석식품'){
                                    text = '즉석식품';
                                }else if(selectedItem == '디저트'){
                                    text = '디저트'
                                }
//                                $(document).on('click','.dropdown-menu li a', function(){
//                                    $('#category').val($(this).text());
//                                });
                                $('#catlabel').add(text);

                            </script>

                        </ul>
                        </div>

                        //display selectedItem
                        <label class="btn btn-default blue" id="catlabel" name=<%=selectedItem%> class="form-control" placeholder="category"></label>
                        <textarea name="description" class="form-control" placeholder="description"></textarea>
                            <input
                            type="text" name="price" class="form-control" placeholder="price" >
                            <input
                            type="text" name="quantity" class="form-control" placeholder="quantity">

                        <input type="file" value="upload" class="btn btn-primary">
                        //image upload
                        <%
                            request.setCharacterEncoding("UTF-8");

                            // 10Mbyte 제한
                            int maxSize  = 1024*1024*10;

                            // 웹서버 컨테이너 경로
                            String root = request.getSession().getServletContext().getRealPath("/");

                            // 파일 저장 경로(ex : /home/tour/web/ROOT/upload)
                            String savePath = "./images/upload";
                                    //root + "upload";

                            // 업로드 파일명
                            String uploadFile = "";

                            // 실제 저장할 파일명
                            String newFileName = "";

                            int read = 0;
                            byte[] buf = new byte[1024];
                            FileInputStream fin = null;
                            FileOutputStream fout = null;
                            long currentTime = System.currentTimeMillis();
                            SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
                            try{

                                MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());

                                // 전송받은 parameter의 한글깨짐 방지
                                String title = multi.getParameter("title");
                                title = new String(title.getBytes("8859_1"), "UTF-8");

                                // 파일업로드
                                uploadFile = multi.getFilesystemName("uploadFile");

                                // 실제 저장할 파일명(ex : 20140819151221.zip)
                                newFileName = simDf.format(new Date(currentTime)) +"."+ uploadFile.substring(uploadFile.lastIndexOf(".")+1);


                                // 업로드된 파일 객체 생성
                                File oldFile = new File(savePath + uploadFile);


                                // 실제 저장될 파일 객체 생성
                                File newFile = new File(savePath + newFileName);


                                // 파일명 rename
                                if(!oldFile.renameTo(newFile)){

                                    // rename이 되지 않을경우 강제로 파일을 복사하고 기존파일은 삭제

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



                    </div>
                </div>

                <div class="form-group">
                    <input type="submit" value="add" class="btn btn-primary">
                    <input type="button" value="reset" class="btn btn-primary"
                           onclick="location.href='addForm.do'">
                </div>
            </form>
        </div>
    </div>
</div>

<%--<div id="wrap" align="center">--%>
    <%--<h1>게시글 등록</h1>--%>
    <%--<form name="frm" method = "get" action ="ProductServlet">--%>
        <%--<input type="hidden" name = "command" value = "product_write">--%>
        <%--<table>--%>
            <%--<tr>--%>
                <%--<th>product name</th>--%>
                <%--<td><input type ="text" name ="name">*필수</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<th>비밀번호</th>--%>
                <%--<td><input type ="password" name ="pass">--%>
                    <%--*필수(게시물 수정 삭제시 필요합니다.)--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<th>이메일</th>--%>
                <%--<td><input type ="text" name ="email"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<th>제목</th>--%>
                <%--<td><input type ="text" name ="title"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<th>내용</th>--%>
                <%--<td>--%>
                    <%--<textarea rows="15" cols="70" name = "content"></textarea>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</table>--%>
        <%--<br>--%>
        <%--<input type="submit" value = "등록" onclick="return boardCheck()">--%>
        <%--<input type= "reset" value = "다시 작성">--%>
        <%--<input type = "button" value = "목록"--%>
               <%--onclick="location.href='BoardServlet?command=board_list'">--%>

    <%--</form>--%>
<%--</div>--%>
</body>
</html>
















