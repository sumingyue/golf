function init(){
	$(".trDetail").bind("mouseout", function() {
		this.style.backgroundColor = '';
	});
	$(".trDetail").bind("mouseover", function() {
		this.style.backgroundColor = '#BFDFFF'
	});
	
	$('#contents').dataTable({
		"sPaginationType": "full_numbers",
		'iDisplayLength': 15,
		"oLanguage": {
            "sProcessing": "正在加载中......",
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "对不起，查询不到相关数据！",
            "sEmptyTable": "表中无数据存在！",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
            "sInfoFiltered": "数据表中共为 _MAX_ 条记录",
            "sSearch": "搜索",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "末页"
            }
        }
	});
	$("select[name='contents_length']").prepend('<option value="15">15</option>');
	var value=$("select[name='contents_length']")[0];
    value.value=15;
    
	$(".delete").bind("click", function() {
		return confirm("确定要删除此分类吗(不可恢复)？");
	});
}