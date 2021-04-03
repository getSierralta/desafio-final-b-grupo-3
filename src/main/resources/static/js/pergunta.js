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
    }
    if(num == 13){
        cator.classList.add("dificulty_selected");
    }else if(num > 13){
        cator.classList.add("dificulty_passed");
    }
    if(num == 12){
        trese.classList.add("dificulty_selected");
    }else if(num > 12){
        trese.classList.add("dificulty_passed");
    }
    if(num == 11){
        dose.classList.add("dificulty_selected");
    }else if(num > 11){
        dose.classList.add("dificulty_passed");
    }
    if(num == 10){
        once.classList.add("dificulty_selected");
    }else if(num > 10){
        once.classList.add("dificulty_passed");
    }
    if(num == 9){
        dez.classList.add("dificulty_selected");
    }else if(num > 9){
        dez.classList.add("dificulty_passed");
    }
    if(num == 8){
        nove.classList.add("dificulty_selected");
    }else if(num > 8){
        nove.classList.add("dificulty_passed");
    }
    if(num == 7){
        ocho.classList.add("dificulty_selected");
    }else if(num > 7){
        ocho.classList.add("dificulty_passed");
    }
    if(num == 6){
        sete.classList.add("dificulty_selected");
    }else if(num > 6){
        sete.classList.add("dificulty_passed");
    }
    if(num == 5){
        seis.classList.add("dificulty_selected");
    }else if(num > 5){
        seis.classList.add("dificulty_passed");
    }
    if(num == 4){
        cinco.classList.add("dificulty_selected");
    }else if(num > 4){
        cinco.classList.add("dificulty_passed");
    }
    if(num == 3){
        cuatro.classList.add("dificulty_selected");
    }else if(num > 3){
        cuatro.classList.add("dificulty_passed");
    }
    if(num == 2){
        tres.classList.add("dificulty_selected");
    }else if(num > 2){
        tres.classList.add("dificulty_passed");
    }
    if(num == 1){
        dos.classList.add("dificulty_selected");
    }else if(num > 1){
        dos.classList.add("dificulty_passed");
    }
    if(num == 0){
        um.classList.add("dificulty_selected");
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
        case "medía":
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
        url = `/answerQuestion/${dif}/10`;
        xhr.onload = function(event){ 
            window.location.reload();
        }; 
    }else{
        url = `/loser`;
        xhr.onload = function(event){ 
            window.location.replace("http://localhost:8080/loserPage"); 
        }; 
    }
    xhr.open("POST", url); 
    xhr.send();
}
setList();