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
		  url: "/1/AjaxTransaction?id=" + id + "&page=" + page,
		  dataType: 'text',
		  contentType: "application/json",
		  success: function( data ) {
			var html = "";
			var donnee = JSON.parse( data );
			
			$("tr.pagination").remove();
			
			for (i = 0; i < donnee.length; i++) { 
				html += "<tr class='pagination'>"
			    html += "<td> <fmt:message key='transaction_numero'/> : " + donnee[i].id + "</td>";
				html += "<td>" + donnee[i].montant + "</td>";
				html += "<td>" + donnee[i].date + "</td>";
				html += "</tr>"
			}
			
			$("#page").replaceWith("<div id='page'>" + page +  "</div>");
			$("#row").after(html);
		  	console.log(data);
		  	console.log(html);
		  	
		  },
		  error: function(data,status,er) {
		    alert("error : "+ data +" status : "+ status +" err :"+er);
		   }
		 });
}