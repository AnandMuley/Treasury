$(document).ready(function(){
	
	hideAll();
	
	$('#cash').show();
	if($('#mode').val()==undefined){
		$('#mode').val('cash');	
	}else{
		$('#'+$('#mode').val()).show();
	}
	$('#mode').change(function(){
		hideAll();
		$('#'+$(this).val()).show();
	});
	
	$('#usersel').change(function(){
		var payable = 0;
		$.ajax({
			url : contextPath+"/payments/amountpayable?uid="+$(this).val()
		}).done(function(data){
			var payableArr = data.split(':');
			payable = payableArr[1];
			$('#amount').html('&#x20B9;'+payable);
			$('#amountPayable').show();
		}).fail(function(){
			alert('Error');
		});
		
	});
	
});

function hideAll(){
	$('#cheque').hide();
	$('#netbanking').hide();
	$('#cash').hide();
}