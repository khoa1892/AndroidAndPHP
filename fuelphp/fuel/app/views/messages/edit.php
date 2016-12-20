<h2>Editing <span class='muted'>Message</span></h2>
<br>

<?php echo render('messages/_form'); ?>
<p>
<?php
	if ($message->name == Auth::instance()->get_screen_name()) {
		echo Html::anchor('messages/edit/'.$message->id, 'Edit');
		echo ' | ';
	}
	echo Html::anchor('messages', 'Back');
?>
