<html>
	<head>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
	  		$(document).on( "click", "#myButton", function() {
	  			$.get( "homePageServlet", function( responseJson ) {
	  				var $ul = $( "<ul>" ).appendTo( $( "#myDiv" ) );
	  				$.each( responseJson, function( index, item ) {
	  					$( "<li>" ).text( item ).appendTo( $ul );
	  				});
	  			});
	  		});
	  	</script>
	<head>
	<body>
		<button id="myButton">Click for AJAX</button>
		<div id="myDiv"></div>
	</body>
</html>
