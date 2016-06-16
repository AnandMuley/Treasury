services.factory('PaymentResource',['TreasuryRestPrefix','$resource',
                                    function(TreasuryRestPrefix,$resource){
	return $resource(TreasuryRestPrefix+"payments/:userId",{},{
		query : {method:"GET",params:{},isArray:true},
		'update' : {method:"PUT"}
	});
}]);