/**
 * 
 */

$(function() {
	$("input").focusin(function(event) {
		var name = $(this).attr("name");
		if(name == "email"){
			$("#email").text("邮箱格式：[201692***@qq.com]");
		}else if(name == "plain_text"){
			$("#plain_text").text("字母开头6-18位字符。");
		}
	});
	$("#register").submit(function(event) {
		if (!$("input[name='email']").val()) {
			$("#email").text("请注意，您的邮箱地址未填写。");
			return false;
		} else if (!$("input[name='plain_text']").val()) {
			$("#plain_text").text("请注意，您的密码未填写。");
			return false;
		} else if ($("input[name='plain_text']").val() != $("input[name='password']").val()) {
			$("#password").text("请注意，您的密码输入不一致。");
			return false;
		}
	});

});