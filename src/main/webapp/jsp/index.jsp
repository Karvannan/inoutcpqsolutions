<!DOCTYPE HTML>
<html>
	<head>
		<title>InOut Corporation Opportunity Manager</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
    	<script type="text/javascript" src="js/index.js"></script>
		<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
		<script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script>
    	<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js">
    	<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
		<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/themes/ui-lightness/jquery-ui.css" rel="stylesheet" type="text/css" />    	
    	
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
