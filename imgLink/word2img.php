<?php
  /* Array that relates words to image files */
  $imgArr =  array(
     "click"=>"mouse.jpg",
     "cup"=>"cup.jpg",
     "house"=>"house.jpg",
     "i"=>"i.jpg",
     "you"=>"you.jpg"
  );

  if (array_key_exists('word',$_GET)) {
      $word = $_GET['word'];
      if (array_key_exists($word,$imgArr))
        echo $imgArr[$word];
      else
        echo "unknown.jpg";
  }
  else {
    echo "unknown.jpg";

  }

?>