document.getElementById("cont").style.display="none";
var x =document.getElementsByTagName("td");
var i;
var text = document.getElementById("cont");
for (i = 0; i < x.length; i++) {
    x[i].addEventListener("click",function myfon(){

            text.style.display = "block";


    })
}
