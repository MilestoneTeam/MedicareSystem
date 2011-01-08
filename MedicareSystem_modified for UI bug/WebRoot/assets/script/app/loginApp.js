(function($) {
	
	function isValid() {
		var valid = true;
		var uAccount = $('#account').val();
		var uPwd = $('#password').val();
		if (uAccount === '' || uPwd === '') {
			valid = false;
		}
		return valid;
	}
	
	$(document).ready(function() {
		$('#loginForm').submit(function(evt) {
			if (!isValid()) {
				var content = '<p>请输入正确帐号信息，完成登录！</p> \
							   <p>您也可以现在进行<a href="doctorRegister.jsp">注册</a></p>';
				art.dialog({
					skin: 'chrome',
					fixed: true,
					lock: true,
					drag: false,
					title: '医保管理系统',
					content: content,
					yesFn: false,
					noFn: false
				});
				return false;
			} else {
				$('input[type="submit"]').attr('disabled', 'disabled');
				return true;
			}
		});
	});
})(jQuery);