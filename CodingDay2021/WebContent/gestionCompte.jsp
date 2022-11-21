<jsp:include page="Header.jsp"/>

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
                        <th>ID </th>
                        <th>Prenom</th>
                        <th>Nom</th>
                        <th>Sexe</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>${ idPersonne.getIdPersonne()}</td>
                        <td>${ idPersonne.getPrenom()}</td>
                        <td>${ idPersonne.getNom()}</td>
                        <td>${ idPersonne.getSexe()}</td>
                        <td>
                        
                        <a class="fa fa-edit" href="editCompte.jsp?action=edit&id=${idPersonne.getIdPersonne()}"> </a>
                        <a class="fa fa-trash-o" href="supprimerPerso?id=${idPersonne.getIdPersonne()}" onclick="return confirm('Are you sure you want to delete this item?');"></a>
                        </td>
                      </tr>
                     
                      
                      
                    
                  </table>
                  </div>
      </div>
    </div>
    </div>
    

<jsp:include page="Footer.jsp"/>