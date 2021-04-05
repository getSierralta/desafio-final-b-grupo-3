$(function() {
    $( ".popup" ).dialog({
        autoOpen: false,  
    });
    $( "#hope" ).click(function() {
       $( ".popup" ).dialog( "open" );
       $('#give-me-hope').get(0).play();
    });
});

$(".popup").on("mouseover",function () {
    var bodyWidth = document.body.clientWidth
    var bodyHeight = document.body.clientHeight;
    var randPosX = Math.floor((Math.random() * bodyWidth));
    var randPosY = Math.floor((Math.random() * bodyHeight));
    var posXY = 'x: ' + randPosX + '<br />' + 'y: ' + randPosY;
  
    $('.popup').parent().css('left', randPosX);
    $('.popup').parent().css('top', randPosY);
});