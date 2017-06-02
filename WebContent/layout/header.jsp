<%--
  Created by IntelliJ IDEA.
  User: 5CLASS-184
  Date: 2017-06-02
  Time: 오후 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<html>
<head>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Shop &mdash; Free Website Template, Free HTML5 Template by gettemplates.co</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Free HTML5 Website Template by gettemplates.co" />
        <meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
        <meta name="author" content="gettemplates.co" />

        <!--
        //////////////////////////////////////////////////////

        FREE HTML5 TEMPLATE
        DESIGNED & DEVELOPED by FreeHTML5.co

        Website: 		http://freehtml5.co/
        Email: 			info@freehtml5.co
        Twitter: 		http://twitter.com/fh5co
        Facebook: 		https://www.facebook.com/fh5co

        //////////////////////////////////////////////////////
         -->

        <!-- Facebook and Twitter integration -->
        <meta property="og:title" content=""/>
        <meta property="og:image" content=""/>
        <meta property="og:url" content=""/>
        <meta property="og:site_name" content=""/>
        <meta property="og:description" content=""/>
        <meta name="twitter:title" content="" />
        <meta name="twitter:image" content="" />
        <meta name="twitter:url" content="" />
        <meta name="twitter:card" content="" />

        <!-- <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet"> -->
        <!-- <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i" rel="stylesheet"> -->

        <!-- Animate.css -->
        <link rel="stylesheet" href="../css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="../css/icomoon.css">
        <!-- Bootstrap  -->
        <link rel="stylesheet" href="../css/bootstrap.css">

        <!-- Flexslider  -->
        <link rel="stylesheet" href="../css/flexslider.css">

        <!-- Owl Carousel  -->
        <link rel="stylesheet" href="../css/owl.carousel.min.css">
        <link rel="stylesheet" href="../css/owl.theme.default.min.css">

        <!-- Theme style  -->
        <link rel="stylesheet" href="../css/style.css">

        <!-- Modernizr JS -->
        <script src="../js/modernizr-2.6.2.min.js"></script>
        <!-- FOR IE9 below -->
        <!--[if lt IE 9]>
        <script src="js/respond.min.js"></script>
        <![endif]-->

    </head>
</head>
<body>
<div class="fh5co-loader"></div>

<div id="page">
    <nav class="fh5co-nav" role="navigation">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-xs-2">
                    <div id="fh5co-logo"><a href="../index.jsp"><img src="images/logo_small_2.png" width="64" height="64" alt="logo"></a></div>
                </div>
                <div class="col-md-6 col-xs-6 text-center menu-1">
                    <ul>
                        <li><a href="about.html">About</a></li>
                        <li><a href="services.html">Services</a></li>
                        <li class="has-dropdown">
                            <a href="product1.jsp">Shop</a>
                            <ul class="dropdown">
                                <li><a href="product1.jsp">신선식품</a></li>
                                <li><a href="product2.jsp">가공식품</a></li>
                                <li><a href="product3.jsp">디저트</a></li>
                            </ul>
                        </li>


                        <li><a href="contact.html">Contact</a></li>
                    </ul>
                </div>
                <div class="col-md-3 col-xs-4 text-right hidden-xs menu-2">
                    <ul>
                        <li class="search">
                            <div class="input-group">
                                <input type="text" placeholder="Search..">
                                <span class="input-group-btn">
						        <button class="btn btn-primary" type="button"><i class="icon-search"></i></button>
						      </span>
                            </div>
                        </li>
                        <li class="shopping-cart"><a href="#" class="cart"><span><small>0</small><i class="icon-shopping-cart"></i></span></a></li>
                        <li class="sign-up"><a href="#" class="signup"></a></li>
                        <%if(session.getAttribute("id")==null) {%>
                        <li class="sign-in"><a href="loginForm.jsp" class="signin"><span><i class="icon-login"></i></span></a></li>
                        <%} else{%>
                        <li class="sign-in"><%=session.getAttribute("id")%>님이 로그인 했습니다.<a href="logout.do" class="signin"><span><i class="icon-login"></i></span></a></li>
                        <%}%>

                    </ul>
                </div>
            </div>

        </div>
    </nav>
