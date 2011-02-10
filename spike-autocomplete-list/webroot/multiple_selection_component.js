var multiselect = multiselect || {};

var dummyConsole = {
	log : function() {}
}

var console = console || dummyConsole;

multiselect.ping = function() {
	console.log("Hello");
}

multiselect.addTag = function(inputId, valueListId) {
	var tagName = document.getElementById(inputId).value; 
	var valueListElement = document.getElementById(valueListId);
	
	console.log("Going to add a tag called [" + tagName + "]...");
	
	multiselect.appendTagTo(tagName, valueListElement);	
}

multiselect.appendTagTo = function(tagName, valueListElement) {
	var selectedItemDiv = document.createElement('div');
	selectedItemDiv.setAttribute("class", "selected-item");
	selectedItemDiv.innerHTML = "" + tagName + "<a class='remove' href='javascript:' title='Remove " + tagName + "'>x</a>";
	
	valueListElement.appendChild(selectedItemDiv);
}