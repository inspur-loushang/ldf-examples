(function(window, angular) {
	'use strict';
	//angularjs的url会默认使用hashbang方式,使用html5的url进行传值需要进行以下配置
	angular.element($('head').append(angular.element('<base href="' + window.location.pathname + '" />')));
	angular.module('modifyuser', [])
	.config(function($locationProvider){
		$locationProvider.html5Mode(true);
	})
	.controller('form',function($scope, $location, $http) {
		$("#saveForm").uValidform({
			btnSubmit:"#saveBtn",			
			datatype:{
			      "email":email
			},
			callback:function(form){
				$.dialog({
					type: 'confirm',
					content: "您确定要提交表单吗？",
					ok: function(){
						$scope.save();
					},
					cancel: function(){}
				});
			}
		});
		//日期插件
		$('.input-group.date').datetimepicker({
			language: "zh-CN",
			autoclose: true,
			minView: 2,
			format: "yyyymmdd"
		}).on("changeDate",function(){
			$(this).find("input").blur();
		}); 
		//表单实例提交
		$scope.save = function(){
			$http.post('framework/demo/user/save', $scope.user)
			.then(function(response){
				if(response.data.success){
					window.location.href="queryuser.html";
				}else{
					$.sticky(
							"保存失败！",
						    {
						        autoclose : 3000, 
						        position : 'top',
						        style : "error"
						    }
					);
				}
			});
		}
		//返回
		$scope.cancel = function(){
			window.location.href="queryuser.html";
		}
		//表单实例查询
		$scope.query = function(){
			$http.post('framework/demo/user/getUserDetailsById?id='+ $scope.user.id)
			.then(function(response){
				$scope.user = response.data;
			});
		}
		$scope.title = "新增用户";
		$scope.user = {}
		$scope.user.archive = {}
		$scope.user.archive.gender = "M"
		var id = $location.search().id
		if(id){
			$scope.title = "编辑用户";
			$scope.user.id = id;
			$scope.query();
		}
	});
})(window, window.angular);
