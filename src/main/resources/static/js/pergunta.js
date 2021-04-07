let set = 20;
let flag = false;
function timer(){
    var timer = setInterval(function(){
        document.getElementById('safeTimerDisplay').innerHTML='00:'+sec;
        sec--;
        if (sec < 0) {
            const xhr = new XMLHttpRequest();
            xhr.onload = function(event){ 
                window.location.replace("http://localhost:8080/loserPage"); 
            }; 
            xhr.open("POST", `/loser`); 
            xhr.send();
        }
    }, 1000);
}
function cincuenta(){
    const a = document.getElementById("a");
    const b = document.getElementById("b");
    const c = document.getElementById("c");
    const d = document.getElementById("d");
    a.style.opacity = 0;
    b.style.opacity = 0;
    c.style.opacity = 0;
    d.style.opacity = 0;
    const aA = a.innerText.split("A: ");
    const bA = b.innerText.split("B: ");
    const cA = c.innerText.split("C: ");
    const dA = d.innerText.split("D: ");
    fetch(`http://localhost:8080/api/cincuenta/${aA[1]}/${bA[1]}/${cA[1]}/${dA[1]}`)
    .then(response => response.json())
    .then(data =>         
            data.forEach(element => { 
               if(element === "a"){
                    a.style.opacity = 1;
               }else if(element === "b"){
                    b.style.opacity = 1;
                }else if(element === "c"){
                    c.style.opacity = 1;
                }else if(element === "d"){
                    d.style.opacity = 1;
                }
            })
        );  
}
function trocar(){
    const xhr = new XMLHttpRequest();
    xhr.onload = function(event){ 
        window.location.reload();
    }; 
    xhr.open("GET", '/trocarPergunta'); 
    xhr.send();
}
function help(){
    console.log("help");
}


function resposta(certa, res, res1, res2, res3, res4, dif){

    let correcta;
    switch(certa){
        case 1:
            correcta = res1;
            break;
        case 2:
            correcta = res2;
            break;
        case 3:
            correcta = res3;
            break;
        case 4:
            correcta = res4;
            break;
    }
    switch(dif){
        case "fácil":
           dif = 1;
            break;
        case "média":
            dif = 2;
            break;
        case "difícil":
            dif = 3;
            break;
        case "impossível":
            dif = 4;
            break;
    }
    const xhr = new XMLHttpRequest();
    let url;
    if(res == correcta){
        url = `/answerQuestion/${dif}/${sec}`;
        if(flag){           
            xhr.onload = function(event){ 
                document.location.href = "/winnerPage";
            };
        }else{
            xhr.onload = function(event){ 
                window.location.reload();
            }; 
        }  
    }else{
        url = `/loser`;
        xhr.onload = function(event){ 
            window.location.replace("http://localhost:8080/loserPage"); 
        }; 
    }
    xhr.open("POST", url); 
    xhr.send();
}
function setList(){
    const list = document.getElementById("list");
    const num = document.title;
    console.log(num);
    list.innerHTML = "";

    const quinze = document.createElement("li");
    quinze.innerText = "Impossible";

    const cator = document.createElement("li");
    cator.innerText = "Hard";

    const trese = document.createElement("li");
    trese.innerText = "Hard";

    const dose = document.createElement("li");
    dose.innerText = "Hard";

    const once = document.createElement("li");
    once.innerText = "Hard";

    const dez = document.createElement("li");
    dez.innerText = "Hard";

    const nove = document.createElement("li");
    nove.innerText = "Medium";
    
    const ocho = document.createElement("li");
    ocho.innerText = "Medium";
    
    const sete = document.createElement("li");
    sete.innerText = "Medium";

    const seis = document.createElement("li");
    seis.innerText = "Medium";

    const cinco = document.createElement("li");
    cinco.innerText = "Medium";

    const cuatro = document.createElement("li");
    cuatro.innerText = "Easy";

    const tres = document.createElement("li");
    tres.innerText = "Easy";

    const dos = document.createElement("li");
    dos.innerText = "Easy";

    const um = document.createElement("li");
    um.innerText = "Easy";

    if(num == 14){
        quinze.classList.add("dificulty_selected");
        sec = 60;
        flag = true;
    }
    if(num == 13){
        cator.classList.add("dificulty_selected");
        sec = 40;
    }else if(num > 13){
        cator.classList.add("dificulty_passed");
    }
    if(num == 12){
        trese.classList.add("dificulty_selected");
        sec = 40;
    }else if(num > 12){
        trese.classList.add("dificulty_passed");
    }
    if(num == 11){
        dose.classList.add("dificulty_selected");
        sec = 40;
    }else if(num > 11){
        dose.classList.add("dificulty_passed");
    }
    if(num == 10){
        once.classList.add("dificulty_selected");
        sec = 40;
    }else if(num > 10){
        once.classList.add("dificulty_passed");
    }
    if(num == 9){
        dez.classList.add("dificulty_selected");
        sec = 40;
    }else if(num > 9){
        dez.classList.add("dificulty_passed");
    }
    if(num == 8){
        nove.classList.add("dificulty_selected");
        sec = 30;
    }else if(num > 8){
        nove.classList.add("dificulty_passed");
    }
    if(num == 7){
        ocho.classList.add("dificulty_selected");
        sec = 30;
    }else if(num > 7){
        ocho.classList.add("dificulty_passed");
    }
    if(num == 6){
        sete.classList.add("dificulty_selected");
        sec = 30;
    }else if(num > 6){
        sete.classList.add("dificulty_passed");
    }
    if(num == 5){
        seis.classList.add("dificulty_selected");
        sec = 30;
    }else if(num > 5){
        seis.classList.add("dificulty_passed");
    }
    if(num == 4){
        cinco.classList.add("dificulty_selected");
        sec = 30;
    }else if(num > 4){
        cinco.classList.add("dificulty_passed");
    }
    if(num == 3){
        cuatro.classList.add("dificulty_selected");
        sec = 20;
    }else if(num > 3){
        cuatro.classList.add("dificulty_passed");
    }
    if(num == 2){
        tres.classList.add("dificulty_selected");
        sec = 20;
    }else if(num > 2){
        tres.classList.add("dificulty_passed");
    }
    if(num == 1){
        dos.classList.add("dificulty_selected");
        sec = 20;
    }else if(num > 1){
        dos.classList.add("dificulty_passed");
    }
    if(num == 0){
        um.classList.add("dificulty_selected");
        sec = 20;
    }else if(num > 0){
        um.classList.add("dificulty_passed");
    }
    list.appendChild(quinze);
    list.appendChild(cator);
    list.appendChild(trese);
    list.appendChild(dose);
    list.appendChild(once);
    list.appendChild(dez);
    list.appendChild(nove);
    list.appendChild(ocho);
    list.appendChild(sete);
    list.appendChild(seis);
    list.appendChild(cinco);
    list.appendChild(cuatro);
    list.appendChild(tres);
    list.appendChild(dos);
    list.appendChild(um); 
    console.log(set);
    timer();   
}
setList();
