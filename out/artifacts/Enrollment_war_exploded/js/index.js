window.onload = function () {
    var reset = document.getElementById('reset');
    var fm = document.getElementsByTagName('form')[0];
    var stuAddMess = document.getElementById('stuAddMess');

    reset.onclick = function () {
        username.value = '';
        password.value = '';
        confirmpass.value = '';
        code.value = '';
        username.focus();
    }

    fm.onsubmit = function () {
        if (!/^\w{6, 20} $ /.test(username.value)) {
            stuAddMess.innerHTML = "*用户名错误";
            username.value = '';
            username.focus();
            return false;
        }

        if (!/^\w{6, 20} $ /.test(password.value)) {
            stuAddMess.innerHTML = "*密码错误";
            password.value = '';
            password.focus();
            return false;
        }


        if (!/^d{4} $ /.test(code.value)) {
            stuAddMess.innerHTML = "*验证码错误1！";
            code.value = ''
            code.focus();
            return false;
        }
        return true;
    }
}