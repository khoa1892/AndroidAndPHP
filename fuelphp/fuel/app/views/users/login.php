<ul class="nav nav-pills">
	<li class='<?php echo Arr::get($subnav, "login" ); ?>'><?php echo Html::anchor('users/login','Login');?></li>
	<li class='<?php echo Arr::get($subnav, "register" ); ?>'><?php echo Html::anchor('users/register','Register');?></li>

</ul>
<?php if (isset($errors)){echo $errors;}?>
<?php echo $form; ?>