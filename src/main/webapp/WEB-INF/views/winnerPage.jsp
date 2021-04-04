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
                    <p>Score 1000${score}</p>
                </div>
                <img src="../img/dance.gif" style="max-height: 15rem;" alt="Head"/>
            </div>
            <div class="menu">
                <div class="infoLoser">
                    <h4>Congratulations PLAYER${name}<br>
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
                    <p>Score 1000${score}</p>
                </div>
                <img src="../img/dance.gif" style="max-height: 15rem; transform: scaleX(-1);" alt="Head"/>
            </div>
        </div>
        <div class="popup" title="RANKING">
            <div class="pop-body">
                <div class="rank">
                    <img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/>
                    <p>1 David Meowie 165 pts</p>
                </div>
                <div class="rank">
                    <img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/>
                    <p>2 Jenipurr Lopez 142 pts</p>
                </div>
                <div class="rank">
                    <img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/>
                    <p>3 Peter Barker 45 pts</p>
                </div>
                <div class="rank">
                    <img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/>
                    <p>4 Mark Buffalo 38 pts</p>
                </div>
                <div class="rank">
                    <img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/>
                    <p>5 Corgi Maguaire 27 pts</p>
                </div>
                <div class="rank">
                    <img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/>
                    <p>6 Britney Squirrels 26 pts</p>
                </div>
                <div class="rank">
                    <img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/>
                    <p>7 Llama del Rey 19 pts</p>
                </div>
                <div class="rank">
                    <img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/>
                    <p>8 Justin Beaver 15 pts</p>
                </div>
                <div class="rank">
                    <img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/>
                    <p>9 ProgHamster 12 pts</p>
                </div>
                <div class="rank">
                    <img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/>
                    <p>10 Kitty Minaj 9 pts</p>
                </div>
            </div>
        </div>
    </div>
    <script src="../js/popup.js"></script>
</body>
</html>