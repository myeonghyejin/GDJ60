// const fileAdd = document.getElementById("fileAdd");
const fileList = document.getElementById("fileList");

let count = 0;
let max = 1;
let param = 'multipartFile';
let idx = 0;

function setCount(c){
    count = c;
}

function setMax(m) {
    max = m;
};

function setParam(p) {
    param = p;
}

$('.deleteCheck').click(function(){
    let result = confirm('파일이 영구히 삭제됩니다.')
    let ch = $(this);
    if(result){
        let fileNum = $(this).val();
        $.ajax({
            type:'POST',
            url:'./boardFileDelete',
            data:{
                fileNum: fileNum
            },
            success:function(response){
                if(response.trim() > 0) {
                    alert('삭제되었습니다.')
                    //this : ajax 객체 자기 자신
                    console.log(ch);
                    ch.parent().parent().remove();
                    count--;
                } else {
                    alert('삭제 실패<br>관리자에게 문의하세요.')
                }
            },
            error:function(){}
        })

        /** GET 요청 **/
        // //ajax DB에서 삭제
        // $.get('URL?param1', function(response){
        //     //작업
        // })

        // //fetch
        // fetch('URL?param=1', {
        //     method: 'GET',
        // }).then((response)=>response.text())
        // .then((res)=>{
        //     //작업
        // })

        /** POST 요청 **/
        // $.post('URL', {param:1}, function(res){})

        // fetch('URL', {
        //     method: 'POST',
        //     headers: {
        //         'Content-Type' : ''
        //     },
        //     body: 'Param=1'
        // }).then((response)=>response.text())
        // .then((res)=>{
        //     //작업
        // })


    } else {
        $(this).prop('checked', false)
    }
})

//삭제
$('#fileList').on('click', '.dels', function(e){
    // let id = $(this).attr('data-dels-id');
    // $('#'+id).remove();
    $(this).parent().remove();
    count--;
})

//추가
$('#fileAdd').click(()=>{
        if(count >= max) {
            alert("첨부파일은 최대 " + max + "개까지 업로드 가능합니다.")
            return;
        } 
        
        count++;
        
        let child = '<div class="input-group mb-3" id="f'+idx+'">';
            child = child + '<input type="file" class="form-control" name="'+param+'">'
            child = child + '<button type="button" class="btn btn-outline-danger dels" data-dels-id="f'+idx+'">X</button>'
        $('#fileList').append(child);
        idx++;

})

// fileList.addEventListener("click", function(e){
//     if(e.target.classList.contains('dels')){
//         e.target.parentNode.remove();
//         // let id = e.target.getAttribute("data-dels-id");
//         // document.getElementById(id).remove();
//         count--;
//     }
// })

// fileAdd.addEventListener("click", function(){
//     if(count >= max) {
//         alert("첨부파일은 최대 " + max + "개까지 업로드 가능합니다.")
//     } else {
//         //Element들을 생성
//         let d = document.createElement('div');   //부모 div
//         // let l = document.createElement('label');    //label
//         // let t = document.createTextNode('Files');
//         let i = document.createElement('input');    //input
//         let b = document.createElement('button');   //button
//         let t2 = document.createTextNode('X');
        
//         count++;

//         //Element들을 조합
//         // d.appendChild(l);
//         // l.appendChild(t);
//         d.appendChild(i);
//         d.appendChild(b);
//         b.appendChild(t2);
    
//         //attribute 생성 적용
//         //div
//         let attr = document.createAttribute("class");
//         attr.value="input-group fw-bold fs-5 col-12 mt-3 my-3";
//         d.setAttributeNode(attr);

//         attr = document.createAttribute("id");
//         attr.value = "f" + idx;
//         d.setAttributeNode(attr);
    
//         //label
//         // attr = document.createAttribute("for")
//         // attr.value="files";
//         // l.setAttributeNode(attr);
    
//         // attr = document.createAttribute("class");
//         // attr.value="form-label";
//         // l.setAttributeNode(attr);
    
//         //input
//         attr = document.createAttribute("type");
//         attr.value="file";
//         i.setAttributeNode(attr);
    
//         attr = document.createAttribute("class");
//         attr.value="form-control";
//         i.setAttributeNode(attr);
    
//         attr = document.createAttribute("id");
//         attr.value="files";
//         i.setAttributeNode(attr);
    
//         attr = document.createAttribute("name");
//         attr.value=param;
//         i.setAttributeNode(attr);

//         //button
//         attr = document.createAttribute("type");
//         attr.value="button";
//         b.setAttributeNode(attr);

//         attr = document.createAttribute("class");
//         attr.value="btn btn-outline-danger dels";
//         b.setAttributeNode(attr);

//         attr = document.createAttribute("data-dels-id");
//         attr.value = "f" + idx;
//         b.setAttributeNode(attr);

//         idx++;

//         fileList.prepend(d);

//         //삭제-----------------------------

//         // b.addEventListener("click", function(){
//         //     d.remove();
//         //     count--;
//         // })


//     }
// })

//     fileAdd.addEventListener("click", function(){

//         if(count >= max) {
//             d.remove();
//             count = 0;
//             // alert('아쉽지만.. 파일은 1개만 업로드할 수 이떠용 >3<')
//             return;
//         }

//         count++;

//         //Element들을 조합
//         d.appendChild(l);
//         d.appendChild(i);
//         l.appendChild(t);
    
//         //attribute 생성 적용
//         //div
//         let attr = document.createAttribute("class");
//         attr.value="fw-bold fs-5 col-12 mt-3";
//         d.setAttributeNode(attr);
    
//         //label
//         attr = document.createAttribute("for")
//         attr.value="files";
//         l.setAttributeNode(attr);
    
//         attr = document.createAttribute("class");
//         attr.value="form-label";
//         l.setAttributeNode(attr);
    
//         //input
//         attr = document.createAttribute("type");
//         attr.value="file";
//         i.setAttributeNode(attr);
    
//         attr = document.createAttribute("class");
//         attr.value="form-control";
//         i.setAttributeNode(attr);
    
//         attr = document.createAttribute("id");
//         attr.value="files";
//         i.setAttributeNode(attr);
    
//         attr = document.createAttribute("name");
//         attr.value=param;
//         i.setAttributeNode(attr);
    
//         fileList.prepend(d);

// });