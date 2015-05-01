var errorObj = '';

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
				$('#opportunityIDDiv').css({ 'color': 'green', 'font-size': '125%' });
				$.ajax({
						url: "/inoutcpqsolutions/api/opportunity/read?id=" + opportunityID,
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
		saveOpportunity();
		window.location = '/inoutcpqsolutions/jsp/editOpportunity.jsp';
	});
	$('#back').click(function() {
		window.location = '/inoutcpqsolutions';
	});
}



function saveOpportunity() {

	if (!/^[0-9]{1,10}$/.test($('#oppAmount').val())) {
		$('#opportunityIDDiv').text('Field - Amount should be number');
		$('#opportunityIDDiv').css({ 'color': 'red', 'font-size': '125%' });		
		return;
	}

	var url = "/inoutcpqsolutions/api/opportunity/upsert";

	var opportunityInfo = new Object();

	if ($('#opportunityID').text()) {
		url = "/inoutcpqsolutions/api/opportunity/upsert";
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
			/*if ($('#opportunityID').text()) {
				$('#opportunityIDDiv').text('Opportunity Saved Successfully. Opportunity ID - ' + msg.data.result.id);
			} else {
				$('#opportunityIDDiv').text('Opportunity Created Successfully. Opportunity ID - ' + msg.data.result.id);
			}*/
			$('#opportunityIDDiv').text('Opportunity Saved Successfully. Opportunity ID - ' + msg.data.result.id);
			$('#opportunityIDDiv').css({ 'color': 'green', 'font-size': '125%' });
			$('#opportunityID').text(msg.data.result.id);
			
			// console.log(msg.data.result.id);
		},
		error : function(jqXHR, textStatus, error) {			
			$('#opportunityIDDiv').text(error + ' - ' + jqXHR.responseText);
			$('#opportunityIDDiv').css({ 'color': 'red', 'font-size': '125%' });
			console.log(error);
			console.log(textStatus);
			errorObj = jqXHR.responseText;
			console.log(jqXHR);
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