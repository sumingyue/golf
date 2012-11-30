$(function(){
	
	var pannel = new TabPannel({
		container:$("#slide"),
		triggerType:"hover",
		itemCS:".slide-list-item",
		activeCls:"active"
	});
	
	var count = 0;
	var total = 3;
	setInterval(function(){
		count++;
		pannel.select(count%total);
	},5000);
		

	
})