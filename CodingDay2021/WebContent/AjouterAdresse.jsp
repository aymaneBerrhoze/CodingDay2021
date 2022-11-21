<jsp:include page="Header.jsp"/>

<%@page import="beans.Personne" %>
<%@page import="dao.PersonneDao" %>

<% if(session.getAttribute("personne")==null){ 
        response.sendRedirect("index.jsp");} 
   	 %>



<div class="content-wrapper"> 
    <!-- Content Header (Page header) -->
    <div class="content-header sty-one">
      <h1 class="text-black">Gestion des Adresses</h1>
      <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><i class="fa fa-angle-right"></i> Ajouter </li>
      </ol>
    </div>
    
    <!-- Main content -->
    <div class="content">
      <div class="info-box">
        <h4 class="text-black">Ajouter une adresse</h4>
        <form action="AjouterAdresse" method="post">
        <div class="row">
          
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Id Personne</label>
              <input class="form-control" id="readonlyInput" value="${id.idPersonne }" name="idPerso" readonly  type="text">
            </fieldset>
          </div>
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Rue</label>
              <input class="form-control" id="basicInput" name="rue" minlength="2"  type="text" required>
            </fieldset>
          </div>
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Code Postal</label>
              <input class="form-control" id="basicInput" pattern="[0-9]{5}" name="codePostal" type="text">
            </fieldset>
          </div>
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Ville</label>
              <input class="form-control" id="basicInput" name="ville" minlength="2" type="text">
              
            </fieldset>
          </div>
          <button id="save" class="btn btn-success" onclick="save()" type="submit">Save</button>
          
          </div>
          </form>
          </div>
          </div>
          </div>
          
          
          
          




<jsp:include page="Footer.jsp"/>
