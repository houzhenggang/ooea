<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="centre">
	<div class="centre-top">LOGO</div>
	<div class="centre-left">
		<form id="register" action="<%=request.getContextPath()%>/consumer/register.do" method="post">
			<table>
				<tr>
					<td class="t-left">登录邮箱</td>
					<td><span>*</span><input type="text" name="email" /><span id="email"></span></td>
				</tr>
				<tr>
					<td class="t-left">设置密码</td>
					<td><span>*</span><input type="password" name="plain_text" /><span id="plain_text"></span></td>
				</tr>
				<tr>
					<td class="t-left">确认密码</td>
					<td><span>*</span><input type="password" name="password" /><span id="password"></span></td>
				</tr>
				<tr>
					<td class="t-left">邮箱验证码</td>
					<td><span>*</span><input type="password" name="password" /><span id="password"></span></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="立即注册" class="btn-register"></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="centre-right">二维码</div>
</div>