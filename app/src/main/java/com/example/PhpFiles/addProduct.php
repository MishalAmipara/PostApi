<?php 


	// $con = mysqli_connect("hostname","username","password","database_name");


   $con = mysqli_connect("localhost","id19964085_userpatel","Shopping@2002","id19964085_pragneshdata");

   $temp   = array();


   if($con)
   {

    $temp['connection']  = 1;

   }
   else {

    $temp['connection']  = 0;
   }

	$loginid = $_POST['userid'];
	$name = $_POST['pname'];
	$price = $_POST['pprize'];
	$description = $_POST['pdes'];
	$imagedata = $_POST['productimage'];

		$realimage = base64_decode($imagedata);

		$imagename = "ProductImage/".$name.rand(0,10000).rand(0,10000).".jpg";

		file_put_contents($imagename, $realimage);

		$qry = "insert into Producttable (pname,userid,pprize,pdes,productimagepath) values ('$name','$loginid','$price','$description','$imagename')";

		$sql = mysqli_query($con, $qry);

		if($sql)
		{
			$temp['productaddd'] = 1;
		}
		else
		{
			$temp['productaddd'] = 0;
		}
	


	echo json_encode($temp);

 ?>