/**
 * 
 */
function validation_Leave_Apply() {
	var username = document['leave_apply']['username'].value;
	var password = document['leave_apply']['password'].value;
		if (username == "") {
		alert("username should be filled");
		return false;

	}
	if (username != "") {
		var username_reg = /^[a-zA-Z0-9\_]+$/;
		if (!username.match(username_reg)) {
			alert("username must contain 5 to 10 letter with _");
			return false;
		}
	}
	if(password == ""){
	 alert("password should be filled");
	return false;
	}
	if (password != "") {
		var password_reg = /^[a-zA-Z0-9!@#$%^&*_]{6,16}$/;
		if (!password.match(password_reg)) {
			alert("password should be 8 to 16");
			return false;
		}
	}
	return true;
}