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