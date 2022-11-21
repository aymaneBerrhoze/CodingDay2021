<jsp:include page="Header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<% if(session.getAttribute("personne")==null){ 
        response.sendRedirect("index.jsp");} 
   	 %>
<div class="content-wrapper"> 
    <!-- Content Header (Page header) -->
    <div class="content-header sty-one">
      <h1 class="text-black">Gestion du compte</h1>
      <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><i class="fa fa-angle-right"></i> compte</li>
      </ol>
    </div>
<div class="content">
      <div class="info-box">
      
      <div class="table-responsive">
                  <table id="example2" class="table table-bordered table-hover" data-name="cool-table">
                    <thead>
                      <tr>
                        <th>ID Adresse </th>
                        <th>Rue</th>
                        <th>Code Postal</th>
                        <th>Ville</th>
                        
                      </tr>
                    </thead>
                    <c:forEach items="${AdressesnonAssociees}" var="f">	
                    <tbody>
                      <tr>
                        <td>${ f.idAdresse}</td>
                        <td>${ f.getRue()}</td>
                        <td>${ f.getCodePostal()}</td>
                        <td>${ f.getVille()}</td>
                        
                      </tr>
                     </tbody>
                     </c:forEach>
                      
                      
                    
                  </table>
                  </div>
      </div>
    </div>
    </div>
    

<jsp:include page="Footer.jsp"/>