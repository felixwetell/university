'use strict';

$( document ).ready( function()
{
    $( 'abbr' ).on( 'click', function( e )
    {
        let abbr = $( this );
        let text = abbr.text();
        let title = abbr.attr( 'title' );

        abbr.attr( 'title', text );
        abbr.text( title );
    } );

    $( 'section p' ).on( 'mouseenter', function()
    {
        let div = $( 'section div' );
        let p = div.find( 'p' );
        let html = p.clone();
        div.append(  + '<br>' );
    } );
} );
