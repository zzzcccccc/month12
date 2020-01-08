/**
 * 
 */
app.controller('shopController',function($scope,$controller,$location,shopService,uploadService){
	$controller('baseController',{$scope:$scope});
	
	$scope.status=['上架','下架'];
	$scope.status1=['待支付','支付'];
	$scope.entity={};
	$scope.role={};
	//列表
	$scope.findList=function(page,rows){
		shopService.shopList(page,rows).success(
			function(req){
				$scope.sList=req.rows;
				$scope.paginationConf.totalItems=req.total;
			}
		)
	}
	//修改商品状态
	$scope.changeZt=function(entity){
		shopService.changeZt(entity).success(
			function(req){
				if(req.success){
					alert(req.message);
					location.href="list.html";
				}else{
					alert(req.message);
				}
			}
		)
	}
	//上传
	$scope.uploadFile=function(){
		uploadService.uploadFile().success(
			function(req){
				if(req.success){
					alert("上传成功");
					$scope.entity.imgpath=req.message;
				}else{
					alert("上传失败");
				}
			}
		)
	}
	//添加
	$scope.add=function(){
		shopService.add($scope.entity).success(
			function(req){
				if(req.success){
					alert("添加成功");
					location.href="list.html";
				}else{
					alert("添加失败");
				}
			}
		)
	}
	//获取登陆人
	$scope.findUser=function(){
		shopService.findUser().success(
			function(req){
				$scope.role=req[0].authority;
				console.log($scope.role);
			}
		)
	}
	//订单列表
	$scope.dingList=function(){
		shopService.dingList().success(
			function(req){
				console.log(req);
				$scope.dList=req;
			}
		)
	}
	//huixian
	var sid = $location.search()['sid'];
	alert(sid);
	$scope.shopHui=function(){
		shopService.shopHui(sid).success(
			function(req){
				$scope.entity=req;
			}
		);
	}
	$scope.shopAdd=function(){
		shopService.shopAdd($scope.entity).success(
			function(req){
				if(req.success){
					alert("下单");
					location.href="list.html";
				}
			}
		)
	}
})