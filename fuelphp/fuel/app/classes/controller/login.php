<?php

class Controller_Login extends Controller_Template
{

	public function action_logout()
	{
		$data["subnav"] = array('logout'=> 'active' );
		$this->template->title = 'Login &raquo; Logout';
		$this->template->content = View::forge('login/logout', $data);
	}

	public function action_register()
	{
		$data["subnav"] = array('register'=> 'active' );
		$this->template->title = 'Login &raquo; Register';
		$this->template->content = View::forge('login/register', $data);
	}

}
