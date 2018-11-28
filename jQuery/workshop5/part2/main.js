'use strict';

$( document ).ready( function()
{
    $( 'span a' ).on( 'mouseenter', function()
    {
        $( '.divClass' ).fadeIn( 'slow' );
    } );
    $( 'span a' ).on( 'mouseleave', function()
    {
        $( '.divClass' ).fadeOut( 'slow' );
    } );

    $( 'div a' ).on( 'click', function( e )
    {
        e.preventDefault();
        let a = $(this);

        if( a.hasClass == 'animation' )
        {
            a.removeClass( 'animation' );
            console.log(a);
        }
        else
        {
            a.addClass( 'animation' );
            console.log(a);
        }
    } );
} );
