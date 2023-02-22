const fileAdd = document.getElementById("fileAdd");
const fileList = document.getElementById("fileList");

let count = 0;
let max = 1;
let param = 'multipartFile';

function setMax(m) {
    max = m;
};

function setParam(p) {
    param = p;
}

//Element들을 생성
let d = document.createElement('div');   //부모 div
let l = document.createElement('label');    //label
let t = document.createTextNode('Image');
let i = document.createElement('input');    //input

    fileAdd.addEventListener("click", function(){

        if(count >= max) {
            d.remove();
            count = 0;
            // alert('아쉽지만.. 파일은 1개만 업로드할 수 이떠용 >3<')
            return;
        }

        count++;

        //Element들을 조합
        d.appendChild(l);
        d.appendChild(i);
        l.appendChild(t);
    
        //attribute 생성 적용
        //div
        let attr = document.createAttribute("class");
        attr.value="fw-bold fs-5 col-12 mt-3";
        d.setAttributeNode(attr);
    
        //label
        attr = document.createAttribute("for")
        attr.value="files";
        l.setAttributeNode(attr);
    
        attr = document.createAttribute("class");
        attr.value="form-label";
        l.setAttributeNode(attr);
    
        //input
        attr = document.createAttribute("type");
        attr.value="file";
        i.setAttributeNode(attr);
    
        attr = document.createAttribute("class");
        attr.value="form-control";
        i.setAttributeNode(attr);
    
        attr = document.createAttribute("id");
        attr.value="files";
        i.setAttributeNode(attr);
    
        attr = document.createAttribute("name");
        attr.value=param;
        i.setAttributeNode(attr);
    
        fileList.prepend(d);

});