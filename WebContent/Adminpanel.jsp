<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style><%@include file="/css/style.css"%></style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
    <header>
        <div class="header_groupe">
                <h1 class="Logo">SBAHIA</h1>
               <nav>
                   <ul>
                      <li> <a href="Deconnexion">Sign up</a></li>
                   </ul>
               </nav>
            </div>
    </header>
    <section class="section-admin">

    
    <div class="main_container">

        <div class="container admin">
            <div class="search">
            <form class="form-search" action="search.test" method="Get">
                <input type="text" name="motCle" class="search-txt"/>
                <input type="submit" class="btn-search" value="Search"/>
            </form>
                <a type="submit" class="btn-Add" href="Add_product.test"><i><img src="img/Add.png"></i>Add</a>
                </div>
            <div class="row">
                <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                    <th>Image</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Fonction</th>
                    </tr>
                </thead>
                <tbody> 

  <c:forEach items="${product}" var="p" varStatus="status">
    
    <tr>
        <td>  <img src="data:image/*;base64,${images[status.index]}" class="circle">  </td>
     <td class="column-title">${p.title}  </td>
     <td>${p.prix}DH </td>
<td class="column-img">
<a class="btn-Modifier" href="Edit.test?id=${p.id}" > Update <img src="img/Icon-update.png"> </a>
<a class="btn-Supprimer" onclick="return confirm('Etes vous sure?')" href="Delete.test?id=${p.id}"> Delete <img src="img/Icondelete.png"> </a>
</td>
    </tr>
    
    </c:forEach>

 
                </tbody>
                </table>
                
                
            </div>
            
            
            </div>
      </div>
    </section>
    
    
    <footer >
        <p>Copyright 2021</p>
    </footer>
</body>
</html>