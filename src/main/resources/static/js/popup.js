$(function() {
    $( ".popup" ).dialog({
       autoOpen: false,  
    });
    $( "#rank" ).click(function() {
       $( ".popup" ).dialog( "open" );
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