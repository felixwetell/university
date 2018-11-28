'use strict';

$( document ).ready( function()
{
    let list = $( 'abbr' );

    list.each( function()
    {
        let abbr = $( this );
        let link = abbr.find( 'a' ).attr( 'href' );
        let title = abbr.attr( 'title' );

        $( 'div' ).prepend( `<p><a href="${ link }">${ title }</a></p>` )
    } );
} );
