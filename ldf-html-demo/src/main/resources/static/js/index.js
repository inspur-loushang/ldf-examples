(function(angular) {
	'use strict';
	angular.module('index', []).controller("body", function($scope, $location) {
		//定义菜单数据
		$scope.menus = [ {
			"url" : "queryuser.html",
			"text" : "用户列表"
		}, {
			"url" : "modifyuser.html",
			"text" : "新增用户"
		} ];
		//初始化首页菜单
		$scope.someUrl = $scope.menus[0].url;
		//跳转菜单
		$scope.loadUrl = function() {
			$scope.someUrl = this.menu.url;
		}
		//隐藏、显示菜单
		$scope.toggleSide = function() {
			if (!$('.ue-menu-left').data('isClose')) {
	        	$('.ue-menu-right').css({'border-left':'1px solid #ddd'}).animate({left:'0px'}, "slow");
	        	$('.ue-menu-left').css({'z-index':'auto'});
	        	$('.ue-menu-left').data('isClose', true);
	    	} else {
	        	$('.ue-menu-right').css({'border-left':'none'}).animate({left:'260px'}, "slow");
	        	$('.ue-menu-left').data('isClose', false);
	    	}
		}
	})

})(window.angular);