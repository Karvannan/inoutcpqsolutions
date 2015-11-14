<!DOCTYPE HTML>
<html>
	<head>
		<title>InOut Corporation Opportunity Manager</title>
		<script type="text/javascript" src="js/index.js"></script>
		<script type="text/javascript"  src="js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript"  src="js/jquery-migrate-1.2.1.min.js"></script>
    	<script type="text/javascript" charset="utf8" src="js/jquery.dataTables.min.js"></script>
    	<script type="text/javascript" src="js/bootstrap.min.js"></script>		
		<script type="text/javascript" src="js/jquery-ui-1.10.3.min.js"></script>		
		
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
		<link href="css/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" type="text/css" />    			
    	
	</head>
	<body id="indexBody">
	    <script>
	      document.addEventListener("DOMContentLoaded", function(e) {
	        init();
	      });
	    </script>	
		<h2><center>Manage Opportunities</center></h2>		
		<br/><br/>
		<button type="button" class="btn btn-default my-button-style" id="createNewOpportunity">Add New</button>
		<br/><br/>
		<div id="readAll">
			<table id="example" cellspacing="0" width="100%">
			        <thead>
			            <tr>
							<th>Action</th>
			                <th>Opportunity ID</th>
			                <th>Name</th>
			                <th>Amount</th>
			                <th>Closed Date</th>
			                <th>ISO Code</th>
			                <th>Description</th>
			                <th>Closed</th>
			                <th>Deleted</th>
			                <th>Won</th>
			            </tr>
			        </thead>
			    </table>

		</div>
	</body>
</html>
