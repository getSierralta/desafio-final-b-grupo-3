<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <title>Hello ${user.getName()}!</title>
</head>
<body>
    <div class="wrap">
        <div class="header">
            <img class="logo" src="../img/logo.png" alt="Logo"/>
        </div>
        <div class="dash">
            <div>
                <div class="info" id="spinner">
                    <p>GAMERS</p>
                    <p>${players}</p>
                </div>
                <img src="../img/head.gif" style="max-height: 15rem;" alt="Head"/>
            </div>
            <div class="menu">
                <div class="option">
                    <div class="left_hand"></div>
                    <a href="/question"> <img class="menu_title" src="../img/play.svg" alt="Play"/></a>
                    <div class="right_hand"></div>
                </div>
                <div class="option">
                    <div class="left_hand"></div>
                    <img id="highscore" class="menu_title" src="../img/hs.svg" alt="High Scores"/>
                    <div class="right_hand"></div>
                </div>
                <div class="option">
                    <div class="left_hand"></div>
                    <img id="rank" class="menu_title" src="../img/rank.svg" alt="Ranking"/>
                    <div class="right_hand"></div>
                </div>
               <div class="option">
                   <div class="left_hand"></div>
                    <p id="login" class="menu_title" > New Question</p>
                   <div class="right_hand"></div>
               </div>
                <div class="option">
                    <div class="left_hand"></div>
                    <a href="<c:url value="/logout" />">Quit</a>
                    <div class="right_hand"></div>
                </div>
            </div>
            <div>
                <div class="info" id="spinner">
                    <p>QUESTIONS</p>
                    <p>${questions}</p>
                </div>
                <img src="../img/head.gif" style="max-height: 15rem; transform: scaleX(-1);" alt="Head"/>
            </div>
        </div>
        <div class="popup" title="Ranking">
            <div class="pop-body">
                <c:forEach var="highscore" items="${highscores}">
                    <div class="rank">
                        <div class="profile-pic-wrapper"><img class="profile-pic" src="..${user.getProfilePicture()}" alt="Profile Pic"/></div>
                        <p>  ${highscore.getUser().getName()} ${highscore.getHighscore()} pts</p>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="popupHighscore" title="Highscore">
            <div class="pop-body">
                    <div class="rank">
                        <div class="profile-pic-wrapper"><img class="profile-pic" src="..${user.getProfilePicture()}" alt="Profile Pic"/></div>
                        <c:if test="${user.getHighscore()==null}">
                            <p> Your need to play first to see your glorious score ${user.getName()}</p>
                        </c:if>
                        <c:if test="${user.getHighscore()!=null}">
                        <p> Your highscore is ${user.getHighscore().getHighscore()} pts</p>
                        </c:if>
                    </div>
            </div>
        </div>
        <div class="popup-question" title="Nova Pergunta">
                <div class="question-img-wrapper">
                    <div class="question-img">
                        <img src="../img/submit_question.png" alt="Login Image"/>
                    </div>
                </div>
                <div class="question-form">
                    <form id="question" method="post" action="/new-question/register" id="login">
                        <label for="pergunta">Pergunta:</label><br>
                        <input type="text" name="pergunta" required="required" />
                        <label for="username">Resposta 1:</label><br>
                        <input type="text" name="r1" required="required" />
                        <label for="username">Resposta 2:</label><br>
                        <input type="text" name="r2" required="required" />
                        <label for="username">Resposta 3:</label><br>
                        <input type="text" name="r3" required="required" />
                        <label for="username">Resposta 4:</label><br>
                        <input type="text" name="r4" required="required" />
                        <label for="username">Nº Resposta certa:</label><br>
                        <input type="text" name="certa" required="required" />
                        <label for="username">Nível de dificuldade:</label><br>
                        <input type="text" name="dificuldade" required="required" />
                        <input class="submit-button" type="submit" value_"Submit">
                    </form>
                </div>
            </div>
    </div>
    <script src="../js/popup.js"></script>
</body>
</html>