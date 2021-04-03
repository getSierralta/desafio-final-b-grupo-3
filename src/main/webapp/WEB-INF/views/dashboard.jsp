<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <title>Hello ${name}!</title>
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
                    <p>125</p>
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
                    <img class="menu_title" src="../img/hs.svg" alt="High Scores"/>
                    <div class="right_hand"></div>
                </div>
                <div class="option">
                    <div class="left_hand"></div>
                    <img id="rank" class="menu_title" src="../img/rank.svg" alt="Ranking"/>
                    <div class="right_hand"></div>
                </div>
            </div>
            <div>
                <div class="info" id="spinner">
                    <p>QUESTIONS</p>
                    <p>450</p>
                </div>
                <img src="../img/head.gif" style="max-height: 15rem; transform: scaleX(-1);" alt="Head"/>
            </div>
        </div>
        <div class="popup" title="Ranking">
            <div class="pop-body">
                <div class="rank">
                    <div class="profile-pic-wrapper"><img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/></div>
                    <p>1 David Meowie 165 pts</p>
                </div>
                <div class="rank">
                    <div class="profile-pic-wrapper"><img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/></div>
                    <p>2 Jenipurr Lopez 142 pts</p>
                </div>
                <div class="rank">
                    <div class="profile-pic-wrapper"><img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/></div>
                    <p>3 Peter Barker 45 pts</p>
                </div>
                <div class="rank">
                    <div class="profile-pic-wrapper"><img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/></div>
                    <p>4 Mark Buffalo 38 pts</p>
                </div>
                <div class="rank">
                    <div class="profile-pic-wrapper"><img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/></div>
                    <p>5 Corgi Maguaire 27 pts</p>
                </div>
                <div class="rank">
                    <div class="profile-pic-wrapper"><img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/></div>
                    <p>6 Britney Squirrels 26 pts</p>
                </div>
                <div class="rank">
                    <div class="profile-pic-wrapper"><img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/></div>
                    <p>7 Llama del Rey 19 pts</p>
                </div>
                <div class="rank">
                    <div class="profile-pic-wrapper"><img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/></div>
                    <p>8 Justin Beaver 15 pts</p>
                </div>
                <div class="rank">
                    <div class="profile-pic-wrapper"><img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/></div>
                    <p>9 ProgHamster 12 pts</p>
                </div>
                <div class="rank">
                    <div class="profile-pic-wrapper"><img class="profile-pic" src="../img/palm.png" alt="Profile Pic"/></div>
                    <p>10 Kitty Minaj 9 pts</p>
                </div>
            </div>
        </div>
        <div class="infoGame">
         <div class="left_hand"></div>
         <a href="/logout">Quit</a>
         <div class="right_hand"></div>
        </div>
    </div>
    <script src="../js/popup.js"></script>
</body>
</html>