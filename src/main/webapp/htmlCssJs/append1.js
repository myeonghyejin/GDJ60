const list = document.getElementById("list");
const add = document.getElementById("add");

add.addEventListener("click",function(){
    console.log("add click");
    //<li>d</li>
    let li = document.createElement('li');//새로운 element 생성
    let text = document.createTextNode('d')//생성한 element에 text contents 추가
    li.appendChild(text);//element에 생성한 text 삽입
    list.append(li);
    
    //<li><button>click</button></li>
    let li2 = document.createElement('li');
    let button = document.createElement('button');
    let text2 = document.createTextNode('click');

    //속성 추가
    let attr = document.createAttribute('class'); 
    attr.value='btn bg';
    // attr.value=attr.value+"bg"

    button.setAttributeNode(attr);
    button.appendChild(text2);
    li2.appendChild(button);
    
    // list.append(li2);
    // list.prepend(li2);
    list.before(li2);
})