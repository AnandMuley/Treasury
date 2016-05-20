$(document).ready(function(){
	
	$('#saveBtn').hide();
	
	$(".edit").click(function(){
		clearAll();
		var userDat = $(this).attr('title').split('|');
		$('#name').val(userDat[0]);
		$('#flatNo').val(userDat[1]);
		$('#contactNo').val(userDat[2]);
		$('#userID').val(userDat[3]);
		$('#area').val(userDat[4]);
		$('#addBtn').hide();
		$('#saveBtn').show();
	});
	
	$("#saveBtn").click(function(){
		$('#usrAddEditFrm').attr('action',$('#usrEditLink').val());
		$('#usrAddEditFrm').submit();
	});
	
	$("#addBtn").click(function(){
		$('#usrAddEditFrm').submit();
	});
	
	$('.delete').click(function(){
		var uid = $(this).attr('title');
		$('#uid').val(uid);
		$('#userDelFrm').submit();
	});
	
	function clearAll(){
		$('#name').val('');
		$('#flatNo').val('');
		$('#contactNo').val('');
	}
	
});