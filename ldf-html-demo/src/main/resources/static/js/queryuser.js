$(function(){
	// 初始化表格
	initGrid();
	// 初始化更多查询组件
	$("#moresearch").popover({
	    title: "",
	    content: $("#searchpanel").html(),
	    placement: "bottom",
	    html: true,
	    trigger: "click"
	});
	// “搜索”按钮
	$("#query").click(function(){
		query();		
	});
	// “增加”按钮
	$("#add").click(function(){
		modify();
	});
	// “删除”按钮
	$("#batchDel").click(function(){
		Batchdelete();
	});
	// “更多搜索”按钮
	$(document).on("click","#search",function(){
		query();
	});
	//“全选”按钮
	$(document).on("click","#selectAll",function(){
		$(":checkbox[name='checkbox']").prop("checked", this.checked);
	})
	//单击任意td选中
	$(document).on("click","#formList tr td:not(:first-child)",function(){
		var obj = $(this).parent().find("td:first").find("input");
		obj.prop("checked",!obj.is(":checked"));
	});
});

//初始化表格
function initGrid() {
	var url = 'framework/demo/user/query';
	grid = new L.FlexGrid("formList", url);
	grid.init({});
	return grid;
}
function del(id){
	$.dialog({
		type: 'confirm',
		content: "确认删除该记录?",
	    autofocus: true,
		ok: function(){
			$.post("framework/demo/user/delete/"+id, function(data){
				if(data.success){
					query();
				}else{
					sticky("删除失败!", "error") 
				}
			});
		},
		cancel: function(){}
	});
}
function Batchdelete(){
	var recordTmp= [];
	var userIds = $(":checkbox[name=checkbox]:checked");
	if(userIds!=null&&userIds.length<1){
		$.dialog({
			type:'confirm',
			content: "请选择要删除的记录！",
			autofocus: true,
			ok: function(){}
		});
	}else{
		userIds.each(function(i, checkbox){
			recordTmp.push($(checkbox).val());
		});
		recordIds = recordTmp.join();
		$.dialog({
			type: 'confirm',
			content: "确认删除该记录?",
		    autofocus: true,
			ok: function(){
				$.post("framework/demo/user/delete/"+recordIds, function(data){
					if(data.success){
						query();
					}else{
						sticky("删除失败!", "error") 
					}
				});
			},
			cancel: function(){}
		});
	}
}
function modify(id){
	var url = "modifyuser.html";
	if(id){
		url += "?id=" + id;
	}
	window.location.href = url;
}
function query() {
	var userId = $("#userId").val();
	var userName = $("#userName").val();
	if(userId == undefined){
		userId = "";
	}
	var url = "framework/demo/user/query";
	var param={"userId":userId,"userName":userName};
	url=encodeURI(url,"utf-8"); 
	grid.reload(url,param);
}
//渲染操作按钮
function renderoptions(data, type, full) {
	return '<div>'
			+ '<a onclick="del(' + "'" + data + "'" + ')">删除</a>'
			+ '<span>&nbsp;&nbsp</span>' 
			+ '<a onclick="modify(' + "'" + data + "'" + ')">编辑</a>'
			+'</div>'
}
//渲染状态
function renderstatus(data, type, full) {
	switch (data) {
	case "N":
		data = "启用";
		break;
	case "X":
		data = "停用";
		break;
	}
	return data;
}
//渲染表格首列的checkbox
function rendercheckbox(data, type, full) {
	 return '<input type="checkbox" value="' + data + '" title="' + data + '" id="'+data+'" name="checkbox"/>';
};

//弹窗函数
function UIAlert(content) {
	$.dialog({
		type: "alert",
		content: content,
		autofocus: true
	});
}

//弹窗提示样式
function sticky(msg, style, position) {
	var type = style ? style : 'success';
	var place = position ? position : 'top';
	$.sticky(
		    msg,
		    {
		        autoclose : 3000, 
		        position : place,
		        style : type
		    }
	);
}
