"use strict";

$(document).ready( function() {

		$("body").addClass("backgroundGradient");

		$("<p></p>").css("background-color", "red").prependTo("#sitecontent").attr("id", "errorMsg"); //2

		$("#btnReset").on("click", function() {
			$("#errorMsg").text("");
		});

		$("div[class=borderClass]").each( function() {
			let fabrikat = $(this).find("[data-fabrikat]").attr("data-fabrikat");
			let aRef = $("<a href='#'>" + fabrikat + "</a>").insertBefore($(this));
			$(this).hide();

			aRef.on("click", function(e) {
				e.preventDefault();
				e.stopPropagation();
				$(this).next("div").slideToggle();
			});

			$(this).find("a").on("click", function(e) {
				let fabrikat = $(this).siblings("[data-fabrikat]").attr("data-fabrikat");
				let regnr = $(this).siblings("[data-regnr]").attr("data-regnr");
				e.preventDefault();
				e.stopPropagation();

				if( confirm("Vill du verkligen tabort " + fabrikat + " med regnr " + regnr + "?") ){

					let currentElement = $(this);

					currentElement.parent().prev("a").remove();
					currentElement.parent().remove();

					let spanRef = $("span").first();
					spanRef.fadeOut(500, function() {
						spanRef.text(parseInt(spanRef.text()) - 1);
					});
					spanRef.fadeIn(500);

				}
			});
		});

		$("form").on("submit", function(e) {

			e.preventDefault();
			e.stopPropagation();

			let regnr = $("#txtRegNr").val();
			let fabrikat =  $("#txtFabrikat").val();
			let modell = $("#txtModell").val();
			let currentElement = $(this);
			if(regnr === "" || fabrikat === "" || modell === "") {
				$("#errorMsg").text("Samtliga textrutor måste vara ifyllda!");
			}
			else {

				let aRef = $("<a href='#'>" + fabrikat + "</a>").insertBefore("#myId");
				let divRef = $("<div class='borderClass'><p data-fabrikat='"
					+ fabrikat + "'>" + fabrikat + "</p><p data-regnr='" + regnr + "'>" + regnr + "</p><a href='#'>Ta bort</a></div>").insertAfter(aRef);

				aRef.on("click", function(e) {
					e.preventDefault();
					e.stopPropagation();
					$(this).next("div").slideToggle();
				});

				divRef.find("a").on("click", function(e) {
					let fabrikat = $(this).siblings("[data-fabrikat]").attr("data-fabrikat");
					let regnr = $(this).siblings("[data-regnr]").attr("data-regnr");
					e.preventDefault();
					e.stopPropagation();

					if( confirm("Vill du verkligen tabort " + fabrikat + " med regnr " + regnr + "?") ){
						let currentElement = $(this);

						currentElement.parent().prev("a").remove();
						currentElement.parent().remove();

						let spanRef = $("span").first();
						spanRef.fadeOut(500, function() {
							spanRef.text(parseInt(spanRef.text()) - 1);
						});
						spanRef.fadeIn(500);
					}
				});
				
				let spanRef = $("span").first();
				spanRef.fadeOut(500, function() {
					spanRef.text(parseInt(spanRef.text()) + 1);
				});
				spanRef.fadeIn(500);
				currentElement.find("[type=reset]").trigger("click");
			}

		});

});
