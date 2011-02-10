var multiselect = multiselect || {};

var dummyConsole = {
	log : function() {}
}

var console = console || dummyConsole;

multiselect.ping = function() {
	console.log("Hello");
}

multiselect.addTag = function(inputId) {
	var tagName = document.getElementById(inputId).value; 
	console.log("Going to add a tag called [" + tagName + "]...");
}