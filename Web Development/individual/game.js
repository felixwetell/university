$( function() {
    new fullpage('#gameFullpage',
    {
        licenseKey: 'OPEN-SOURCE-GPLV3-LICENSE',

    	//Scrolling
    	css3: true,
    	scrollingSpeed: 900,
    	autoScrolling: true,
    	fitToSection: true,
    	fitToSectionDelay: 1000,
    	scrollBar: true,
    	easing: 'easeInOutCubic',
    	easingcss3: 'ease',
    	loopBottom: false,
    	loopTop: false,
    	loopHorizontal: false,
    	continuousVertical: false,
    	continuousHorizontal: false,
    	scrollHorizontally: false,
    	interlockedSlides: false,
    	dragAndMove: false,
    	offsetSections: false,
    	resetSliders: false,
    	fadingEffect: true,
    	normalScrollElements: '#element1, .element2',
    	scrollOverflow: false,
    	scrollOverflowReset: false,
    	scrollOverflowOptions: null,
    	touchSensitivity: 0,
    	normalScrollElementTouchThreshold: 5,
    	bigSectionsDestination: null,

    	//Accessibility
    	keyboardScrolling: false,
    	animateAnchor: true,
    	recordHistory: true,

    	//Design
    	controlArrows: true,
    	verticalCentered: true,
    	sectionsColor : ['#535c68', '#686de0', '#e056fd', '#000'],
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
