var isLogin = false;
$(function(){
	$( ".auto-complete" ).keypress(function(event) {
		if(event.which == 13){
  			$(location).attr('href',"searchAspirin.html");
		}
	});
});
	
$(function() {
	var tags= [
	"Paracetamol",
	"Anti-inflammatory painkillers",
	"Antihistamines",
	"Antacids",
	"Hydrocortisone cream",
	"Skin care",
	"Eye care",
	"Aspirin"
	];
	$( "#Autocomplete1" ).autocomplete({
    source: tags
  }); 
});
$(function() {
  $('#main-menu').smartmenus();
});
$(function(){
  $('.bxslider').bxSlider({
   mode: 'fade',
   auto: true  
 });
});
$(function(){
	$('.product-and-title').bind("mouseover", function(){
		var offset = $(this).position().left + $(this).width();
		var offset_top =  $(this).position().top-10;
		var content = "<div class='slideout-info'> <div class='slideout-info-title'> Medicine X</div>  <img src='image/star.png' width='100' height='20' />   <div class='slideout-info-last'> 1223 Reviews</div>  </div>";
		$(this).after(content);
		$('.slideout-info').css("left", offset);
		$('.slideout-info').css("top", offset_top);
		$('.slideout-info').fadeIn(800);
	});
});
$(function(){
	$('.product').bind("mouseout", function(){
		$('.slideout-info').remove();
	});
});

$(function(){
	if(isLogin==false){
		$('.sign-in-text').text('Sign in');
		$('.sign-in-text').css('margin-left', '70px');
	}else{
		$('.sign-in-text').text('Sign out');
		$('.sign-in-text').css('margin-left', '60px');
	}
	
	$('.sign-in-text').bind("click", function(){
		//alert($(this).text());
		if($('.sign-in-text').text() == 'Sign in'){
			$('#login-modal').modal('show');
		}else{
			$('.sign-in-text').text('Sign in');
			$('.sign-in-text').css('margin-left', '70px');
			isLogin=false;
		}
	});
	
	$('#login-button').bind("click", function(){
		//alert($(this).text());
		$('#login-modal').modal('hide');
		$('.sign-in-text').text('Sign out');
		$('.sign-in-text').css('margin-left','60px');
		isLogin=true;
		
	});
	
});

$(function(){
	$('.handle').click(function(){
			$('.slide-out-div').toggle("slide");
	});
	$('.slide-out-div .close').click(function(){
			$('.slide-out-div').toggle("slide");
	});
});


//add links
$(function(){
	$('.upmc-logo img').click(function(){
			$(location).attr('href',"index.html");
	});
	
	$('.product-and-title').click(function(){
			$(location).attr('href',"ProductDetail.html");
	});
	$('.slide-out-div .product-and-title').click(function(){
			$(location).attr('href',"ProductDetailOther.html");
	});
	$('#search-button').click(function(){
			$(location).attr('href',"searchAspirin.html");
	});
	$('#menu ul li ul li a').click(function(){
			$(location).attr('href',"search.html");
	});
	$('#menu p').click(function(){
			$(location).attr('href',"help.html");
	});
	$('#forgot-link').click(function(){
		$(location).attr('href',"forgotPassword.html");
	});
	$('#reg-button').click(function(){
		$(location).attr('href',"regisform.html");
	});
	$('button').click(function(){
		//alert($(this).text());
		if($(this).text()=='Add to cart'){
			$(location).attr('href',"viewcartfinal.html");
		}else if($(this).text()=='Save & Continue'){
			$(location).attr('href',"PurchaseConfirmation.html");
		}
		
	});
	$('#cart-button').click(function(){
		$(location).attr('href',"viewcartfinal.html");
	});
	
});
// JavaScript Document