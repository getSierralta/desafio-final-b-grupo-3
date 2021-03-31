$(function() {
    $( ".popup" ).dialog({
       autoOpen: false,  
    });
    $( "#rank" ).click(function() {
       $( ".popup" ).dialog( "open" );
    });
});