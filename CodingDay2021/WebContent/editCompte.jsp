<jsp:include page="Header.jsp"/>

<%@page import="beans.Personne" %>
<%@page import="dao.PersonneDao" %>

<% if(session.getAttribute("personne")==null){ 
        response.sendRedirect("index.jsp");} 
   	 %>
<%
	String id = request.getParameter("id");
    PersonneDao c = new PersonneDao();
    
    Personne cc = c.findById(Integer.parseInt(id));
%>



<div class="content-wrapper"> 
    <!-- Content Header (Page header) -->
    <div class="content-header sty-one">
      <h1 class="text-black">Gestion Compte</h1>
      <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><i class="fa fa-angle-right"></i> modifier</li>
      </ol>
    </div>
    
    <!-- Main content -->
    <div class="content">
      <div class="info-box">
        <h4 class="text-black">compte</h4>
        <form action="update" method="post">
        <div class="row">
          
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Id</label>
              <input class="form-control" id="readonlyInput" value="<%= cc.getIdPersonne()%>" name="id" readonly  type="text">
            </fieldset>
          </div>
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Prenom</label>
              <input class="form-control" id="basicInput" name="prenom" value="<%= cc.getPrenom()%>" type="text">
            </fieldset>
          </div>
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Nom</label>
              <input class="form-control" id="basicInput" name="nom" value="<%= cc.getNom()%>" type="text">
            </fieldset>
          </div>
          <div class="col-lg-4">
            <fieldset class="form-group">
              <label>Sexe</label>
              <select class="form-control" id="basicInput" name="sexe">
              <option value="<%= cc.getSexe()%>" disabled>${cc.getSexe()}</option>
              <option>M</option>
              <option>F</option>
              </select>
            </fieldset>
          </div>
          <button id="save" class="btn btn-success" onclick="save()" type="submit">Save</button>
          
          </div>
          </form>
          </div>
          </div>
          </div>
          
          
          
          




<jsp:include page="Footer.jsp"/>
