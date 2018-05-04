<?php 

$protocol = stripos($_SERVER['SERVER_PROTOCOL'],'https') === true ? 'https://' : 'http://';
$domain   = $_SERVER['HTTP_HOST'];

$appUrl = $protocol . $domain . "/";

?>
<!doctype html>
<html lang="en">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BWT</title>

    <!-- Bootstrap -->
    <link href="<?= $appUrl; ?>css/bootstrap.min.css" rel="stylesheet">
	<link href="<?= $appUrl; ?>css/bootstrap-datetimepicker.min.css" rel="stylesheet">
	<link href="<?= $appUrl; ?>css/themes/bootstrap-theme.min.css" rel="stylesheet">
	<link href="<?= $appUrl; ?>datatables/datatables.min.css" rel="stylesheet">
	<link href="<?= $appUrl; ?>jquery-ui/jquery-ui.min.css" rel="stylesheet">
	<link href="<?= $appUrl; ?>css/tooltipster.bundle.min.css" rel="stylesheet">
	<link href="<?= $appUrl; ?>css/loading.css" rel="stylesheet">
	<link href="<?= $appUrl; ?>css/themes/tooltips/tooltips-theme.css" rel="stylesheet">
	
	<link href="<?= $appUrl; ?>css/bwt.css" rel="stylesheet">
	
	
	<link href="<?= $appUrl; ?>css/bwt-demo.css" rel="stylesheet">
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
	<script src="<?= $appUrl; ?>js/bootstrap.min.js"></script>
	<script src="<?= $appUrl; ?>js/moment.js"></script>
	<script src="<?= $appUrl; ?>js/bootstrap-datetimepicker.min.js"></script>
	<script src="<?= $appUrl; ?>js/bootstrap-hover-dropdown.min.js"></script>
	<script src="<?= $appUrl; ?>js/handlebars.js"></script>
	<script src="<?= $appUrl; ?>js/jquery.scrollTo.min.js"></script>
	<script src="<?= $appUrl; ?>datatables/datatables.min.js"></script>
	<script src="<?= $appUrl; ?>jquery-ui/jquery-ui.min.js"></script>
	<script src="<?= $appUrl; ?>js/tooltipster.bundle.min.js"></script>
	<script src="<?= $appUrl; ?>js/loading.js"></script>
	<script src="<?= $appUrl; ?>js/plugins/tooltipster/follower.min.js"></script>
	<script src="<?= $appUrl; ?>js/bwt.js"></script>
    <script type="text/javascript" src="<?= $appUrl; ?>demo/demo.nocache.js"></script>    

    <script type="text/javascript">
		var appUrl = "<?= $appUrl; ?>";

// 		$(function() {
// 			$('#demo-smart').draggable({
// 				grid: [1, 1],
// 				helper: 'clone',
// 				revert: true,
// 				scroll: false,
// 				cancel: false,
// 				start: function(event, ui) {
// 					$(ui.helper).tooltipster({
// 							content: 'Move my origin next to the edges of the screen and see how I adapt.<br />Besides, there are several options to tune my behavior.',
// 							contentAsHTML: true,
// 							trackerInterval: 10,
// 							trackOrigin: true
							
// 						})
// 						.tooltipster('open');
// 				},
// 				stop: function(event, ui) {
// 					ui.helper.tooltipster('destroy');
// 				}
// 			});
// 		});
    </script>

  </head>
  <body>
	
<!-- 	<button id="demo-smart" class="btn btn-primary">Test</button> -->
	
	<!-- 
    <iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1' style="position:absolute;width:0;height:0;border:0"></iframe>
	 -->
	 
    <noscript>
      <div style="width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif">
        Your web browser must have JavaScript enabled
        in order for this application to display correctly.
      </div>
    </noscript>

</body>
</html>


