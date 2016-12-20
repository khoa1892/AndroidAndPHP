<?php
/**
 * Use this file to override global defaults.
 *
 * See the individual environment DB configs for specific config information.
 */

return array(
    Fuel::DEVELOPMENT => array(
        'type'          => 'mysql',
        'connection'    => array(
            'hostname'   => 'localhost',
            'database'   => 'blog_example',
            'username'   => 'root',
            'password'   => 'sv9?Djdw<#l0',
            'persistent' => false,
        ),
        'table_prefix' => '',
        'charset'      => 'utf8',
        'caching'      => false,
        'profiling'    => false,
    ),
);
