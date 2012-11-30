function getSmallCategory(){
	var id = $('#categoryId').val()
	var href = 'smallCategoryList.do?categoryId='+id;
	window.location.href = href;
}

function categoryChanged(){
	var id=$('#news_categoryId').val();
	$.ajax({
		type: "get",
		url: "querySmallCategory.do?categoryId="+id,
		success : function(data, textStatus) {
			var obj = $('#news_smallCategoryId');
			var value = data.smallCategoryList;
			
			document.getElementById('news_smallCategoryId').options.length = 0;
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
    if(!radioName) return;  
       var radios = document.getElementsByName(radioName);     
       for(var i=0; i<radios.length; i++) {  
          radios[i].checked = false;  
          if(radios[i].value == newValue.toString()) {  
          radios[i].checked = true;  
       }  
    }  
} 