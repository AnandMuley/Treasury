services.factory('ResidentResource',['TreasuryRestPrefix','$resource',function(TreasuryRestPrefix,$resource){
	return $resource(TreasuryRestPrefix+'residents/:residentId',{},{
		query : {method : 'GET',params:{},isArray:true},
		'update' : {method:'PUT'},
		'findResident': {method:'GET',params:{residentId:'find'},isArray:false}
	});
}]);