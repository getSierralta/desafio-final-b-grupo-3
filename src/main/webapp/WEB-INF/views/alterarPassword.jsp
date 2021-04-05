<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../../css/style.css">
    <title>New Password</title>
</head>
<body>
    <div class="wrap">
        <div class="header">
            <img class="logo" src="../img/logo.png" alt="Logo"/>
        </div>
        <div class="menu">
            <div class="option">
                <div class="left_hand"></div>
                <p id="changePassword" class="menu_title"  alt="changePassword"> New Password</p>
                <div class="right_hand"></div>
            </div>
        </div>
    </div>


    <div class="popup-change-password" title="New Password">
            <div class="recover-img-wrapper">
                <div class="recover-img">
                    <img src="../img/recover_pic.png" alt="Recover Image"/>
                </div>
            </div>
            <div class="recover-form">
                <form id="recover" method="post" action="/alterarPassword" id="recover">
                    <input type="hidden" id="username" name="username" value="${username}">
                    <label for="password">New Password:</label><br>
                    <input type="password" id="password" name="password" required><br>
                    <label for="confirmPassword">Confirm Password:</label><br>
                    <input type="password" id="confirmPassword" name="confirmPassword" required><br>
                    <input class="submit-button" type="submit" value="Submit">
                </form>
            </div>
        </div>
    <script src="../js/popup.js"></script>
</body>
</html>