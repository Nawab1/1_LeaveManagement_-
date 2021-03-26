/**
 * 
 */
function validation_admin(){
		var username = document['admin']['username_admin'].value;
	var password = document['admin']['password_admin'].value;
		if (username == "") {
		alert("username should be filled");
		return false;

	}
	if (username != "") {
		var username_reg = /^[a-zA-Z]+$/;
		if (!username.match(username_reg)) {
			alert("insert username of admin");
			return false;
		}
	}
	if(password == ""){
	 alert("password should be filled");
	return false;
	}
	if (password != "") {
		var password_reg = /^[a-zA-Z]+$/;
		if (!password.match(password_reg)) {
			alert("insert password of admin");
			return false;
		}
	}
	return true;
}