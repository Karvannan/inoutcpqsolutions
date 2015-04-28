<!DOCTYPE HTML>
<html>
	<head>
		<title>InOut Corporation Opportunity Manager</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
    	<script type="text/javascript" src="js/index.js"></script>
    	<script type="text/javascript" src="js/jquery.js"></script>	
    	<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js">
    	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    	
	</head>
	<body id="indexBody">
	    <script>
	      document.addEventListener("DOMContentLoaded", function(e) {
	        init();
	      });
	    </script>	
		<h2><center>InOut Corporation CPQ Solutions</center></h2>		
		<br/><br/>
		<button type="button" class="btn btn-default my-button-style" id="createNewOpportunity">New Opportunity</button>
		<br/><br/>
		<div id="readAll">
			<table id="example" cellspacing="0" width="100%">
			        <thead>
			            <tr>
							<th>Action</th>
			                <th>Id</th>
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
