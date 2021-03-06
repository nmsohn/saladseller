<%@ include file="/layout/header.jsp" %>
    <%@ taglib uri="/WEB-INF/CustomTags.tld" prefix="f" %>

	<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm" role="banner" style="background-image:url(images/img_bg_2.jpg);">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>Product</h1>
							<h2>Free html5 templates Made by <a href="http://freehtml5.co" target="_blank">freehtml5.co</a></h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<div id="fh5co-product">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
				<%
				String category = "Processed";
				%>
					<span><label for="email" class="sr-only">Email</label><%=category %></span>
					<h2></h2>
					<p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
				</div>
			</div>

<c:forEach items="${product}" var="product" >
			<div class="row">
				<div class="col-md-4 text-center animate-box">
					<div class="product">
						<div class="product-grid" style="background-image:url(<c:url value="/images/${product.imagePath}" />);">
							<div class="inner">
								<p>
									<a href="single.html" class="icon" ng-click="addToCart('${product.p_id}')" data-toggle="modal"><i class="icon-shopping-cart"></i></a>
									<a href="single.html" class="icon"><i class="icon-eye"></i></a>
								</p>
							</div>
						</div>


						<div class="desc">
							<input type="hidden" value="${p_id}" name="id">
							<h3><a href="detail.jsp">${product.name}</a></h3>
							<span class="price">${product.price}</span>
						</div>
					</div>
				</div>

				</c:forEach>

				

				<div id="themodal" class="modal hide fade">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						<h3>Add Item to the Cart</h3>
					</div>

					<div class="modal-body">
						<c:choose>
							<c:when test="${f:checkProductInCart(pageContext)}">
								<p class="text-warning">Product - ${product.name} is
									already added to your Shopping Cart.</p>
							</c:when>
							<c:otherwise>
								<p class="text-success">Product - ${product.name} will
									be added to your Shopping Cart.</p>
							</c:otherwise>
						</c:choose>

						<hr />
						<div>
							<table class="table table-condensed">
								<thead>
								<tr>
									<td>Product</td>
									<td>Quantity</td>
									<td>Price</td>
								</tr>
								</thead>
								<tbody>
								<tr class="active">
									<td><img src="images/${product.imagePath}.jpg" /></td>
									<td><input class="input-mini" type="text" placeholder="1"></td>
									<td class="price">${product.price}</td>
								</tr>
								</tbody>
							</table>
						</div>

						<div class="modal-footer">
							<form method="post" action="addProduct" class="addCartForm">
								<c:choose>
									<c:when test="${f:checkProductInCart(pageContext)}">
										<button class="btn btn-primary pull-left" id="disabledbutton"
												onload="disableButton">In Cart!</button>
									</c:when>
									<c:otherwise>
										<button class="btn btn-primary pull-left" id="addtocart">Add
											to Cart</button>
									</c:otherwise>
								</c:choose>

								<a href="#" class="btn" data-dismiss="modal">Continue
									Shopping</a> <a id="yesbutton" href="#" class="btn btn-primary">Place
								Order</a>
							</form>
						</div>
					</div>
				</div> 

				<!-- <div id="fh5co-contact">
                    <div class="container">
                        <div class="col-md-6 animate-box">
                            <h3>login</h3>
                            <form action="login.do">
                                <div class="row form-group">
                                    <div class="col-md-6">
                                        <input type="text" name="id" class="form-control"
                                            placeholder="id">
                                        <input type="password" name="pw"
                                            class="form-control" placeholder="password">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <input type="submit" value="Login" class="btn btn-primary">
                                    <input type="button" value="Join" class="btn btn-primary" onclick="location.href='joinForm.do'">
                                </div>
                            </form>
                        </div>
                    </div>
                </div> -->
				<div class="col-md-4 text-center animate-box">
					<div class="product">
						<div class="product-grid" style="background-image:url(images/product-2.jpg);">
							<div class="inner">
								<p>
									<a href="single.html" class="icon"><i class="icon-shopping-cart"></i></a>
									<a href="single.html" class="icon"><i class="icon-eye"></i></a>
								</p>
							</div>
						</div>
						<div class="desc">
							<h3><a href="single.html">Pavilion Speaker</a></h3>
							<span class="price">$600</span>
						</div>
					</div>
				</div>


				<div class="col-md-4 text-center animate-box">
					<div class="product">
						<div class="product-grid" style="background-image:url(images/product-3.jpg);">
							<div class="inner">
								<p>
									<a href="single.html" class="icon"><i class="icon-shopping-cart"></i></a>
									<a href="single.html" class="icon"><i class="icon-eye"></i></a>
								</p>
							</div>
						</div>
						<div class="desc">
							<h3><a href="single.html">Ligomancer</a></h3>
							<span class="price">$780</span>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 text-center animate-box">
					<div class="product">
						<div class="product-grid" style="background-image:url(images/product-4.jpg);">
							<div class="inner">
								<p>
									<a href="single.html" class="icon"><i class="icon-shopping-cart"></i></a>
									<a href="single.html" class="icon"><i class="icon-eye"></i></a>
								</p>
							</div>
						</div>
						<div class="desc">
							<h3><a href="single.html">Alato Cabinet</a></h3>
							<span class="price">$800</span>
						</div>
					</div>
				</div>
				<div class="col-md-4 text-center animate-box">
					<div class="product">
						<div class="product-grid" style="background-image:url(images/product-5.jpg);">
							<div class="inner">
								<p>
									<a href="single.html" class="icon"><i class="icon-shopping-cart"></i></a>
									<a href="single.html" class="icon"><i class="icon-eye"></i></a>
								</p>
							</div>
						</div>
						<div class="desc">
							<h3><a href="single.html">Earing Wireless</a></h3>
							<span class="price">$100</span>
						</div>
					</div>
				</div>
				<div class="col-md-4 text-center animate-box">
					<div class="product">
						<div class="product-grid" style="background-image:url(images/product-6.jpg);">
							<div class="inner">
								<p>
									<a href="single.html" class="icon"><i class="icon-shopping-cart"></i></a>
									<a href="single.html" class="icon"><i class="icon-eye"></i></a>
								</p>
							</div>
						</div>
						<div class="desc">
							<h3><a href="single.html">Sculptural Coffee Table</a></h3>
							<span class="price">$960</span>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 text-center animate-box">
					<div class="product">
						<div class="product-grid" style="background-image:url(images/product-7.jpg);">
							<div class="inner">
								<p>
									<a href="single.html" class="icon"><i class="icon-shopping-cart"></i></a>
									<a href="single.html" class="icon"><i class="icon-eye"></i></a>
								</p>
							</div>
						</div>
						<div class="desc">
							<h3><a href="single.html">The WW Chair</a></h3>
							<span class="price">$540</span>
						</div>
					</div>
				</div>
				<div class="col-md-4 text-center animate-box">
					<div class="product">
						<div class="product-grid" style="background-image:url(images/product-8.jpg);">
							<div class="inner">
								<p>
									<a href="single.html" class="icon"><i class="icon-shopping-cart"></i></a>
									<a href="single.html" class="icon"><i class="icon-eye"></i></a>
								</p>
							</div>
						</div>
						<div class="desc">
							<h3><a href="single.html">Himitsu Money Box</a></h3>
							<span class="price">$55</span>
						</div>
					</div>
				</div>
				<div class="col-md-4 text-center animate-box">
					<div class="product">
						<div class="product-grid" style="background-image:url(images/product-9.jpg);">
							<div class="inner">
								<p>
									<a href="single.html" class="icon"><i class="icon-shopping-cart"></i></a>
									<a href="single.html" class="icon"><i class="icon-eye"></i></a>
								</p>
							</div>
						</div>
						<div class="desc">
							<h3><a href="single.html">Ariane Prin</a></h3>
							<span class="price">$99</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="fh5co-started">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>Newsletter</h2>
					<p>Just stay tune for our latest Product. Now you can subscribe</p>
				</div>
			</div>
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2">
					<form class="form-inline">
						<div class="col-md-6 col-sm-6">
							<div class="form-group">
								<label for="email" class="sr-only">Email</label>
								<input type="email" class="form-control" id="email" placeholder="Email">
							</div>
						</div>
						<div class="col-md-6 col-sm-6">
							<button type="submit" class="btn btn-default btn-block">Subscribe</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

<%@ include file="/layout/footer.jsp" %>
