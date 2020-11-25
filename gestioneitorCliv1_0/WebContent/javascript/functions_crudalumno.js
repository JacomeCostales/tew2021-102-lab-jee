//Clase que contiene el Modelo de la aplicación.
function Model(){
	
	$(function() {
		 //Creamos el modelo con los datos y la conexión al servicio web.
		 var model = new Model();
		 model.load();
		})
	
	//Lista de alumnos.
	this.tbAlumnos = null;
	
	// Carga los datos del servicio sobreescribiendo el dato this.tbAlumnos.
	 this.load = function() {
		 this.tbAlumnos = AlumnosServicesRs.getAlumnos();
	 }
	 
	 // Llamamos al servicio de alta de alumno
	 this.add = function(alumno) {
		 // Llamamos al servicio de alta de alumno
		 AlumnosServicesRs.saveAlumno({$entity : alumno,$contentType : "application/json"});
		 // Recargamos la lista de alumnos.
		 this.load();
	 }
	 // Actualización de un alumno existente: PENDIENTE DE IMPLEMENTAR
	 this.edit = function(alumno) {
		 AlumnosServicesRs.updateAlumno({$entity : alumno,$contentType : "application/json"});
		 this.load();
	 } 
	
	 
	// Eliminación un alumno existente
	 this.remove = function(id_alumno) {
		 // Llamamos al servicio de borrado de alumno
		 AlumnosServicesRs.deleteAlumno({id : id_alumno});
		 
		 // Recargamos la lista de alumnos.
		 this.load();
	 }
	 this.find = function(id_alumno) {
		 function checkAlumno(obj) {
			 return obj.id == id_alumno;
		 }
		 
		 // Buscamos los datos del alumno cuyo id_alumno sea el mismo que el
		 // seleccionado
		 var alumno = this.tbAlumnos.find(checkAlumno);
		 return alumno;
	 }
	
};
//Clase que contiene la gestión de la capa Vista
function View(){
	 this.list = function (lista) {
		 $("#tblList").html("");
		 $("#tblList").html( "<thead>" + "<tr>" + "<th></th>" + "<th>ID</th>" + "<th>IDUser</th>" + "<th>Nombre</th>" + "<th>Apellidos</th>" + "<th>Email</th>" + "</tr>" + "</thead>" + "<tbody>" + "</tbody>");
		 
		 for ( var i in lista) {
			 var alumno = lista[i];
			 $("#tblList tbody").append("<tr> <td>" + "<img src='icons/edit.png' class='btnEdit'/>" + "<img src='icons/delete.png' class='btnDelete'/> </td>" 
			 + "<td>" + alumno.id + "</td>" + "<td>" + alumno.iduser + "</td>" + "<td>" + alumno.nombre + "</td>" + "<td>" + alumno.apellidos + "</td>" + "<td>" + alumno.email + "</td></tr>");
		 }
	 } // PENDIENTE DE IMPLEMENTAR
	 
	 this.loadAlumnoFromForm = function () {} // PENDIENTE DE IMPLEMENTAR
	 
	 this.loadAlumnoInForm = function (alumno) {} // PENDIENTE DE IMPLEMENTAR
	 
	 this.getIdAlumno = function(celda) {} // PENDIENTE DE IMPLEMENTAR
};

