/**
 * 
 */
app.controller("baseController", function($scope, $http) {		
		$scope.selectIds=[];//选中的ID集合 
		/*刷新*/
		$scope.reloadList=function(){
			$scope.findList($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
		}
		
		//分页控件配置 
		$scope.paginationConf = {
			currentPage : 1,
			totalItems : 10,
			itemsPerPage : 3,
			perPageOptions : [ 3, 20, 30, 40, 50 ],
			onChange : function() {
				$scope.reloadList();//重新加载
			}
		};
		
		
		/*更新多选框*/
		$scope.updateSelection=function($event,id){
			if($event.target.checked){
				$scope.selectIds.push(id);
			}else{
				var idx=$scope.selectIds.indexOf(id);
				$scope.selectIds.splice(idx,1);
			}
		}
		
	})