<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>


<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/style.css">
    <title>Hello ${name}!</title>
</head>

<body class="container blue ">
    <main class="main">

        <div class="object_container forms">
            <form class="thiago-fix-this" id="thiago-fix-this-too" action="/new-question/register" method="POST">
                <input type="text" name="pergunta" placeholder="Pergunta" required="required" />
                <input type="text" name="r1" placeholder="Primeira resposta" required="required" />
                <input type="text" name="r2" placeholder="Segunda resposta" required="required" />
                <input type="text" name="r3" placeholder="Terceira resposta" required="required" />
                <input type="text" name="r4" placeholder="Quarta resposta" required="required" />
                <input type="text" name="certa" placeholder="Resposta certa" required="required" />
                <input type="text" name="dificuldade" placeholder="Nível de dificuldade" required="required" />
                <button class="thiago-fix-this-class" type="submit">Register</button>
            </form>
        </div>
        <div class="infoGame">
             <div class="left_hand"></div>
             <a href="/logout">Quit</a>
             <div class="right_hand"></div>
         </div>
    </main>
</body>

</html>