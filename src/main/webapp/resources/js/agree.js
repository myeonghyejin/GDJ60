const checkAll = document.getElementById("checkAll");
const checks = document.getElementsByClassName("checks");
const agree = document.getElementById("agree");

agree.addEventListener("click", function(){
    if(checkAll.checked) {
        //alert('모두 동의함')
        location.href = "./add";
    } else {
        alert('모든 약관에 동의하지 않으면 가입할 수 없습니다.')
    }
})

checkAll.addEventListener("click", function(){
    for(let i=0; i < checks.length; i++) {
        checks[i].checked = checkAll.checked;
    }
});

for(let i=0; i<checks.length; i++) {
    checks[i].addEventListener("click", function(){
        let result = true;
        for(let j=0; j<checks.length; j++) {
            if(!checks[j].checked) {
                //result = checks[j].checked;
                //result = false;
                result = !result;
                break;
            }
        }

        checkAll.checked = result;

    })
}