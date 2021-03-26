/**
 * 
 */
function validation_leave() {
	var datef = document.forms['leave_apply']['fdate'].value;
	var datet = document.forms['leave_apply']['tdate'].value;
	var comment = document.forms['leave_apply']['comment'].value;
	if (datef == "" || datef == null) {
		alert("date should be filled");
		return false;
	}
		if (datet == "" || datet == null) {
		alert("date should be filled");
		return false;
	}
	if(comment == "" || comment == null) {
		alert("comment must be filled");
		return false;
	}
	if(comment.length <3){
		alert("length must be 3 or more");
		return false;
	}
	return true;
}