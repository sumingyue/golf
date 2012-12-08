/* Tab Select */


(function(){
	
	var TabPannel = function(opts){
		this.opts = opts;
		this.init();
	}
	
	TabPannel.prototype = {
		init:function(){
			var self = this;
			var container = self.container = $(this.opts.container);
			var headers = self.headers = container.find(this.opts.headCS);
			var pannels =self.pannels = container.find(this.opts.itemCS);
			var activeCls = self.activeCls = this.opts.activeCls;
			self.onSelected = this.opts.onSelected || function(current,next){
				current.removeClass(activeCls);
				next.addClass(activeCls);
			}
			self.current = null;
			self.total = headers.length;
			headers.on(this.opts.triggerType,function(){
				var i = headers.index($(this));
				self.select(i);
				return false;
			});
		},
		select:function(i){
			var self = this;
			var headers = self.headers;
			var pannels = self.pannels;
			var activeCls = self.activeCls;
			var current = self.current;
			headers.eq(current).removeClass(activeCls);
			headers.eq(i).addClass(activeCls);
			self.onSelected.call(this,pannels.eq(current),pannels.eq(i));
			self.current = i;
		},
		next:function(){
			var self = this;
			if(self.current+1 < self.total){
				self.select(self.current+1);
			}
		},
		prev:function(){
			var self = this;
			if(self.current > 0 ){
				self.select(self.current-1);
			}	
		},
		getTotal:function(){
			return this.total;
		},
		getCurrent:function(){
			return this.current;
		}
	}
	
	window.TabPannel = TabPannel;
})();



$(function(){
	$(".tab-list").each(function(i,el){
		new TabPannel({
			container:el,
			triggerType:"hover",
			headCS:".tab-hd-item",
			itemCS:".tab-pannel-item",
			activeCls:"active"
		});
	});
	
});