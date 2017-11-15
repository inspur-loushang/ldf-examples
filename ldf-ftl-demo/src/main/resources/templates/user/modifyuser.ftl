<!DOCTYPE html>
<html lang="zh-CN" data-ng-app="modifyuser">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户案例</title>

    <link href="${rc.contextPath}/webjars/ldf/css/bootstrap.css" rel="stylesheet">
    <link href="${rc.contextPath}/webjars/ldf/css/font-awesome.css" rel="stylesheet">
    <link href="${rc.contextPath}/webjars/ldf/css/ui.css" rel="stylesheet">
    <link href="${rc.contextPath}/webjars/ldf/css/form.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="/skin/html5shiv/html5shiv.min.js"></script>
      <script src="/skin/respond/dest/respond.min.js"></script>
    <![endif]-->
     <script src="${rc.contextPath}/webjars/ldf/js/jquery.js"></script>
     <script src="${rc.contextPath}/webjars/ldf/js/bootstrap.js"></script>
     <script src="${rc.contextPath}/webjars/ldf/js/form.js"></script>
     <script src="${rc.contextPath}/webjars/ldf/js/ui.js"></script>
     <script src="${rc.contextPath}/webjars/angularjs/angular.js"></script>
     <script src="${rc.contextPath}/js/modifyuser.js"></script>
     <script type="text/javascript">
		var context="${rc.contextPath}";
     </script>
  </head>
  <body>
	<div class="container" data-ng-controller="form">
	  <h2 class="text-left htext" data-ng-bind="title"></h2>
	  <hr class="fenge"/>
	  <br/>
	  <div class="col-xs-10 col-md-10">	  
		<form class="form-horizontal" id="saveForm" name="saveForm" onsubmit="return false" enctype="multipart/form-data">
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label">账号<span class="required">*</span></label>
				<div class="col-xs-8 col-md-8">
					<input datatype="s3-16" errormsg="账号3~16个字符！" nullmsg="请设置账号" type="text" class="form-control ue-form Validform_input" placeholder="账号" data-ng-model="user.userId"/>						
					<span class="Validform_checktip Validform_span"></span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label">名称<span class="required">*</span></label>
				<div class="col-xs-8 col-md-8">
					<input datatype="s2-16" errormsg="姓名2~16个字符！" nullmsg="请填写名称" type="text" class="form-control ue-form Validform_input" placeholder="名称" data-ng-model="user.userName"/>						
					<span class="Validform_checktip Validform_span"></span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label">昵称</label>
				<div class="col-xs-8 col-md-8">
					<input datatype="s2-16" errormsg="昵称2~16个字符！" ignore="ignore" type="text" class="form-control ue-form Validform_input" placeholder="昵称" data-ng-model="user.nickname"/>
					<div class="Validform_checktip Validform_span"></div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label">密码<span class="required">*</span></label>
				<div class="col-xs-8 col-md-8">
					<input datatype="s6-16" errormsg="密码6~16个字符！" nullmsg="请设置密码" type="text" class="form-control ue-form Validform_input" placeholder="密码" data-ng-model="user.password"/>						
					<span class="Validform_checktip Validform_span"></span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label">性别<span class="required">*</span></label>
				<div class="col-xs-9 col-md-9">
					<div class="radio">
						<label>
							<input type="radio" value="M" data-ng-model="user.archive.gender" checked="checked"/>男
						</label>
						<label>
							<input type="radio" value="F" data-ng-model="user.archive.gender"/>女
						</label>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label">生日</label>
				<div class="col-xs-8 col-md-8">
					<div class="input-group date Validform_input">
						<input datatype="*" ignore="ignore" type="text" class="form-control ue-form" placeholder="生日" data-ng-model="user.archive.birthday"/>
						<span class="input-group-addon ue-form-btn date-input-btn">
							<i class="fa fa-calendar"></i>
						</span>										   
					</div>
					<span class="Validform_checktip Validform_span" ></span>	
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label">学历</label>
				<div class="col-xs-9 col-md-9">
					<div class="radio">
						<label>
							<input type="radio" data-ng-model="user.archive.education" value="0" />本科
						</label>
						<label>
							<input type="radio" data-ng-model="user.archive.education" value="1" />硕士
						</label>
						<label>
							<input type="radio" data-ng-model="user.archive.education" value="2" />博士
						</label>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label">学校</label>
				<div class="col-xs-8 col-md-8">
					<input datatype="s" ignore="ignore" type="text" class="form-control ue-form Validform_input" placeholder="学校" data-ng-model="user.archive.school"/>
					<span class="Validform_checktip Validform_span"></span>					
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label">电子邮件</label>
				<div class="col-xs-8 col-md-8">
					<input datatype="email" ignore="ignore" errormsg="请填写正确的邮箱地址" type="email" class="form-control ue-form Validform_input" placeholder="邮件地址" data-ng-model="user.archive.email"/>				    
					<span class="Validform_checktip Validform_span" ></span>
				</div>			
			</div>
			
			<div class="form-group" >
			  <label class="col-xs-3 col-md-3 control-label"></label>
			  <div class="col-xs-8 col-md-8">
				<button id="saveBtn" type="button" class="btn ue-btn-primary">
					保存
				</button>
				<button type="button" class="btn ue-btn" data-ng-click="cancel()">
					 返回
				</button>
				<span id="msgdemo"></span>
			</div>
		  </div>
		</form>
		</div>
	</div>
  </body>
</html>