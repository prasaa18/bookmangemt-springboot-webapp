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
  background-image: url("images/9.png");

}
 .container{
   
    margin-top: 150px;
    
  }
  .card
  { 
    width:90px;
  }
  </style>





</head>

<div class="container" >
    <div class="card" style="width:20cm;">
    
       <div class=" card-header" style="align-content: center;">
       <strong>ADD NEW DETAILS</strong>
       
       </div>
       
          <div class="card-body">
             <form action="/save" >
             
                 <div class="row mb-3">
                   <label class="col-sm-2 col-form-label"><strong>ID</strong></label>
                     <div class="col-sm-10">
                      <input type="text" class="form-control" id="id" name="id" value=" <c:out value="${product.id}"></c:out>"placeholder="Enter ID">
                        </div>
                        </div>
                        
                        
                        <div class="row mb-3">
                   <label class="col-sm-2 col-form-label"><strong>BOOK NAME</strong></label>
                     <div class="col-sm-10">
                      <input type="text" class="form-control" id="bookname" name="bookname" value="<c:out value="${product.bookname}"></c:out>"placeholder="Enter the name">
                        </div>
                     </div>
                     
                     
                     <div class="row mb-3">
                   <label class="col-sm-2 col-form-label"><strong>BOOK PRICE</strong></label>
                     <div class="col-sm-10">
                      <input type="text" class="form-control" id="bookprice" name="bookprice" value="<c:out value="${product.bookprice}"></c:out>"placeholder="Enter the  price">
                        </div>
                     
                     </div>
                 
                       
                     <div class="row mb-3">
                   <label class="col-sm-2 col-form-label"><strong>QUANTITY</strong></label>
                     <div class="col-sm-10">
                      <input type="text" class="form-control" id="quantity" name="quantity"  value="<c:out value="${product.quantity}"></c:out>"placeholder="Enter the quantity">
                        </div>
                     
                     </div>
                     
                        
                     <div class="row mb-3">
                   <label class="col-sm-2 col-form-label"><strong>DISCRIPTION</strong></label>
                     <div class="col-sm-10">
                      <input type="text" class="form-control" id="discription" name="discription" value="<c:out value="${product.discription}"></c:out>"placeholder="Enter the  discription">
                        </div>
                     
                     </div>
                   <button type="submit" class="btn btn-success" style="align-content: center;">
                   
                   <strong>STORE</strong></button>
                 
          </form>
</div>
</div>
</div>
</body>
</html>