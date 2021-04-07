<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/winner_style.css" >
    <title>You Won ${name}!</title>
</head>
<body>
    <div class="wrap">
        <div class="header">
            <img class="logo" src="../img/logo.png" alt="Logo"/>
        </div>
        <div class="dash">
            <div>
                <div class="info" id="spinner">
                    <p>Score ${score}</p>
                </div>
                <img src="../img/dance.gif" style="max-height: 15rem;" alt="Head"/>
            </div>
            <div class="menu">
                <div class="infoLoser">
                    <h4>${name}<br>
                        YOU WON</h4>
                </div>
                <div class="infoGame">
                    <div class="left_hand"></div>
                    <a href="/question">Play again</a>
                    <div class="right_hand"></div>
                </div>
                <div class="infoGame">
                    <div class="left_hand"></div>
                    <a href="/dashboard"> Dashboard</a>
                    <div class="right_hand"></div>
                </div>
                <div class="infoGame">
                    <div class="left_hand"></div>
                    <a href="/logout">Quit</a>
                    <div class="right_hand"></div>
                </div>
            </div>
            <div>
                <div class="info" id="spinner">
                    <p>Score ${score}</p>
                </div>
                <img src="../img/dance.gif" style="max-height: 15rem; transform: scaleX(-1);" alt="Head"/>
            </div>
        </div>
        </div>
    </div>
</body>
</html>