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
    if($(this).prop('checked')){
        let result = confirm('파일을 삭제하시겠습니까?')
        if(result) {
            count--;
        } else {
            $(this).prop('checked', false);
        }
    } else {
        if(count == max) {
            $('#f'+(idx-1)).remove();
        } else {
            count++;
        }
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