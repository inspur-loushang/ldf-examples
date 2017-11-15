<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户案例</title>

    <link href="${rc.contextPath}/webjars/ldf/css/bootstrap.css" rel="stylesheet">
    <link href="${rc.contextPath}/webjars/ldf/css/font-awesome.css" rel="stylesheet">
    <link href="${rc.contextPath}/webjars/ldf/css/flexgrid.css" rel="stylesheet">
    <link href="${rc.contextPath}/webjars/ldf/css/ui.css" rel="stylesheet">
    <link href="${rc.contextPath}/webjars/ldf/css/form.css" rel="stylesheet">
    <link href="${rc.contextPath}/css/index.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="/skin/html5shiv/html5shiv.min.js"></script>
      <script src="/skin/respond/dest/respond.min.js"></script>
    <![endif]-->
     <script src="${rc.contextPath}/webjars/ldf/jquery.js"></script>
     <script src="${rc.contextPath}/webjars/ldf/js/bootstrap.js"></script>
     <script src="${rc.contextPath}/webjars/ldf/js/flexgrid.js"></script>
     <script src="${rc.contextPath}/webjars/ldf/js/loushang-framework.js"></script>
     <script src="${rc.contextPath}/webjars/ldf/js/form.js"></script>
     <script src="${rc.contextPath}/webjars/ldf/js/ui.js"></script>
	 <script src="${rc.contextPath}/js/queryuser.js"></script>
	 <script id="searchpanel" type="text/html">
	  <div id="searchtemp">
		<div class="form-group">
			<label for="userId" class="text-name">账号：</label> 
			<input type="text" class="form-control ue-form" id="userId" placeholder="账号"/>
		</div>
        <div style="margin:10px 50px">
			<button id="search" class="btn ue-btn-primary">搜索</button>
		</div>
      </div>
	</script>
	<script type="text/javascript">
		var context="${rc.contextPath}";
	</script>
  </head>
  <body>
	<div class="container">
		<div class="row">
			<form class="form-inline" onsubmit="return false;">										
				<div class="input-group">
			        <input class="form-control ue-form" type="text" id="userName" placeholder="用户名称"/>
			        <div class="input-group-addon ue-form-btn" id="query">
			        	<span class="fa fa-search"></span>
			        </div>
		        </div>
			    <a class="btn ue-btn dbtn" id="moresearch">更多搜索<i class="fa fa-angle-down"></i></a>
			    <div class="btn-group pull-right">
					<button id="add" type="button"
						class="btn ue-btn">
						<span class="fa fa-plus"></span>增加
					</button>
					<button id="batchDel" type="button" class="btn ue-btn" style="margin-left: 5px;"><span class="fa fa-trash"></span>批量删除</button>
				</div>
			</form>
		</div>
		<div class="row">
			<table id="formList" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th width="10%" data-field="id" data-sortable="false" data-render="rendercheckbox">
							<input type="checkbox" id="selectAll">
						</th>
						<th width="18%" data-field="userId" data-sortable="false">账号</th>
						<th width="18%" data-field="userName" data-sortable="false">姓名</th>
						<th width="18%" data-field="nickname" data-sortable="false">昵称</th>
						<th width="18%" data-field="status" data-render="renderstatus" data-sortable="false">账号状态</th>
						<th width="18%" data-field="id" data-render="renderoptions" data-sortable="false">操作</th>
					</tr>
				</thead>
			</table>	
		</div>
	</div>
  </body>
</html>