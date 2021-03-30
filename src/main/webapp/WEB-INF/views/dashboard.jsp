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
        <div class="menu">
            <div class="option">
                <img class="left_hand" src="../img/hand.png" alt="Left Hand"/>
                <img class="menu_title" src="../img/play.svg" alt="Play"/>
                <img class="right_hand" src="../img/hand.png" alt="Right Hand"/>
            </div>
            <div class="option">
                <img class="left_hand" src="../img/hand.png" alt="Left Hand"/>
                <img class="menu_title" src="../img/hs.svg" alt="High Scores"/>
                <img class="right_hand" src="../img/hand.png" alt="Right Hand"/>
            </div>
            <div class="option">
                <img class="left_hand" src="../img/hand.png" alt="Left Hand"/>
                <img id="rank" class="menu_title" src="../img/rank.svg" alt="Ranking"/>
                <img class="right_hand" src="../img/hand.png" alt="Right Hand"/>
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