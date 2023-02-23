const pl = document.getElementsByClassName("page-link");
const searchForm = document.getElementById("searchForm");
let page = document.getElementById("page");

//for
// for(let i=0; i < pl.length; i++) {
//     pl[i].addEventListener("click", function(){
//         console.log("yeah~")
//     })
// }

//for of        -- for(꺼낸타입명 변수명 : Collection)
for(let p of pl){
    p.addEventListener("click", function(e){
        let v = p.getAttribute("data-board-page");
        page.value=v;
        searchForm.submit();
    })
}