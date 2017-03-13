<?php  
	$years = trim(fgets(STDIN));//phpの標準入力
	$number = 2;//iPhone３G以降を表示すれば良いので、2から1足していけば良いと考えました。

//現在出ているiPhoneの範囲で行っています。新しい機種番号が出た場合、for文と4つ目のif文の数字を変更するだけで、更新可能です。また、Sやplus以外の新しい機種の法則性が出たならば、4つ目のif文以下に追加していけるようにしています。
for($count = 2008; $count < 2017; $count++){

	//2年おきに数字がカウントされる条件をクリアし、かつ、奇数の時にSを付与することで数字が増えた翌年にSをつける条件をクリアします。
	if($count%2==0){
		$number++;
		$s= "";
	}elseif($count%2==1){
		$s="S";
	}
	
	//2008 ~ 2009年のGが付く法則性を表現します。
	if($years == 2008){
		echo $number."G"."\n";

		break;
	}elseif($years == $count && $years == 2009){
	
		echo $number."G".$s."\n";

		break;
	}

	// 2010 ~ 2013年のSが付く法則性を最初のif文の処理を使って表現します。
	if($years >= 2010 && $years < 2014){
		if($years == $count){
			echo $number.$s."\n";

		break;
		}
	}

	// 2013 ~ 2017年の法則性を最初のif文の処理とPlusを追加して表現します。
	if($years >= 2013 && $years < 2017){
		if($years == $count){
			echo $number.$s."\n";
			echo $number.$s." "."Plus"."\n";
		}
	}
}
?>