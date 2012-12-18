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
		if(next==pannel.getTotal()){next = 0}
		pannel.select(next);
	},5000);
	
	$(".side-banner .close").click(function(){
		$(this).parent().remove();
		return false;
	});
	
	
	var win,scrolls;
	//if($.browser.msie && $.browser.version == 6){
		scrolls = $(".side-banner");
		scrolls.css({
			"position":"absolute"
		});
		win = $(window);
		$(window).scroll(function(e){
			if(win.height() + win.scrollTop() < $(".wrap").height()){
				scrolls.css({
					top:50+win.scrollTop()
				});
			}
		});
	//}
	
});