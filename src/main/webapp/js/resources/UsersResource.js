services.factory('UsersResource',['TreasuryRestPrefix','$resource',function(TreasuryRestPrefix,$resource){
	return $resource(TreasuryRestPrefix+'users/:userId',{},{
		query : {method : 'GET',params:{},isArray:true},
		'update' : {method:'PUT'},
		'findUser': {method:'GET',params:{userId:'find'},isArray:false}
	});
}]);