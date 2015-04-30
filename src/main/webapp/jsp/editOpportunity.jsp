<!DOCTYPE HTML>
<html>
	<head>
		<title>Opportunity Info</title>
		<script type="text/javascript" src="../js/editOpportunity.js"></script>
		<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
		<script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script>
    	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
		<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/themes/ui-lightness/jquery-ui.css" rel="stylesheet" type="text/css" />

    	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    	
	</head>
	<body id="opportunityBody">
	    <script>
	      document.addEventListener("DOMContentLoaded", function(e) {
	        init();
	      });
	    </script>	
		<h2><center>Opportunity Info</center></h2>		
		<br/><br/>
		<div id="opportunityIDDiv"> </div>
		<input type="hidden" name="opportunityID" id="opportunityID">
		<br/><br/>
		<div id="opportunityDiv">
			<table cellspacing="2px" width="100%">
				<tr>
					<td>Name</td>
					<td><input type="text" name="oppName" id="oppName"></td>
					<td>Amount</td>
					<td><input type="text" name="oppAmount" id="oppAmount"></td>
				</tr>
				<tr>
					<td>Closed Date</td>
					<td><input type="text" name="oppClosedDate" id="oppClosedDate"></td>
					<td>ISO Code</td>
					<td><input type="text" name="oppISOCode" id="oppISOCode"></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="oppDescription" id="oppDescription"></td>
					<td>isClosed</td>
					<td><input type="checkbox" name="oppIsClosed" id="oppIsClosed"></td>
				</tr>
				<tr>
					<td>isWon</td>
					<td><input type="checkbox" name="oppIsWon" id="oppIsWon"></td>
					<td>isDeleted</td>
					<td><input type="checkbox" name="oppIsDeleted" id="oppIsDeleted"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button type="button" class="btn btn-default my-button-style" id="saveOpportunity">Save</button>						
						<button type="button" class="btn btn-default my-button-style" id="reset">Reset</button>
						<button type="button" class="btn btn-default my-button-style" id="back">Back</button>
					</td>
				</tr>				
			</table>
		</div>
	</body>
</html>