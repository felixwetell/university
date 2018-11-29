'use strict';

$(document).ready( function()
{
    let div = $( 'div' );
    let ol = $( '<ol>' )
    let list = $( 'span' );

    div.prepend( ol );

    list.each( function()
    {
        let span = $(this).attr( 'id' );
        let strong = $(this).find( 'strong' ).text();

        ol.append( `<li><a href="${strong}">${span}</a></li>` );
    } );
} );
