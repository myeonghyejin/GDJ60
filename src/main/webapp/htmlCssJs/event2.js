const b1 = document.getElementById("b1"); //button
const p1 = document.getElementById("p1"); //div
const b2 = document.getElementById("b2"); //button
const p2 = document.getElementById("p2"); //div

const naver = document.getElementById("naver"); //a
naver.addEventListener("click",function(event){
    console.log("naver click");
    event.preventDefault();
})

//캡쳐링 - 부모에서부터 자식으로 전파
b1.addEventListener("click",function(e){
    console.log('button click');
    console.log(e);
},true)

p1.addEventListener("click", function(event){
    console.log("div click");
    console.log(event);
    event.stopPropagation(); // 부모의 event를 stop
},true)

//버블링 -자식에서부터 부모로 전파
b2.addEventListener("click",function(e){
    console.log('button2 click');
    console.log(e);
    console.log("button this",this);
    // e.stopPropagation(); // 자식의 event를 stop
},false)

p2.addEventListener("click", function(event){
    console.log("div2 click");
    console.log(event);
    console.log("currentTarget: ",event.currentTarget); // 클릭이 어디까지 전달되었나
    console.log("targer : ",event.target); //실제로 클릭한것
    console.log("this",this);
},false)