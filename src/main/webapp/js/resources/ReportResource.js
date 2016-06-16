services.factory('ReportsResource',['TreasuryRestPrefix','$resource',function(TreasuryRestPrefix,$resource){
	return $resource(TreasuryRestPrefix+'reports/:reportId',{},{
		query : {method : 'GET',params:{reportId:'payments'},isArray:false},
		'update' : {method:'PUT'}
	});
}]);