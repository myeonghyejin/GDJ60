
//SELECTOR
const id = document.getElementById("id");
const idResult = document.getElementById("idResult");

const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");
const pwCheck = document.getElementById("pwCheck");
const pwCheckResult = document.getElementById("pwCheckResult");

const name = document.getElementById("name");
const nameResult = document.getElementById("nameResult");

const phone = document.getElementById("phone");
const phoneResult = document.getElementById("phoneResult");

const email = document.getElementById("email");
const emailResult = document.getElementById("emailResult");

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

// let idCheck = false;
// let pwLengthCheck = false;
// let pwNullCheck = false;
// let pwEqualCheck = false;
// let nameCheck = false;
// let phoneCheck = false;
// let emailCheck = false;

let checks = [false, false, false, false, false, false, false]

frm.addEventListener("submit", function(){
    //ID 검증
    id.addEventListener("blur", function(){
        if(id.value.length != 0) {
            idResult.innerHTML = '사용 가능한 ID입니다';
            // idCheck = true;
            checks[0] = true;
            idResult.classList.add("blueResult")
            idResult.classList.remove("redResult")
        } else {
            idResult.innerHTML = 'ID는 필수 입력 사항입니다'
            checks[0] = false;
            idResult.classList.add("redResult")
            idResult.classList.remove("blueResult")
        }
    });

    //비밀번호 검증
    pw.addEventListener("keyup", function(){
        if(pw.value.length >= 5 && pw.value.length <= 12) {
            pwResult.innerHTML = '사용 가능한 비밀번호입니다';
            // pwLengthCheck = true;
            checks[1] = true;
            pwResult.classList.add("blueResult")
        } else {
            pwResult.innerHTML = '비밀번호는 6자 이상, 12자 이하만 가능합니다'
            pwResult.classList.add("redResult")
        }
    })

    pw.addEventListener("blur", function(){
        if(pw.value.length != 0) {
            // pwNullCheck = true;
            checks[2] = true;
        } else {
            pwResult.innerHTML = '비밀번호는 필수 입력 사항입니다'
            pwResult.classList.add("redResult")
        }
    })

    //비밀번호 Check
    pwCheck.addEventListener("blur", function(){
        if(pwCheck.value == pw.value){
            pwCheckResult.innerHTML = '일치'
            // pwEqualCheck = true;
            checks[3] = true;
            pwCheckResult.classList.add("blueResult")
        } else {
            pwCheckResult.innerHTML = '일치하지 않는 비밀번호입니다'
            checks[2] == false;
            pwCheckResult.classList.add("redResult")
        }
    });

    pw.addEventListener("change", function(){
        checks[3] = false;
        pwCheck.value='';
        pwCheck.result.innerHTML = '비밀번호가 틀립니다'
        pwCheck.classList.add("redResult")
    });

    //이름 검증
    name.addEventListener("blur", function(){
        if(name.value.length != 0) {
            nameResult.innerHTML = '';
            // nameCheck = true;
            checks[4] = true;
        } else {
            nameResult.innerHTML = '이름는 필수 입력 사항입니다'
            nameResult.classList.add("redResult")
        }
    });

    //전화 번호 검증
    phone.addEventListener("blur", function(){
        if(phone.value.length != 0) {
            phoneResult.innerHTML = '';
            // phoneCheck = true;
            checks[5] = true;
        } else {
            phoneResult.innerHTML = '전화 번호는 필수 입력 사항입니다'
            phoneResult.classList.add("redResult")
        }
    });

    //E-Mail 검증
    email.addEventListener("blur", function(){
        if(email.value.length != 0) {
            emailResult.innerHTML = '';
            // emailCheck = true;
            checks[6] = true;
        } else {
            emailResult.innerHTML = 'E-Mail은 필수 입력 사항입니다'
            emailResult.classList.add("redResult")
        }
    });

    //Form 전송
    btn.addEventListener("click", function(){
        // if(idCheck && pwLengthCheck && pwNullCheck && pwEqualCheck && nameCheck && phoneCheck && emailCheck){
        if(checks.includes(false)) {
        alert("회원 가입 완료");
            // frm.submit();
        } else {
            alert("필수 입력 사항을 모두 입력하세요");
        }
    })

})