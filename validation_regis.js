/**
 * 
 */
function validation() {
	var name = document.forms['registration']['name'].value;
	var last = document.forms['registration']['last'].value;
	var password = document.forms['registration']['password'].value;
	var dob = document.forms['registration']['dob'].value;
	var dpment = document.forms['registration']['dpment'].value;
	var username = document.forms['registration']['username'].value;
	if (name == "") {
		alert("name should be filled");
		return false;
	}
	if (name != "") {
		var name_reg = /^[A-Za-z]+$/;
		if (!name.match(name_reg)) {
			return false;
		}
	}
	if (last == "") {
		alert("last name should be filled");
		return false;
	}
	if (last != "") {
		var last_reg = /^[A-Za-z]+$/;
		if (!last.match(last_reg)) {
			return false;
		}
	}
	if (dpment == "") {
		alert("department should be filled");
		return false;
	}
	if (dpment != "") {
		var dpment_reg = /^[A-Za-z]+$/;
		if (!dpment.match(dpment_reg)) {
			alert("not contain special character");
			return false;
		}

	}
	if (dob == "" || dob == null) {
		alert("date should be filled");
		return false;
	}
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