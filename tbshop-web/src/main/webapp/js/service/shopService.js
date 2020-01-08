/**
 * 
 */
app.service('shopService',function($http){
	this.shopList=function(page,rows){
		return $http.get('../month/shopList.do?page='+page+"&rows="+rows);
	}
	this.changeZt=function(entity){
		return $http.post('../month/changeZt.do',entity);
	}
	this.add=function(entity){
		return $http.post('../month/add.do',entity);
	}
	this.findUser=function(){
		return $http.get('../month/findUser.do');
	}
	this.dingList=function(){
		return $http.get('../month/dingList.do');
	}
	this.shopHui=function(sid){
		return $http.get('../month/shopHui.do?sid='+sid);
	}
	this.shopAdd=function(entity){
		return $http.post('../month/shopAdd.do',entity);
	}
})