'use strict';
$( document ).ready( function()
{
    let text1 = $( '#text1' );
    let text2 = $( '#text2' );

    let ajax = $.ajax(
    {
        url: 'sendData.php',
        method: 'get',
        dataType: 'json',
        data:
        {
            serverattr1: text1,
            serverattr2: text2,
        },
        success: function( data )
        {
            alert( `serverattr1: ${data.serverattr1}` + '\n' + `serverattr2: ${data.serverattr2}` )
        },
        error: function( data )
        {
            alert( 'Det gick inte att kommunicera med servern. Var god försök igen!' )
    } );
} );
