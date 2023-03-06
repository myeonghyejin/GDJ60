const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");
const pageLink = document.querySelectorAll(".page-link");

replyAdd.addEventListener("click", function(){

    let xhttp = new XMLHttpRequest();

    xhttp.open("POST", "../bankbookComment/add");

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("contents="+replyContents.value+"&bookNum="+replyAdd.getAttribute('data-book-num'));

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4&&this.status==200){
            if(this.responseText.trim()==1){
                alert('댓글이 등록되었습니다.')
                replyContents.value="";
                getList(1);
            }else {
                alert('댓글 등록에 실패했습니다.')
            }

        }
    })

})

getList(1);

function getList(page){
    let count=0;
    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "/bankbookComment/list?bookNum="+replyAdd.getAttribute('data-book-num')+"&page="+page);

    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4&&this.status==200){
            commentListResult.innerHTML=this.responseText.trim();
            count++;
        }        
    });
    //xhttp.send();
    //0이 출력됨 : 비동기 방식이기 때문
    console.log(count);
}
commentListResult.addEventListener("click", function(e){
    let pageLink = e.target;
    if(pageLink.classList.contains("page-link")){
        let page = pageLink.getAttribute("data-board-page");
        getList(page);
    }
    e.preventDefault();
});

//delete
commentListResult.addEventListener("click", function(e){
    let del = e.target;
    if(del.classList.contains("del")){
        let xhttp = new XMLHttpRequest();
        xhttp.open("POST", "../bankbookComment/delete");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("num="+del.getAttribute("data-comment-num"));
        xhttp.addEventListener("readystatechange", function(){
            if(this.readyState==4&&this.status==200){
                let result = this.responseText.trim();
                if(result>0){
                    alert('댓글이 삭제되었습니다.');
                    getList(1);
                }else{
                    alert('삭제 실패');
                }
            }        
        });
    }
    e.preventDefault();
});

//update
commentListResult.addEventListener("click", function(e){
    let updateButton = e.target;
    if(updateButton.classList.contains("upd")){
        let num = updateButton.getAttribute("data-comment-num");
        let contents = document.getElementById("contents"+num);

        // 첫 번째 방법
        // console.log(contents);
        // contents.innerHTML="<textarea>"+contents.innerText+"</textarea>";

        // 두 번째 방법
        contents.firstChild.removeAttribute("readonly");
        let btn = document.createElement("button");
        let attr = document.createAttribute("class");
        attr.value="btn btn-primary";
        btn.setAttributeNode(attr);
        contents.appendChild(btn);
        attr = document.createTextNode("확인");
        btn.appendChild(attr);

        btn.addEventListener("click", function(){
            console.log(contents.firstChild.value);
            console.log(num);

            let xhttp = new XMLHttpRequest();
            xhttp.open("POST", "../bankbookComment/update");
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("num="+num+"&contents="+contents.firstChild.value);
            xhttp.addEventListener("readystatechange", function(){
                if(this.readyState==4&&this.status==200){
                    let result = this.responseText.trim();
                    if(result>0){
                        alert('수정되었습니다.');
                        getList(1);
                    }else{
                        alert('수정 실패');
                    }
                }        
            });     
        })
    }
    e.preventDefault();
});