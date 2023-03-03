const replyAdd = document.getElementById('replyAdd');
const replyContents = document.getElementById('replyContents');

const commentListResult = document.getElementById('commentListResult');

replyAdd.addEventListener('click', function(){
    let xhttp = new XMLHttpRequest();

    xhttp.open('POST', '../bankbookComment/add');

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("contents="+replyContents.value+"&bookNum="+replyAdd.getAttribute('data-book-num'));

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4&&this.status==200){
            if(this.responseText.trim()==1) {
                alert('후기가 등록되었습니다.')
                replyContents.value="";
                getList();
            } else {
                '등록에 실패했습니다'
            }
        }
    })
})

getList();

function getList(){
    let xhttp = new XMLHttpRequest();

    xhttp.open('GET', '../bankbookComment/list?bookNum='+replyAdd.getAttribute('data-book-num'));

    xhttp.send();

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4&&this.status==200){
            commentListResult.innerHTML=this.responseText.trim();
        }
    })
}