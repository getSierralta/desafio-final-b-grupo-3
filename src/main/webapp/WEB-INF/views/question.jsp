<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/loser_style.css">
    <link rel="stylesheet" href="../css/question_style.css">
    <title>${perguntaN}</title>
</head>
<body>
     <div class="wrap">
         <div class="header_question">

             <ul class="list" id="list">

             </ul>
             <img class="logo_question" src="../img/logo.png" alt="Logo"/>
             <div class="button_list">
                 <button class="retro_button" onclick="cincuenta()" >
                   <img src="../img/5050.png" width="100" height="35" alt="5050" />
                 </button>
                 <button class="retro_button" onclick="trocar()">
                   <img src="../img/switch.png" width="100" height="35" alt="Switch"/>
                 </button>
                 <button class="retro_button" onclick="help()">
                   <img src="../img/public.png" width="100" height="35" alt="Public Help"/>
                 </button>
                 <button class="retro_button">
                   <img id="hope" src="../img/hope.png" width="100" height="35" alt="Hope"/>
                 </button>
                 <div id="safeTimer">
                    <p id="safeTimerDisplay">00:30</p>
                  </div>
             </div>
         </div>
         <div class="question_box">
         <img id="skull" src="../img/skull.gif" alt="Skull"/>
             <div class="question">
                 <span>Q: ${pergunta.getPergunta()} </span>
             </div>
         </div>
         <div class="answer_box">
             <div id="a" class="option_box" onclick="resposta(${pergunta.getCerta()}, '${pergunta.getShuffle().get(0)}', '${pergunta.getResposta1()}', '${pergunta.getResposta2()}', '${pergunta.getResposta3()}', '${pergunta.getResposta4()}', '${pergunta.getDificuldade()}')">
                 <div class="answer">A: ${pergunta.getShuffle().get(0)}</div>
             </div>
             <div id="b" class="option_box" onclick="resposta(${pergunta.getCerta()}, '${pergunta.getShuffle().get(1)}', '${pergunta.getResposta1()}', '${pergunta.getResposta2()}', '${pergunta.getResposta3()}', '${pergunta.getResposta4()}', '${pergunta.getDificuldade()}')">
                 <div class="answer">B: ${pergunta.getShuffle().get(1)} </div>
             </div>
             <div id="c" class="option_box" onclick="resposta(${pergunta.getCerta()}, '${pergunta.getShuffle().get(2)}', '${pergunta.getResposta1()}', '${pergunta.getResposta2()}', '${pergunta.getResposta3()}', '${pergunta.getResposta4()}', '${pergunta.getDificuldade()}')">
                 <div class="answer">C: ${pergunta.getShuffle().get(2)}</div>
             </div>
             <div id="d" class="option_box" onclick="resposta(${pergunta.getCerta()}, '${pergunta.getShuffle().get(3)}', '${pergunta.getResposta1()}', '${pergunta.getResposta2()}', '${pergunta.getResposta3()}', '${pergunta.getResposta4()}', '${pergunta.getDificuldade()}')">
                 <div class="answer">D: ${pergunta.getShuffle().get(3)}</div>
             </div>
         </div>
         <div class="infoGame">
             <div class="left_hand"></div>
             <a href="<c:url value="/logout" />">Quit</a>
             <div class="right_hand"></div>
         </div>
    </div>
    <div class="popup" title="Hope">
        <div class="pop-body">
            <video id="give-me-hope" loop>
                <source src="../video/hope.mp4" type="video/mp4">
            </video>
        </div>
    </div>
    <script src="../js/pergunta.js"></script>
    <script src="../js/hope.js"></script>
</body>
</html>