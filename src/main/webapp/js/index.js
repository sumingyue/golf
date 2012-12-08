$(function(){
	
	var pannel = new TabPannel({
		container:$("#slide"),
		triggerType:"click",
		headCS:".slide-nums li",
		itemCS:".slide-list-item",
		activeCls:"active"
	});
	
	setInterval(function(){
		var next = pannel.getCurrent()+1;
		if(next==3){next = 0}
		pannel.select(next);
	},5000);
	
	$(".side-banner .close").click(function(){
		$(this).parent().remove();
		return false;
	});
	
	
	var win,scrolls;
	if($.browser.msie && $.browser.version == 6){
		scrolls.css({
			"position":"absolute"
		});
		win = $(window);
		scrolls = $(".side-banner");
		$(document).scroll(function(e){
			scrolls.css({
				top:50+win.scrollTop()
			});
		});
	}
	
});