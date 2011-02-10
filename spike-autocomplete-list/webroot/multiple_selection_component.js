var multiselect = multiselect || {};

var dummyConsole = {
	log : function() {}
}

var console = console || dummyConsole;

multiselect.ping = function() {
	console.log("Hello");
}

multiselect.addTag = function(selectElement, valueListId) {
	if (multiselect.changing === true) {
		return;
	}
	var tagName = selectElement.value; 
	var valueListElement = document.getElementById(valueListId);
	
	console.log("Going to add a tag called [" + tagName + "]...	");
	
	multiselect.appendTagTo(tagName, valueListElement);	
	
	multiselect.changing=true;
	selectElement.value = "Add";
	multiselect.changing=false;

}

multiselect.currentId=0;
multiselect.changing=false;

// http://www.webdeveloper.com/forum/showthread.php?t=193924
multiselect.appendTagTo = function(tagName, valueListElement) {
	var selectedItemDiv = document.createElement('div');
	selectedItemDiv.setAttribute("id", "item-" + multiselect.currentId);
	selectedItemDiv.setAttribute("class", "selected-item");
	selectedItemDiv.innerHTML = "" + tagName + "<a class='remove' href='javascript:' onclick='multiselect.remove(\"item-" + multiselect.currentId + "\", \""+ valueListElement.id +"\");' title='Remove " + tagName + "'>x</a>";
	multiselect.currentId = multiselect.currentId+1;
	valueListElement.appendChild(selectedItemDiv);		
	
}

multiselect.remove = function(linkElementId, valueListElementId) {
	console.log("Removing: " + linkElementId);	
	var linkElement = document.getElementById(linkElementId);	
	var valueListElement = document.getElementById(valueListElementId);
	valueListElement.removeChild(linkElement);	
}