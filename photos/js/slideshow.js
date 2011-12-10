// slideshow.js
// a very simple photo slideshow - looks for photos in the 'photos' directory
// of the server.

// our only global variable - all others are members of ss.
ss = {
    'photoDir':'photos',
    'timeout':5000
};   

ss.obj2str = function(obj) {
    var retStr = '';
    for (k in obj) {
	retStr += obj[k] + '\n';
    }
    return retStr;
}

ss.isImg = function(nameObj) {
    var imgList = ['.jpg','.jpeg','.png','.gif'];
    var nameStr = String(nameObj);
    var ext = nameStr.slice(nameStr.indexOf('.')).toLowerCase();
    var i;
    for (i=0;i<imgList.length;i++) {
	if (ext == imgList[i]) {
	    return true;
	}
    }
    return false;
}

ss.changePhoto = function () {
    //alert("ss.photoNo = " + ss.photoNo + ", Image=" + ss.imgList[ss.photoNo]);
    ss.photoNo += 1;
    if (ss.photoNo >= ss.imgList.length) {
	ss.photoNo = 0;
    }
    jQuery('#photo').attr('src',ss.imgList[ss.photoNo]);
    
    ss.timeoutID = window.setTimeout(ss.changePhoto,ss.timeout);
}

ss.startSlideshow = function() {
    ss.changePhoto();
}

ss.initialise_slideshow = function() {
    var indexObj;
    var i;
    var href;
    ss.timeoutID = -1;
    ss.photoNo = 1;
    ss.imgList = [];
    jQuery.get(ss.photoDir,'',function(data) {
	jQuery('#photo').html('<img src="">');
	indexObj = jQuery(data)
	indexObj.find('a').each( function() {
	    href = jQuery(this).attr('href');
	    if (ss.isImg(href)) {
		ss.imgList.push(ss.photoDir+"/"+href);
	    }
	});
	//alert("data="+data);
	//alert(obj2str(ss.imgList));
	if (ss.imgList.length > 0) {
	    ss.startSlideshow();
	} else {
	    alert("Oh No - can't find any photos - giving up!");
	}
    });
    

}