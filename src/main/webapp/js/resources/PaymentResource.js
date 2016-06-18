services.factory('PaymentResource',['TreasuryRestPrefix','$resource',
                                    function(TreasuryRestPrefix,$resource){
	return $resource(TreasuryRestPrefix+"payments/:residentId",{},{
		query : {method:"GET",params:{},isArray:true},
		'update' : {method:"PUT"}
	});
}]);