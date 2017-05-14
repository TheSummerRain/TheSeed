// JavaScript Document
$(function () {
$.scrollUp();
  $("#zys a").click(function(){
		$("#zys").find(".active").removeClass("active");
		$(this).parent().toggleClass("active");
		})
	$("#viewAll").click(function(){
		$(this).toggleClass("viewAll2");
		$("#viewAll2").toggle();
		})
$(".xialaMenu").click(function(){
	menu=$(this).attr('href');
	$(this).find(".weui_cell_ft").toggleClass("sel");
	event.preventDefault(); 
  $(menu).slideToggle(300);
	});
var $container = $('.js_container');
$container.on('click', '#showToast', function () {
        $('#toast').show();
        setTimeout(function () {
            $('#toast').hide();
        }, 10000);
    });
$container.on('click', '#showLoadingToast', function () {
        $('#loadingToast').show();
        setTimeout(function () {
            $('#loadingToast').hide();
        }, 10000);
    });

$container.on('click', '#showDialog1', function () {
        $('#dialog1').show();
        $('#dialog1').find('.weui_btn_dialog').on('click', function () {
            $('#dialog1').hide();
        });
    });
$container.on('click', '#showDialog2', function () {
        $('#dialog2').show();
        $('#dialog2').find('.weui_btn_dialog').on('click', function () {
            $('#dialog2').hide();
        });
    });
		
});