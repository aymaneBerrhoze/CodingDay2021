<jsp:include page="Header.jsp"/>

<%@page import="beans.Adresse" %>
<%@page import="dao.AdresseDao" %>

<% if(session.getAttribute("personne")==null){ 
        response.sendRedirect("index.jsp");} 
   	 %>
<%
	String id = request.getParameter("id");
    AdresseDao c = new AdresseDao();
    
    Adresse cc = c.findById(Integer.parseInt(id));
%>



<div class="content-wrapper"> 
    <!-- Content Header (Page header) -->
    <div class="content-header sty-one">
      <h1 class="text-black">Gestion Adresse</h1>
      <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><i class="fa fa-angle-right"></i> modifier</li>
      </ol>
    </div>
    
    <!-- Main content -->
    <div class="content">
      <div class="info-box">
        <h4 class="text-black">adresses</h4>
        <form action="updateAdresse" method="post">
        <div class="row">
          
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Id</label>
              <input class="form-control" id="readonlyInput" value="<%= cc.getIdAdresse()%>" name="id" readonly  type="text">
            </fieldset>
          </div>
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Rue</label>
              <input class="form-control" id="basicInput" name="rue" value="<%= cc.getRue()%>" type="text">
            </fieldset>
          </div>
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Code Postal</label>
              <input class="form-control" id="basicInput" name="codePostal" value="<%= cc.getCodePostal()%>" type="text">
            </fieldset>
          </div>
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Ville</label>
              <input class="form-control" id="basicInput" value="<%= cc.getVille()%>" name="ville">
              
            </fieldset>
          </div>
          <button id="save" class="btn btn-success" onclick="save()" type="submit">Save</button>
          
          </div>
          </form>
          </div>
          </div>
          </div>
          
          
          
          




<jsp:include page="Footer.jsp"/>
