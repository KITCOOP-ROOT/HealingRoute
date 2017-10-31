(function($) {
	skel.breakpoints({
		xlarge:	'(max-width: 1680px)',
		large:	'(max-width: 1280px)',
		medium:	'(max-width: 980px)',
		small:	'(max-width: 736px)',
		xsmall:	'(max-width: 480px)'
	});

	$(function() {
		var	$window = $(window),
			$body = $('body'),
			$header = $('#header'),
			$footer = $('#footer');
 
		// Disable animations/transitions until the page has loaded.
			$body.addClass('is-loading');

			$window.on('load', function() {
				window.setTimeout(function() {
					
					$body.removeClass('is-loading');
				}, 100);
			});

		// Fix: Placeholder polyfill.
			$('form').placeholder();

		// Prioritize "important" elements on medium.
			skel.on('+medium -medium', function() {
				$.prioritize(
					'.important\\28 medium\\29',
					skel.breakpoint('medium').active
				);
			});

		// Header.
			$header.each( function() {

				var t 		= jQuery(this),
					button 	= t.find('.button');

				button.click(function(e) {
					
					t.toggleClass('hide');
					if ( t.hasClass('preview') ) {
						return true;
					} else {
						e.preventDefault();
					}

				});

			});

		// Footer.
			$footer.each( function() {

				var t 		= jQuery(this),
					inner 	= t.find('.inner'),
					button 	= t.find('.info');

				button.click(function(e) {
					t.toggleClass('show');
					e.preventDefault();
				});

			});
			
		// Main Scroll 
			var count = 4, size = 5;
			var windowSize = $window.height(); 
			$window.scroll(function() {
				if(count === 1000) return;  
				if ($window.scrollTop() + 100 > ($(document).height() - windowSize)) {
					count = count + 1; 
//					console.log("******count = " + count); 
//					console.log("scrolTop = " + $(window).scrollTop());
//					console.log("documentHeight = " + $(document).height());
//					console.log("windowSize = " + windowSize);			
					$.ajax({
						type : "post",
						url : "showBoard",
						dataType : "json",
						data:{"start":count*size , "size":size},
						success : function(scrollDatas){
							var str = ""; 	
							$(scrollDatas.datas).each(function(index, objArr){ 
								str += "<div class='image fit'><a href='#'>" ;
								str += "<img src='./resources/image/board/" + objArr["b_image1"] + "'\">" ;
								str += "</a></div>"; 
							});			
							$("#columns").append(str);
						},
						error : function(){
							count = 1000; 
							//$("#columns").text("에러 !");
						}
					}); 
				}
			}); 
	});
	
})(jQuery);