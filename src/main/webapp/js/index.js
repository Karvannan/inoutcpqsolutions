var readAllObject = '';

function init() {
	var dataTable = $('#example').dataTable();
	console.log('body loaded');
	$.ajax({
		url: "http://localhost:8080/inoutcpqsolutions/api/opportunity/readAll",
		dataType: 'json',
		success: function(result){
			console.log('connection success');
			dataTable.fnClearTable();
	        readAllObject = result;

	        var opportunityList = readAllObject.data.result;
	        for (var i=0;i<opportunityList.length;i++) {
	        	var opportunity = opportunityList[i];
				var editLink = '<a href=\"http://localhost:8080/inoutcpqsolutions/api/opportunity/update\">Edit</a>';
	        	var deleteLink = '<a href=\"http://localhost:8080/inoutcpqsolutions/api/opportunity/delete/' + opportunity.id +'\">Delete</a>';				
	        	dataTable.fnAddData([
					editLink + '|' + deleteLink,
		        	opportunity.id,
		        	opportunity.name,
		        	opportunity.amount,
		        	opportunity.closedDate,
		        	opportunity.isoCode,
		        	opportunity.description,
		        	opportunity.closed,
		        	opportunity.deleted,
		        	opportunity.won
	        	]);
	        }	        
		}
	});
}