function init() {
	$( "#oppClosedDate" ).datepicker({dateFormat: 'yy-mm-dd'});
	checkForQueryParameter();
	addActionListeners();
}

function checkForQueryParameter() {
	if (location.search && location.search.substring(1) && location.search.substring(1).split("&")) {
		var parameters = location.search.substring(1).split("&");
		if (parameters[0] && parameters[0].split("=")) {
		    var opportunityIDPair = parameters[0].split("=");
		    var opportunityID = unescape(opportunityIDPair[1]);
			if (opportunityID == 'undefined' || opportunityID == 'null' || opportunityID == '' || opportunityID == "") {
				// // console.log('Create Request');
			} else {
				$('#opportunityID').text(opportunityID);
				$('#opportunityIDDiv').text('Opportunity ID - ' + opportunityID);
				$.ajax({
						url: "http://localhost:8080/inoutcpqsolutions/api/opportunity/read?id=" + opportunityID,
						dataType: 'json',
						success: function(result){							
							$('#oppName').val(result.data.result.name);
							$('#oppDescription').val(result.data.result.description);
							if (result.data.result.isWon) 
								$('#oppIsWon').prop('checked', true);
								/*document.getElementById('oppIsWon').setAttribute('checked','checked');*/
							if (result.data.result.isClosed) 
								$('#oppIsClosed').prop('checked', true);
								/*document.getElementById('oppIsClosed').setAttribute('checked','checked');*/
							if (result.data.result.isDeleted) 
								$('#oppIsDeleted').prop('checked', true);
								/*document.getElementById('oppIsDeleted').setAttribute('checked','checked');*/
							$('#oppAmount').val(result.data.result.amount);
							$('#oppClosedDate').val(changedTimeFromJs(result.data.result.closedDate));
							$('#oppISOCode').val(result.data.result.isoCode);
						}
					});
			}
		}
	}
}



function addActionListeners() {
	$('#saveOpportunity').click(function() {
		saveOpportunity();
	});
	$('#reset').click(function() {
		window.location = 'http://localhost:8080/inoutcpqsolutions/jsp/editOpportunity.jsp';
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
	opportunityInfo.isClosed = $('#oppIsClosed').attr('checked')?true:false;
	opportunityInfo.isDeleted = $('#oppIsDeleted').attr('checked')?true:false;
	opportunityInfo.isWon = $('#oppIsWon').attr('checked')?true:false;
	opportunityInfo.amount = $('#oppAmount').val();
	opportunityInfo.closedDate = $('#oppClosedDate').val();
	opportunityInfo.isoCode = $('#oppISOCode').val();
	// console.log(JSON.stringify(opportunityInfo));
	$.ajax({
		url : url,
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(opportunityInfo),
        contentType: 'application/json',
		success : function(msg) {
			if ($('#opportunityID').text()) {
				$('#opportunityIDDiv').text('Opportunity Updated Successfully. Opportunity ID - ' + msg.data.result.id);
			} else {
				$('#opportunityIDDiv').text('Opportunity Created Successfully. Opportunity ID - ' + msg.data.result.id);
			}
			$('#opportunityID').text(msg.data.result.id);
			
			// console.log(msg.data.result.id);
		},
		error : function(jqXHR, textStatus, error) {
			// console.log(error);
			// console.log(textStatus);
			// console.log(jqXHR);
		}
	});

}



function changedTimeFromJs(milliDate){
	var formatedDate = new Date(new Number(milliDate));
	/*var displayDate = formatedDate.getUTCMonth()+1+'-'+formatedDate.getUTCDate()+'-'+formatedDate.getUTCFullYear()+' '+ formatedDate.toUTCString().substring(17, 26);*/
	var month = formatedDate.getUTCMonth() + 1;
	month = month<9?'0'+month:month;
	var displayDate = formatedDate.getUTCFullYear()+'-'+month+'-'+formatedDate.getUTCDate();
	return displayDate;
}