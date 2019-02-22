$(document).on('touchmove', function(e) {
	e.preventDefault();
});

$( function() {
    new fullpage('#gameFullpage',
    {
		licenseKey: 'OPEN-SOURCE-GPLV3-LICENSE',
		anchors: ['start', 'question1', 'question2', 'question3', 'question4', 'question5', 'result'],

    	//Scrolling
    	css3: true,
    	scrollingSpeed: 1200,
    	autoScrolling: true,
    	fitToSection: true,
    	fitToSectionDelay: 1000,
    	scrollBar: true,
    	easing: 'easeInOutCubic',
    	easingcss3: 'ease',
    	fadingEffect: true,

    	//Accessibility
    	keyboardScrolling: true,
    	animateAnchor: true,
    	recordHistory: true,

    	//Design
    	controlArrows: true,
    	verticalCentered: true,
    	sectionsColor : ['#fff', '#f9ca24', '#f0932b', '#eb4d4b', '#6ab04c', '#be2edd', '#fff'],
    	paddingTop: '1em',
    	paddingBottom: '1em',
    	fixedElements: '#header, .footer',
    	responsiveWidth: 0,
    	responsiveHeight: 0,
    	responsiveSlides: false,
    	parallax: false,
    	parallaxOptions: {type: 'reveal', percentage: 62, property: 'translate'},

    	//Custom selectors
    	sectionSelector: '.section',
    	slideSelector: '.slide',

    	lazyLoading: true,

    	//events
    	onLeave: function(origin, destination, direction){},
    	afterLoad: function(origin, destination, direction){},
    	afterRender: function(){},
    	afterResize: function(width, height){},
    	afterResponsive: function(isResponsive){},
    	afterSlideLoad: function(section, origin, destination, direction){},
    	onSlideLeave: function(section, origin, destination, direction){}
    });
});

// $( 'form input' ).on( 'click', function( e )
// {
//
// 	let input = $(this);
// 	let label = input.parent();
// 	console.log(label);
// 	label.addClass( 'active' );
// } );

 $("form section input").click(function ()
{
	let input = $(this);
	let group = input.attr( 'name' );

	var i = 0;
	$( 'input[name=' + group + ']' ).each( function()
	{
		i++;
		switch( $(this).is( ':checked' ) )
		{
			case true:
				$(this).parent().addClass( 'active' );
				console.log( i + ' ' + $(this).is( ':checked' ) );
				break;

			case false:
				console.log( i + ' ' + $(this).is( ':checked' ) );
				$(this).parent().removeClass( 'active' );

				break;
			default:
				console.log( 'Something went wrong' );
				break;
		}
	});
} );

// $("form section input").click(function () {
//
//
// 	let input = $(this);
// 	console.log( input.is( ':checked' ) );
// 	let group = input.attr( 'name' );
// 	let label = input.parent();
//
// 	$( 'input[name=' + group + ']' ).each( function()
// 	{
// 		if( $(this).is( ':checked' ) )
// 		{
// 			console.log($(this));
// 			label.addClass( 'active' );
// 		}
// 		else
// 		{
// 			// console.log('remove');
// 			label.removeClass( 'active' );
//
// 		}
// 	} );
// });
