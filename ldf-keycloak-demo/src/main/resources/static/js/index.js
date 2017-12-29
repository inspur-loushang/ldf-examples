(function(angular) {
	'use strict';
	angular.module('index', []).controller("body", function($scope, $location,$http) {
		$scope.query = function(){
			$http.post('service/home/getMenu')
			.then(function(response){
				$scope.menus = response.data
				//初始化首页菜单
				if(""!=$scope.menus&&$scope.menus!=null){
					$scope.someUrl = $scope.menus[0].url;
				}
			});
			$http.post('service/home/getUser')
			.then(function(response){
				$scope.userId = response.data.userId;
			});
		}
		$scope.query();
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
		$scope.logoutUrl = function() {
			$http.post('service/home/getLogout')
			.then(function(response){
				window.location.href = response.data.logoutUrl;
			});
		}
	})

})(window.angular);
function updateUrl(url){
	$("iframe").attr("src",url)
}
$(function(){
	$(".dropdown").mouseover(function(){
	  $(".dropdown-menu").show();
	});
	$(".dropdown").mouseout(function(){
	  $(".dropdown-menu").hide();
	});
});