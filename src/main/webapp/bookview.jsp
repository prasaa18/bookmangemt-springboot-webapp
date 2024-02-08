<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="ISO-8859-1">
   <meta name="viewport" content="width=device-width, initial-scale=1">
     <%@ page isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
 <title>Admin login </title>





<style type="text/css">
body{

   height: 100vh;
    width: 100%;
    background-size: cover;
    background-position: center;
  background-image: url("images/3.jpg");

}
 .container{
 
    
    margin-left: 130px;
    margin-top: 130px;
    
  }
.logoutbutton{
margin-top:40px;
margin-right:60px;
}
</style>
</head>
<body>

<br>
  <div class="container">
      <div class="card" style="height:60px">
       <div class="card-header" style="height:60px">
            <h3 style="text-align:center">Web Shop</h3>
  </div>
  </div>
  <br>
       <table class="table table-dark table-striped">
       <caption>BOOKS</caption>
       
          <thead class="table-dark">
          <tr>
           <th scope="col" style="text-align: center">ID</th> 
             <th scope="col" style="text-align:center" >BookName</th>
              <th scope="col" style="text-align:center" >BookPrice</th>
               <th scope="col" style="text-align:center" >Quantity</th>
                <th scope="col" style="text-align:center" >Discription</th>
               
                <th scope="col" style="text-align:center">Action</th>
                 <th scope="col" style="text-align:center">Action</th>
         </tr>
           </thead>   
           
               <tbody>
                   <c:forEach items="${booklist}" var="book">
                      <tr>
                        <td  style="text-align: center">${book.id }</td>
                         <td  style="text-align: center">${book.bookname }</td>
                          <td  style="text-align: center">${book.bookprice }</td>
                           <td  style="text-align: center">${book.quantity}</td>
                            <td  style="text-align: center">${book.discription}</td>
                            
                            
                            <td class="table-dark" style="text-align: center"><a href="deletetebyid?hid=${book.getId()}" 
                             role="button" class="btn btn-success">DELETE</a>
                              <td class="table-dark" style="text-align: center"><a href="updatebyid?fid=${book.getId()}" 
                             role="button" class="btn btn-success">update</a>
                              
                            
                           </td>
                            
                            
                           
                        </tr>
                        
                      
               </c:forEach>
               </tbody>
               
       </table>
       
       <div style="text-align:center;">
          <a href="/addnew" role="button" class="btn btn-info"><strong>ADD NEW STOCK</strong></a>
  </div>
  <br>
  <br>
  <div style="text-align:center;">
          <a href="/" role="button" class="btn btn-info"><strong>LOGOUT OR RETURN BACK TO HOME PAGE</strong></a>
  </div>
  </div>
  
 
</body>
</html>