var multiselect = multiselect || {};

var dummyConsole = {
	log : function() {}
}

var console = console || dummyConsole;

multiselect.ping = function() {
	console.log("Hello");
}

multiselect.currentlySelected = new Array();

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

multiselect.containsTag = function(tagName) {
	var contains = false;
	multiselect.currentlySelected.forEach(function(item) {
		if (tagName === item) {
			contains = true;
		}
	});
	return contains;
}

multiselect.removeTag = function(tagName) {
	var index=0;
	var itemIndex=-1;
	multiselect.currentlySelected.forEach(function(item) {
		if (tagName === item) {
			itemIndex = index;
		}
		index = index + 1;
	});
	if (itemIndex != -1) {
		multiselect.currentlySelected.splice(itemIndex, 1);
	}
}

// http://www.webdeveloper.com/forum/showthread.php?t=193924
multiselect.appendTagTo = function(tagName, valueListElement) {
	if (multiselect.containsTag(tagName)) {
		return;
	}
	
	var selectedItemDiv = document.createElement('div');
	selectedItemDiv.setAttribute("id", "item-" + multiselect.currentId);
	selectedItemDiv.setAttribute("class", "selected-item");
	selectedItemDiv.innerHTML = "" + tagName + "<a class='remove' href='javascript:' onclick='multiselect.remove(\"item-" + multiselect.currentId + "\", \""+ valueListElement.id +"\");' title='Remove " + tagName + "'>x</a>";
	multiselect.currentId = multiselect.currentId+1;
	valueListElement.appendChild(selectedItemDiv);		
	multiselect.currentlySelected.push(tagName);
}

multiselect.remove = function(linkElementId, valueListElementId) {

	var linkElement = document.getElementById(linkElementId);	
	var valueListElement = document.getElementById(valueListElementId);
	var tagName = linkElement.innerText;
	tagName = tagName.substring(0, tagName.length -1);
	console.log("Removing: " + linkElementId + ", " + tagName);	
	valueListElement.removeChild(linkElement);	
	multiselect.removeTag(tagName);
}