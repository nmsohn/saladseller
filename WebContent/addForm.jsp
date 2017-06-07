<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import="java.io.*" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ include file="/layout/header.jsp" %>


<div id="fh5co-contact">
    <div class="container">
        <div class="col-md-6 animate-box">
            <h3>AddProduct</h3>
            
            <form action="productServlet" method="post" enctype= "multipart/form-data" >
                <div class="row form-group">
                    <div class="col-md-6">
                        <input type="text" name="name" class="form-control" placeholder="name">
                        <%--html version--%>
                        <select name="category">
                            <c:forEach items="${category}" var="category" >
                                <option value="${category.c_id}">${category.name}</option>

                            </c:forEach>

                        </select>
                        <%--bootstrap version --%>
                       <%--  <button class="btn btn-primary dropdown-toggle" id="category" type="button" data-toggle="dropdown">Category
                            <span class="caret"></span></button>
                        <div>


                        <ul class="dropdown-menu">
<c:forEach items="${category}" var="category" >
                            <li><a href="#" value="${category.name}">${category.name}</a></li> --%>
                            <%--<li><a href="#" value="">즉석식품</a></li>--%>
                            <%--<li><a href="#">디저트</a></li>--%>
<%-- </c:forEach> --%>

                             <%--javascript version: get selecteditem from dropdown list--%>
                            <%
                            String selectedItem;
                            selectedItem = request.getParameter("category");
                         /*    if(selectedItem ==null){
                                System.out.println("selected item is null");
                            }
                            if(selectedItem.length() ==0){
                                System.out.println("selected item is empty");
                            } */
                            %>

                            <%--javascript version--%>

<!--                             <script>
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
                        </div> -->

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
                        	
                        %>


                    </div>
                </div>

                <div class="form-group">
                    <input type="submit" value="add" class="btn btn-primary">
                    <input type="button" value="reset" class="btn btn-primary"
                           onclick="location.href='addForm.co'">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
















