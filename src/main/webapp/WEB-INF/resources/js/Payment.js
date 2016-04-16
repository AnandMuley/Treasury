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
});

function hideAll(){
	$('#cheque').hide();
	$('#netbanking').hide();
	$('#cash').hide();
}