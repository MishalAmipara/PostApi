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

    $username = $_REQUEST['username'];
    $password = $_REQUEST['password'];

    $qry = "select * from classRegister where EMAIL = '$username' and PASSWORD = '$password' ";

    $sql = mysqli_query($con, $qry);

    $cnt = mysqli_num_rows($sql);

    if($cnt==1)
    {
        $temp['result'] = 1;
        //  map 
        $arr = mysqli_fetch_assoc($sql);
        // echo $arr;
        $temp['userdata'] = $arr;
    }
    else
    {
        $temp['result'] = 0;
    }
    echo json_encode($temp);

 ?>

