$(function() {
    $( ".popup" ).dialog({
       autoOpen: false,  
    });
    $( "#rank" ).click(function() {
       $( ".popup" ).dialog( "open" );
    });
});
$(function() {
    $( ".popupHighscore" ).dialog({
        autoOpen: false,
    });
    $( "#highscore" ).click(function() {
        $( ".popupHighscore" ).dialog( "open" );
    });
});
$(function() {
    $( ".popup-login" ).dialog({
       autoOpen: false,
    });
    $( "#login" ).click(function() {
       $( ".popup-login" ).dialog( "open" );
    });
});
$(function() {
    $( ".popup-register" ).dialog({
       autoOpen: false,
    });
    $( "#register" ).click(function() {
       $( ".popup-register" ).dialog( "open" );
    });
});
$(function() {
    $( ".popup-recover-pass" ).dialog({
       autoOpen: false,
    });
    $( "#recover-pass" ).click(function() {
       $( ".popup-recover-pass" ).dialog( "open" );
    });
});
$(function() {
    $( ".popup-change-password" ).dialog({
        autoOpen: false,
    });
    $( "#changePassword" ).click(function() {
        $( ".popup-change-password" ).dialog( "open" );
    });
});