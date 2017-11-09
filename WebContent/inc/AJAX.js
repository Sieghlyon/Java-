/**

 * 
 */

$(document).ready(function() {
	AJAX();
});

function nextPage(){
	page += 1;
	AJAX();
}

function previousPage(){
	page -= 1;
	if(page < 0){
		page = 0;
	}
	AJAX();
}


function AJAX(){
	$.ajax({
		  type: 'GET',
		  url: "/1/Ajax?id=" + id + "&page=" + page,
		  dataType: 'text',
		  contentType: "application/json",
		  success: function( data ) {
			var html = "";
			var donnee = JSON.parse( data );
			
			$("tr.pagination").remove();
			
			for (i = 0; i < donnee.length; i++) { 
				html += "<tr class='pagination'>"
			    html += "<td> <fmt:message key='virement_numero'/> : " + donnee[i].id + "</td>";
				html += "<td>" + donnee[i].montant + "</td>";
				html += "<td>" + donnee[i].libelle + "</td>";
				html += "</tr>"
			}
			
			$("#page").replaceWith("<div id='page'>" + page +  "</div>");
			$("#row").after(html);
		  	console.log(html);
		  	console.log(page);
		  	
		  },
		  error: function(data,status,er) {
		    alert("error : "+ data +" status : "+ status +" err :"+er);
		   }
		 });
}