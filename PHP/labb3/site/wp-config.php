<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the
 * installation. You don't have to use the web site, you can
 * copy this file to "wp-config.php" and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * MySQL settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://codex.wordpress.org/Editing_wp-config.php
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('WP_CACHE', true);
define( 'WPCACHEHOME', '/Users/felix/Documents/Development/PHP/labb3/site/wp-content/plugins/wp-super-cache/' );
define('DB_NAME', 'labb3');

/** MySQL database username */
define('DB_USER', 'admin');

/** MySQL database password */
define('DB_PASSWORD', 'testing');

/** MySQL hostname */
define('DB_HOST', 'localhost');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8mb4');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'N( vd=(?ZglXjtoAF^@7HbyX;c[U>|BiEhcNk/LPt3r?B;R!J$J+yPFwA1r^eo85');
define('SECURE_AUTH_KEY',  '.ZSnR4CV3Qys$UUM3~#z.K*b/1:Wz(S3zt%z~@`;HS{?,}[=qZw:;z:Alh^V?06Q');
define('LOGGED_IN_KEY',    'Z]z?~zh.-0!lLH/Anem9}-mW;44~AqLzOJ8U)%tq^BM6U,/nrsKJAS29x,|!T7ad');
define('NONCE_KEY',        '>ALO`!Whf]c*NDv^49x|iW0}xnX3qCaL@_,85G_`/(lIkhbOw]y^k42N-,#uTLsa');
define('AUTH_SALT',        '{3miC}B;vM+kwn4#_^I&8b,LF0^^p((8@+~IF|9XcEo/x}=p|_BKv[ub/K+ji[f<');
define('SECURE_AUTH_SALT', ':{/sRBHbZy$xZMiK;7hrxps[N*yGDYi6N?e/(A$*~oODB2l=ioI~pI52H&M[8Ta8');
define('LOGGED_IN_SALT',   'FM^}-s~E`~ymp9G9}3HuEPdQ={buGdr^~}i+ k{3JA.%LPlACg9b*$ .8Z?>K%V?');
define('NONCE_SALT',       'RsG1nPk3*AwG4@#UNS<fV0O,CbsG{v$~NJ8j8q]K^F7oJmE=a<`&ox79lgjCK])~');

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the Codex.
 *
 * @link https://codex.wordpress.org/Debugging_in_WordPress
 */
define('WP_DEBUG', false);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');
