jQuery(function($) {

	//#main-slider
	$(function(){
		$('#main-slider.carousel').carousel({
			interval: 8000
		});
	});

	$( '.centered' ).each(function( e ) {
		$(this).css('margin-top',  ($('#main-slider').height() - $(this).height())/2);
	});

	$(window).resize(function(){
		$( '.centered' ).each(function( e ) {
			$(this).css('margin-top',  ($('#main-slider').height() - $(this).height())/2);
		});
	});


	//goto top
	$('.gototop').click(function(event) {
		event.preventDefault();
		$('html, body').animate({
			scrollTop: $("body").offset().top
		}, 500);
	});	


	// Form Submit
	$('#analyze-form').submit(function(event){
		event.preventDefault();

		showWaitingMessage();
		var url = $('form input[type="url"]').val();

		$.ajax({url: "http://127.0.0.1:8080", 
				type: "POST", 
				data: JSON.stringify({"url": url}), 
				dataType: "json"})
		.done(function() {
			// TODO: Redirect to analysis result
		}).fail(function(request, status, error) {
			console.log( "Theare was an error when processing your request: ");
		});

		return false;
	});

	function showWaitingMessage(){
		$("#wait-message").removeClass("hide");
		$("#main-slider").slideUp();
	}
});