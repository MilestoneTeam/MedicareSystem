(function($) {

	$(document).ready(function() {

		var FormValidator = {
			fieldsMsg: {
				account: {
					nopass: '字母、数字和下划线组成, 长度为8到20位, 字母不区分大小写'
				},
				password: {
					nopass: '由字母、数字或!、@、#、_构成, 长度为5到20位'
				},
				repassword: {
					nopass: '两次输入密码不一致'
				}
			},
			fieldsRule: {
				whitespaces: /^\s+|\s+$/g,
				account: /^[a-zA-Z0-9_]{8,20}$/,
				password: /^[a-zA-Z0-9!@#_]{5,20}$/
			},
			fields: $('dd input'),
			pass: true,
			hasNoEmptyField: function() {
				var hasEmpty = false;
				this.fields.each(function(index) {
					if ($(this).val() === '') {
						hasEmpty = true;
					}
				});
				return !hasEmpty;
			},
			bindFormValidate: function() {
				$('input:first').focus();
				
				var that = this;
				$('#regForm').submit(function(evt) {
					$('.msg').each(function(index) {
						if ($(this).hasClass('fail')) {
							that.pass = false;
						}
					}); 
					alert('p'+pass);
					var submit = that.hasNoEmptyField() && that.pass;
					if (submit) {
						$('input[type="submit"]').attr('disabled', 'disabled');
					}
					//console.log(submit);
					alert('s'+submit);
					return submit;
				});
			},
			bindFieldsBlur: function() {
				var that = this;
				this.fields.blur(function(evt) {
					evt.stopPropagation();
					
					var $field = $(this), value = $field.val(), id=$field.attr('id');
					if (id === 'account' || id === 'password') {
						if (!that.fieldsRule[id].test(value)) { //验证失败
							$field.next().text(that.fieldsMsg[id]['nopass'])
										 .removeClass('tips fail success')
										 .addClass('fail');
						} else { //验证通过
							$field.next().empty()
										 .removeClass('tips fail success')
										 .addClass('success');
						}
					} 
					if (id === 'repassword') {
						var pwd = $('#password').val();
						if (pwd === '' || 
							pwd !== '' && pwd !== value) { //验证失败
							$field.next().text(that.fieldsMsg[id]['nopass'])
										 .removeClass('tips fail success')
										 .addClass('fail');
						} else { //验证通过
							$field.next().empty()
										 .removeClass('tips fail success')
										 .addClass('success');
						}
					}
				});
			},
			bindFieldsFocus: function() {
				var that = this;
				this.fields.focus(function(evt) {
					evt.stopPropagation();
					
					var $field = $(this), value = $field.val(), id=$field.attr('id');
					if (value === '') {
						$field.next().text(that.fieldsMsg[id]['nopass'])
									 .removeClass('tips fail success')
									 .addClass('tips');
					}
				});
			},
			bindAction: function() {
				this.bindFieldsBlur();
				this.bindFieldsFocus();
				this.bindFormValidate();
			}
		};
		
		FormValidator.bindAction();
	});
})(jQuery);