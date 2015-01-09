/* converts all hyperlinks to have hover images */

setImg = function(link) {
    //alert($(link).text());
    $(link).addClass("imgLink");
    wordStr = $(link).text().split(" ")[0].toLowerCase();
    urlStr = "word2img.php?word="+wordStr;
    $.ajax({url:urlStr,context:link}).done(function(retVal) {
       $(this).append("<span><img src='"+retVal+"'></span>");
    });
}

$(document).ready(function() {
    //alert("ready");
    $("a").each(function(index) {setImg(this);});
});
