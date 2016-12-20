<p>
	<strong>Message:</strong>
	<?php echo $message->message; ?>
</p>
<?php if (Auth::instance()->check()) : ?>
	<p><?php echo Html::anchor('comments/create/'.$message->id, 'Add new Comment'); ?></p>
<?php endif; ?>
<h3>Comments</h3>
<ul>
	<?php foreach ($comments as $comment) : ?>
		<li>
			<ul>
				<li><strong>Name:</strong> <?php echo $comment->name; ?></li>
		<?php if ($comment->name == Auth::instance()->get_screen_name()) : ?>
				<li><strong>Comment:</strong><br /><?php echo $comment->comment; ?></li>
				<p><?php echo Html::anchor('comments/edit/'.$comment->id, 'Edit'); ?>| <?php echo Html::anchor('comments/delete/'.$comment->id, 'Delete', array('onclick' => "return confirm('Are you sure?')")); ?></li></p>
		<?php endif;?>
				</ul>
		</li>
	<?php endforeach; ?>
</ul>
<p><?php echo Html::anchor('messages/', 'Back'); ?></p>