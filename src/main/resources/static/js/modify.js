$(() => {

    // 전역 변수
    let isPassword = false;
    let isEmail = false;
    let isPhone = false;

    // 비밀번호 검사
    $("input[name='userpwd']").on("input", function () {
        const userpwd = $(this).val();
        const message = $(this).next();

        if (!userpwd) {
            message.css('color', '#353535').text('(영어, 숫자, 특수문자 포함 8 ~ 16자)');
            isPassword = false;
            return;
        }

        const regex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,16}$/;
        const isValidPassword = regex.test(userpwd);

        message.css('color', isValidPassword ? 'green' : 'red').text(isValidPassword ? '사용 가능한 비밀번호입니다.' : '(영어, 숫자, 특수문자 포함 8 ~ 16자)');
    });

    // 비밀번호 확인 검사
    $("input[name='userpwdCheck]").on("input", function () {
        const userpwd = $("input[name='userpwd']").val();
        const userpwdCheck = $(this).val();
        const message = $(this).next();

        if (userpwd !== userpwdCheck) {
            message.css('color', 'red').text('비밀번호가 일치하지 않습니다.');
            isPassword = false;
            return;
        }

        message.text('');
        isPassword = true;
    });

    // 휴대폰 검사
    $("input[name='userphone']").on("input", function () {
        const phone = $(this).val();
        const message = $(this).next();

        if (!phone) {
            message.text('');
            return;
        }

        const regex = /^010-?([0-9]{4})-?([0-9]{4})$/;;
        const isValidPhone = regex.test(phone);
        if (!isValidPhone) {
            message.css('color', 'red').text('사용할 수 없는 번호입니다.');
            isPhone = false;
            return;
        }

        message.css('color', 'green').text('사용 가능한 번호입니다.');
        isPhone = true;
    });

    // 이메일 검사
    $("input[name='useremail']").on("input", function () {
        const email = $(this).val();
        const message = $(this).next();

        if (!email) {
            message.text('');
            return;
        }

        const regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        const isValidEmail = regex.test(email);
        if (!isValidEmail) {
            message.css('color', 'red').text('사용할 수 없는 이메일입니다.');
            isEmail = false;
            return;
        }

        message.css('color', 'green').text('사용 가능한 이메일입니다.');
        isEmail = true;
    });

    // submit 버튼 클릭했을 때
    $('.btn_submit').click(function(event) {
        if(!isPassword) {
            alert('비밀번호를 다시 한번 확인해주시길 바랍니다.');
            registerForm.user_input_pwd.focus();
            return event.preventDefault();
        }
        if(!isPhone) {
            alert('번호를 다시 한번 확인해주시길 바랍니다.');
            registerForm.user_input_num.focus();
            return event.preventDefault();
        }
        if(!isEmail) {
            alert('이메일을 다시 한번 확인해주시길 바랍니다.');
            registerForm.user_input_email.focus();
            return event.preventDefault();
        }
    });
});