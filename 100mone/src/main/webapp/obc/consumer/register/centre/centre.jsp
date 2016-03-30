<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="centre">
	<div class="centre-left"></div>
	<div class="centre-right">
		<form id="register" action="<%=request.getContextPath()%>/consumer/register.do" method="post">
			<table>
				<tr>
					<td class="t-left">用户名</td>
					<td><span>*</span><input type="text" name="username" /><span id="username"></span></td>
				</tr>
				<tr>
					<td class="t-left">密码</td>
					<td><span>*</span><input type="password" name="plain_text" /><span id="plain_text"></span></td>
				</tr>
				<tr>
					<td class="t-left">再次输入密码</td>
					<td><span>*</span><input type="password" name="password" /><span id="password"></span></td>
				</tr>
				<tr>
					<td class="t-left">邮箱</td>
					<td><span>*</span><input type="text" name="email" /><span id="email"></span></td>
				</tr>
				<tr>
					<td class="t-left">手机号</td>
					<td><span>*</span><input type="text" name="mobile_phone" /><span id="mobile_phone"></span></td>
				</tr>
				<tr>
					<td><input type="submit" value="立即注册"></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
</div>