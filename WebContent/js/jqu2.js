/**
 * 
 */
$(function (){
$(window).scroll(function(){
        var locaion = $(document).scrollTop();
        $('.scrolltop').text(locaion)

        if($(document).scrollTop()>=400){
            $('.box').css({
                top:'200px'
            })    
        }else{
            $('.box').css({
                top:'50%'
            })    
        } 
    })
});