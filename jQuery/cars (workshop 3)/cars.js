"use strict";

$(document).ready( function()
{
    let span = $( '#sitecontent p span' );

    $( 'body' ).addClass( 'backgroundGradient' );

    $( '#sitecontent' ).prepend( '<p id="errorMsg"></p>' );
    $( '#btnReset' ).on( 'click', function( e )
    {
        $( '#errorMsg' ).empty();
    } );

    var elements = $( '.borderClass' );
    var length = elements.length;
    elements.each( function( )
    {
        let div = $(this);
        let remove = div.find( 'a' );
        let a = $( '<a href="#">' + $(this).find( 'p' ).first().attr( 'data-fabrikat' ) + '</a>' );

        div.hide();
        div.before( a );

        a.on( 'click', function( e )
        {
            e.preventDefault();
            e.stopPropagation();
            if( div.is( ":visible" ) )
            {
                div.fadeOut();
            }
            else
            {
                div.fadeIn();
            }
        } );

        remove.on( 'click', function( e )
        {
            if( confirm( 'Vill du verkligen ta bort bilen?' ) )
            {
                div.fadeOut( 'slow', function()
                {
                    $(this).remove();
                } );
                a.fadeOut( 'slow', function()
                {
                    $(this).remove();
                } );
                length--;
                span.fadeOut( 500, function()
                {
                    $(this).text( length ).fadeIn( 'slow' );
                } );
            }
        } );
    } );

    $( 'form' ).on( 'submit', function( e )
    {
        e.preventDefault();
        e.stopPropagation();
        let fabrikat = $( "#txtFabrikat" ).val();
        let modell = $( "#txtModell" ).val();
        let regnr = $( "#txtRegNr" ).val();

        if( fabrikat === "", modell === "", regnr === "" )
        {
            $( '#errorMsg' ).text( 'Alla rutor är inte ifyllda' );
        }
        else
        {
            var html = '<div class="borderClass">' + '\n' + `<p data-fabrikat="${fabrikat}">Fabrikat: ${fabrikat}</p>` +
            '\n' + `<p>Modell: ${modell}</p>` + '\n' + `<p>Regnr: ${regnr}</p>` + '\n' + '<a href="#">Ta bort</a>' + '</div>';
            $( '#myId' ).fadeIn( 'slow', function()
            {
                $(this).before( '<a href="#">' + $( "#txtFabrikat" ).val() + '</a>' );
            } );
            $( '#myId' ).fadeIn( 'slow', function()
            {
                $(this).before( html );
            } );

            length++;
            span.fadeOut( 500, function()
            {
                $(this).text( length ).fadeIn( 'slow' );
            } );
        }
    } );
} );
