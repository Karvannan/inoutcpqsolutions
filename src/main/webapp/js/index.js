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
	        	dataTable.fnAddData([
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

	/*$('#example').dataTable({
        "ajax": "http://localhost:8080/inoutcpqsolutions/api/opportunity/readAll"
    });	*/
    /*$.ajax({url: "http://localhost:8080/inoutcpqsolutions/api/opportunity/readAll", success: function(result){        
        readAllObject = result;

        var opportunityList = readAllObject.data.result;

        var table = $('#example');
        for (var i=0;i<opportunityList.length;i++) {
        	var tableRowBuilt = '<tr>';

        	var opportunity = opportunityList[i];
        	
        	tableRowBuilt += '<td> '+ opportunity.id +'</td>';
        	tableRowBuilt += '<td> '+ opportunity.name +'</td>';
        	tableRowBuilt += '<td> '+ opportunity.amount +'</td>';
        	tableRowBuilt += '<td> '+ opportunity.closedDate +'</td>';
        	tableRowBuilt += '<td> '+ opportunity.isoCode +'</td>';
        	tableRowBuilt += '<td> '+ opportunity.description +'</td>';
        	tableRowBuilt += '<td> '+ opportunity.closed +'</td>';        	
        	tableRowBuilt += '<td> '+ opportunity.deleted +'</td>';
        	tableRowBuilt += '<td> '+ opportunity.won +'</td>';       	



        	
        	console.log('name ' + opportunity.name);
        	console.log('amount ' + opportunity.amount);
        	console.log('id ' + opportunity.id);
        	console.log('closedDate ' + opportunity.closedDate);
        	console.log('isoCode ' + opportunity.isoCode);
        	console.log('won ' + opportunity.won);
        	console.log('description ' + opportunity.description);
        	console.log('deleted ' + opportunity.deleted);
        	console.log('closed ' + opportunity.closed);

        	tableRowBuilt += '</tr>';
        	table.append(tableRowBuilt);
        }
    }});*/

}