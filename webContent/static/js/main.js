jQuery(function($) {
	//#main-slider
	$(function(){
		$('#main-slider.carousel').carousel({
			interval: 8000
		});
	});

	//#private fields
	$("#private-fields, #advanced-fields").hide().removeClass('hide');

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


	$("input[name='is_private']").click(function(){
		if ($(this).is(":checked")){
			$('#privateModal').modal('show');
		}
	});

	$("#save-private").click(function(){
		$('#privateModal').modal('hide');
	});

	$("button#advanced").click(function(event){
		event.preventDefault();
		$("#advanced-fields").slideToggle();
	});

	$("#cancel-private").click(function(){
		$('#privateModal').modal('hide');
		$("input[name='is_private']").attr('checked', false).removeAttr("checked");;
	});

	// Form Submit
	$('#analyze-form').submit(function(event){
		event.preventDefault();

		var url = $('form input[type="url"]').val();
		var branch = $('form input[name="branch]').val();
		var data = {url: url, branch: branch};

		if ($(this).is(":checked")){
			data.username = $("input[name='username'").val();
			data.password = $("input[name='password'").val();
		}

		sendRequest(data);
		showWaitingMessage();

		return false;
	});

	function sendRequest(data){
		$.ajax({url: "/", 
				type: "POST", 
				data: data})
		.done(function() {
			setTimeout(function(){
				window.location.href = "/stats.html";
			}, 3000);
		}).fail(function(request, status, error) {
			alert( "Theare was an error when processing your request");
		});
	}

	function showWaitingMessage(){
		$("#wait-message").removeClass("hide");
		$("#main-slider").slideUp();
	}
});