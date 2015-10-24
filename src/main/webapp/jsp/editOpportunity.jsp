<!DOCTYPE HTML>
<html>
	<head>
		<title>Opportunity Info</title>
		<script type="text/javascript"  src="../js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript"  src="../js/jquery-migrate-1.2.1.min.js"></script>
    	<script type="text/javascript" charset="utf8" src="../js/jquery.dataTables.min.js"></script>
    	<script type="text/javascript" src="../js/bootstrap.min.js"></script>		
		<script type="text/javascript" src="../js/jquery-ui-1.10.3.min.js"></script>		
		<script type="text/javascript" src="../js/editOpportunity.js"></script>		
		
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">

		<link href="../css/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" type="text/css" />    			
  	
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
						<button type="button" class="btn btn-default my-button-style" id="reset">Save & New</button>
						<button type="button" class="btn btn-default my-button-style" id="delete">Delete</button>
						<button type="button" class="btn btn-default my-button-style" id="back">Back</button>
					</td>
				</tr>				
			</table>
		</div>
	</body>
</html>