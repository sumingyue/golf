function getSmallCategory(type) {
	var id = $('#categoryId').val()
	var href = 'smallCategoryList.do?categoryId=' + id + "&type=" + type;
	window.location.href = href;
}

function categoryChanged() {
	document.getElementById('news_smallCategoryId').options.length = 0;
	var id = $('#news_categoryId').val();
	$.ajax({
		type : "get",
		url : "querySmallCategory.do?categoryId=" + id + "&type=1",
		success : function(data, textStatus) {
			var obj = $('#news_smallCategoryId');
			var value = data.smallCategories;

			if (value != null) {
				obj.append("<option value='o'>_ALL</option>");
				for ( var i = 0; i < value.length; i++) {
					obj.append("<option value='" + value[i].id + "'>"
							+ value[i].name + "</option>");
				}
				;
			}
			;
		}
	});
}

function imageCategoryChanged(){
	document.getElementById('imageSpecial_smallCategoryId').options.length = 0;
	var id=$('#imageSpecial_categoryId').val();
	$.ajax({
		type: "get",
		url: "querySmallCategory.do?categoryId="+id + "&type=2",
		success : function(data, textStatus) {
			var obj = $('#imageSpecial_smallCategoryId');
			var value = data.smallCategories;
			
			if (value != null) {
				obj.append("<option value='o'>_ALL</option>");
				for ( var i = 0; i < value.length; i++) {
					obj.append("<option value='"+value[i].id+"'>"+value[i].name+"</option>");
				};
			};
		}
	});
}

function setCheckedValue(radioName, newValue) {
	if (!radioName)
		return;
	var radios = document.getElementsByName(radioName);
	for ( var i = 0; i < radios.length; i++) {
		radios[i].checked = false;
		if (radios[i].value == newValue.toString()) {
			radios[i].checked = true;
		}
	}
}