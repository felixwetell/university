'use strict';

$( document ).ready( function()
{
    let ajax = $.ajax(
    {
        method: 'post',
        url: 'ajaxDummy.php',
        dataType: 'json',
    } );

    ajax.done( function( data )
    {
        $( 'idAJAXData' ).text( data.datetime )
    } );
} );
