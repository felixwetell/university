$(document).bind('touchmove', function(e) {
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
    	paddingTop: '3em',
    	paddingBottom: '10px',
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
