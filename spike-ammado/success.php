<html><body>
<?php
	$test = "Peter";
	echo $test;
	$myFile = "testFile.txt";
	$fh = fopen($myFile, 'w');
	fwrite($fh,$_POST["donorEmail"]);
	fclose();
?>
</body>
