services.factory('SettingsResource',
		['TreasuryRestPrefix','$resource',
		 function(TreasuryRestPrefix,$resource){
	return $resource(TreasuryRestPrefix+"settings/:createdBy",{},{
		query : {method:"GET",isArray:false},
		update : {method:"PUT"}
	});
}]);