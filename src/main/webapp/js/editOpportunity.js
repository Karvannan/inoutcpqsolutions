function init() {
	addActionListeners();
}


function addActionListeners() {
	$('#saveOpportunity').click(function() {
		saveOpportunity();
	});
	$('#reset').click(function() {
		location.reload();
	});
	$('#back').click(function() {
		window.location = 'http://localhost:8080/inoutcpqsolutions';
	});
}



function saveOpportunity() {
	var url = "http://localhost:8080/inoutcpqsolutions/api/opportunity/create";

	var opportunityInfo = new Object();

	if ($('#opportunityID').text()) {
		url = "http://localhost:8080/inoutcpqsolutions/api/opportunity/update";
		opportunityInfo.id = $('#opportunityID').text();
	}
	
	opportunityInfo.name = $('#oppName').val();
	opportunityInfo.description = $('#oppDescription').val();
	opportunityInfo.closed = true;
	opportunityInfo.deleted = true;
	opportunityInfo.won = true;
	opportunityInfo.amount = $('#oppAmount').val();
	opportunityInfo.closedDate = $('#oppClosedDate').val();
	opportunityInfo.isoCode = $('#oppISOCode').val();
	console.log(JSON.stringify(opportunityInfo));
	$.ajax({
		url : url,
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(opportunityInfo),
        contentType: 'application/json',
		success : function(msg) {
			$('#opportunityID').text(msg.data.result.id);
			$('#opportunityIDDiv').text('Opportunity Created Successfully. Opportunity ID - ' + msg.data.result.id);
			console.log(msg.data.result.id);
		},
		error : function(jqXHR, textStatus, error) {
			console.log(error);
			console.log(textStatus);
			console.log(jqXHR);
		}
	});

}