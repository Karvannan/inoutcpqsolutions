var readAllObject = '';

function init() {
	addActionListeners();
	loadAllOpportunities();
}

function addActionListeners() {
	$('#createNewOpportunity').click(function() {
		//console.log('button clicked');
		window.location = 'jsp/editOpportunity.jsp';
	});
}


function loadAllOpportunities() {
	var dataTable = $('#example').dataTable();
	//console.log('body loaded');
	$.ajax({
		url: "/inoutcpqsolutions/api/opportunity/readAll",
		dataType: 'json',
		success: function(result){
			//console.log('connection success');
			dataTable.fnClearTable();
	        readAllObject = result;

	        var opportunityList = result.data.result;
	        for (var i=0;i<opportunityList.length;i++) {
	        	var opportunity = opportunityList[i];
				var editLink = '<a href=\"/inoutcpqsolutions/jsp/editOpportunity.jsp?opportunityID=' + opportunity.pkey +'\">Edit</a>';
	        	//console.log(opportunity.pkey);
	        	var deleteLink = '<a id=\"'+ opportunity.pkey +'\" href=\"javascript:deleteOpportunity(\'' + opportunity.pkey +'\')\">Delete</a>';
	        	dataTable.fnAddData([
					editLink + '|' + deleteLink,
		        	opportunity.pkey,
		        	opportunity.name,
		        	opportunity.amount,
		        	changedTimeFromJs(opportunity.closedDate),
		        	opportunity.isoCode,
		        	opportunity.description,
		        	opportunity.isClosed,
		        	opportunity.deletedFlag,
		        	opportunity.isWon
	        	]);
	        }	        
		}
	});
}


function deleteOpportunity(opportunityID) {
	//$("#dialog-confirm").dialog("open");
	var deleteOpp = confirm("Sure You want to Delete?");
	if (deleteOpp == true) {
		$.ajax({
			url : "/inoutcpqsolutions/api/opportunity/delete/" + opportunityID,
	        type: 'DELETE',
	        success: function(result) {
	        	//console.log('deleted ' + opportunityID);
				loadAllOpportunities();
	        }
	    });	    
	} else {
	    console.log('cancel');
	}
}

function changedTimeFromJs(milliDate){
	var formatedDate = new Date(new Number(milliDate));
	/*var displayDate = formatedDate.getUTCMonth()+1+'-'+formatedDate.getUTCDate()+'-'+formatedDate.getUTCFullYear()+' '+ formatedDate.toUTCString().substring(17, 26);*/
	var month = formatedDate.getUTCMonth() + 1;
	month = month<9?'0'+month:month;
	var displayDate = formatedDate.getUTCFullYear()+'-'+month+'-'+formatedDate.getUTCDate();
	return displayDate;
}