<?php
/******************************
ガイアックス技術選考課題 初級編
*****************************/


function getIPhoneNumber($year){
  //2008年未満または2017年以上ならNullを返却
  if(2008 <= $year && $year < 2017 ){
    $num = (int)substr($year, -2);
    if($num === 8){
      return '3G';
    }elseif ($num === 9) {
      return '3GS';
    }else{
      return discriminant_year($num);
    }
    return $num;

  }
  return NULL;
}



function discriminant_year($year){

  $revisionCode = '';

  // iPhoneナンバリングを算出
  $number = (int)(($year -8 ) /2 ) +3;

  // 奇数年年であればSをつける
  if($year % 2){
    $revisionCode = 'S';
  }

  // 14年以降ならPlusも合わせて返却
  if($year >= 14){
    return "{$number}{$revisionCode}/{$number}{$revisionCode} Plus";

  }elseif($year === 13){
    return "{$number}{$revisionCode}/{$number}c";

  }
  return $number . $revisionCode;
}
