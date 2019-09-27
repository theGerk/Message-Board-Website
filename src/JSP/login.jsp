<html>
<body>
<h2>Log-in</h2>
<input type="text" id="usernameInput">
<input type="text" id="passwordInput">
<button id="loginButton">Log in</button>
<p id="message"></p>
<script>
document.getElementById("loginButton").addEventListener("click", showInput);
function showInput() {
  document.getElementById("message").innerHTML
   = "Username: " + document.getElementById( "usernameInput" ).value
   + " Password: " + document.getElementById( "passwordInput" ).value;
}
</script>
</body>
</html> 
