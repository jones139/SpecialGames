// slideshow.js
// a very simple photo slideshow - looks for photos in the 'photos' directory
// of the server.

// our only global variable - all others are members of ss.
ss = {
    'photoDir':'photos',
    'timeout':5000
};   

////////////////////////////////////////////////////////////////////////
// ss.obj2str:  Produces a string describing the members of object obj.
//
ss.obj2str = function(obj) {
    var retStr = '';
    for (k in obj) {
	retStr += obj[k] + '\n';
    }
    return retStr;
}


/////////////////////////////////////////////////////////////////////
// ss.isImg:  Returns true if the string passed as a parameter is
//     an image filename (based on filename extension), otherwise
//     returns false.
//
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

///////////////////////////////////////////////////////////////////////////
// ss.resizeImage
// ss.resizeImage is called by the onLoad event when an image is loaded.
// It re-sizes it to fit on the screen, while preserving its aspect ratio,
// then displays the image using the jQuery slideDown effect.
//
ss.resizeImage = function() {
    //alert("resizeImage()");
    var width = jQuery('#photo').attr('naturalWidth');
    var height = jQuery('#photo').attr('naturalHeight');
    var maxx = jQuery('#photoDiv').width();
    var maxy = jQuery('#photoDiv').height();
    var img_w = maxx;
    var img_h = maxx * height / width;
    var margin = 0;
    if (img_h > maxy) {
	img_h = maxy;
	img_w = width * maxy / height;
    }
    margin = 0.5*(maxx-img_w);
    jQuery('#photo').height(img_h);
    jQuery('#photo').width(img_w);
    jQuery('#photo').css('margin-left:'+margin);
    // Now display the image.
    jQuery('#photo').slideDown('slow');
}


////////////////////////////////////////////////////////////////////
// ss.changePhoto:  Hides the current image, then loads the next 
//    image from the list of images in the slideshow.
//    The onLoad event will be triggered by loading the image, which
//    calls ss.resizeImage which resizes and displays the new image.
//
ss.changePhoto = function () {
    //alert("ss.photoNo = " + ss.photoNo + ", Image=" + ss.imgList[ss.photoNo]);
    ss.photoNo += 1;
    if (ss.photoNo >= ss.imgList.length) {
	ss.photoNo = 0;
    }
    jQuery('#photo').slideUp('slow',function() {
	jQuery('#photo').attr('src',ss.imgList[ss.photoNo]);
	// We do not re-show the image here - the onLoad event displays
	// the image using the resizeImage() function.
	//jQuery('#photo').slideDown('slow');
    });
    
    ss.timeoutID = window.setTimeout(ss.changePhoto,ss.timeout);
}

/////////////////////////////////////////////////////////////
// ss.toggleAudio: Toggles the audio play on or off.
//
ss.toggleAudio = function() {
    var audio = $('#audioPlayer').get(0);
    if (audio.paused) { 
	audio.play(); 
	jQuery('#muteButton').html('Mute');
    } else { 
	audio.pause();
	jQuery('#muteButton').html('Play Music');
    }  
}

/////////////////////////////////////////////////////////////
// ss.toggleSlideshow: Toggles the slideshow on or off.
//
ss.toggleSlideshow = function() {
    if (!ss.running) {
	ss.changePhoto();
	ss.running = true;
	jQuery('#pauseButton').html('Pause');
    } else {
	window.clearTimeout(ss.timeoutID);
	ss.timeoutID = -1;
	ss.running = false;
	jQuery('#pauseButton').html('Start');
    }
}


///////////////////////////////////////////////////////////////
// ss.initialise_slideshow:  initialises the slideshow and
//   starts it, along with audio playback.
//
ss.initialise_slideshow = function() {
    var indexObj;
    var i;
    var href;
    ss.timeoutID = -1;
    ss.photoNo = 1;
    ss.imgList = [];
    ss.running = false;
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
	jQuery('#pauseButton').click(ss.toggleSlideshow);
	jQuery('#muteButton').click(ss.toggleAudio);
	if (ss.imgList.length > 0) {
	    jQuery('#photo').load(ss.resizeImage);
	    ss.toggleSlideshow();
	    ss.toggleAudio();
	} else {
	    alert("Oh No - can't find any photos - giving up!");
	}
    });
    

}