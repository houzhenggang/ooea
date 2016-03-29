/**
 * 
 */

$(function() {
	$("#register").submit(function(event) {
		if (!$("input[name='username']").val()) {
			$("#username").text("请注意，您的用户名未填写。");
			return false; 
		} else if (!$("input[name='plain_text']").val()) {
			$("#plain_text").text("请注意，您的密码未填写。");
			return false; 
		} else if ($("input[name='plain_text']").val()!=$("input[name='password']").val()) {
			$("#password").text("请注意，您的密码输入不一致。");
			return false; 
		} else if (!$("input[name='email']").val()) {
			$("#email").text("请注意，您的邮箱地址未填写。");
			return false; 
		} else if (!$("input[name='mobile_phone']").val()) {
			$("#mobile_phone").text("请注意，您的手机号未填写。");
			return false; 
		}
	});
});