$(document).ready(function(){
	
	hideAll();
	
	$('#cash').show();
	$('#mode').val('cash');
	
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