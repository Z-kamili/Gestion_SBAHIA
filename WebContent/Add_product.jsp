<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/style_Admin.css">
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
        <section>
            <div class="Success"> <span>${succes}</span> </div>
             <div class="Erreur"> <span>${erreur}</span> </div>
            <div class="Generale">
                <form action="Add_product.test" method="post" enctype="multipart/form-data">
                    <h1>Add Product</h1>
                    <div class="block-input-1"><input type="text" name="title" placeholder="title" required /></div>
                    <div class="block-input-2"><input  type="number" name="price" placeholder="Price" required /></div>   
                    <div class="block-input-3">
                        <input type="file" class="file" name="image" accept="image/*" required  />
                    </div>
                    <div class="block-input-btn"><input type="submit" value="Add"  /></div>
                </form>
                <div class="img-upload-1"></div>

            </div>

        </section>

        <footer class="footer-page-admin">
            <p>Copyright 2021</p>
        </footer>
</body>
</html>