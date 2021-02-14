<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Document</title>
</head>
<body>
    <header>
        <div class="header_groupe">
                <h1 class="Logo">SBAHIA</h1>
               <nav>
                   <ul>
                      <li> <a href="Deconnexion">Deconnect</a></li>
                   </ul>
               </nav>
        </div>

       
    </header>
    
    <section>
  <!-- <p>${sessionScope.sessionUtilisateur.email}</p> -->  
        <div class="Container">
         <c:forEach items="${product}" var="p" varStatus="status">
            <div class="card">
                <div class="card-div">
            
                    <div class="img_prdt">
                        <img src="data:image/*;base64,${images[status.index]}">
                    </div>
                    <div class="Desc"> ${p.title}</div>
                    <div class="Desc"> ${p.prix}DH</div>
                    <div>${num_vote[status.index]} <i><img src="img/Icon-heart.png"></i></div>
                    <p></p>
                   <div class="btn-add"><a href="Add_Fav.test_2?id=${p.id}">Favorite</a></div> 
                </div>
            </div>
         </c:forEach>
        </div>


    </section>
    <footer >
        <p>Copyright 2021</p>
    </footer>
</body>
</html>