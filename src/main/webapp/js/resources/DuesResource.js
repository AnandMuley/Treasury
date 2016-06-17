services.factory('DuesResource',['TreasuryRestPrefix','$resource',function(TreasuryRestPrefix,$resource){
	return $resource(TreasuryRestPrefix+'dues',{},{
		query : {method:'GET',params:{},isArray:false}
	});
}]);