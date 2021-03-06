<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
/*
 * Globals
 */

/* Links */
a, a:focus, a:hover {
	color: #fff;
}

/* Custom default button */
.btn-default, .btn-default:hover, .btn-default:focus {
	color: #333;
	text-shadow: none; /* Prevent inheritence from `body` */
	background-color: #fff;
	border: 1px solid #fff;
}

/*
 * Base structure
 */
html, body {
	height: 100%;
	background-color: #FBFBFB;
}

body {
	color: #296293;
	text-align: center;
	text-shadow: 0 1px 3px rgba(0, 0, 0, .5);
}

/* Extra markup and styles for table-esque vertical and horizontal centering */
.site-wrapper {
	display: table;
	width: 100%;
	height: 100%; /* For at least Firefox */
	min-height: 100%;
	-webkit-box-shadow: inset 0 0 100px rgba(0, 0, 0, .5);
	box-shadow: inset 0 0 100px rgba(0, 0, 0, .5);
}

.site-wrapper-inner {
	display: table-cell;
	vertical-align: top;
}

.cover-container {
	margin-right: auto;
	margin-left: auto;
}

/* Padding for spacing */
.inner {
	padding: 30px;
}

/*
 * Header
 */
.masthead-brand {
	margin-top: 10px;
	margin-bottom: 10px;
}

.masthead-nav>li {
	display: inline-block;
}

.masthead-nav>li+li {
	margin-left: 20px;
}

.masthead-nav>li>a {
	padding-right: 0;
	padding-left: 0;
	font-size: 16px;
	font-weight: bold;
	color: #fff; /* IE8 proofing */
	color: rgba(255, 255, 255, .75);
	border-bottom: 2px solid transparent;
}

.masthead-nav>li>a:hover, .masthead-nav>li>a:focus {
	background-color: transparent;
	border-bottom-color: #a9a9a9;
	border-bottom-color: rgba(255, 255, 255, .25);
}

.masthead-nav>.active>a, .masthead-nav>.active>a:hover, .masthead-nav>.active>a:focus
	{
	color: #fff;
	border-bottom-color: #fff;
}

@media ( min-width : 768px) {
	.masthead-brand {
		float: left;
	}
	.masthead-nav {
		float: right;
	}
}

/*
 * Cover
 */
.cover {
	padding: 0 20px;
}

.cover .btn-lg {
	padding: 10px 20px;
	font-weight: bold;
}

/*
 * Footer
 */
.mastfoot {
	color: #999; /* IE8 proofing */
	color: rgba(255, 255, 255, .5);
}

/*
 * Affix and center
 */
@media ( min-width : 768px) {
	/* Pull out the header and footer */
	.masthead {
		position: fixed;
		top: 0;
	}
	.mastfoot {
		position: fixed;
		bottom: 0;
	}
	/* Start the vertical centering */
	.site-wrapper-inner {
		vertical-align: middle;
	}
	/* Handle the widths */
	.masthead, .mastfoot, .cover-container {
		width: 100%;
		/* Must be percentage or pixels for horizontal alignment */
	}
}

@media ( min-width : 992px) {
	.masthead, .mastfoot, .cover-container {
		width: 700px;
	}
}
</style>

<div class="site-wrapper">

	<div class="site-wrapper-inner">

		<div class="cover-container">

			<div class="inner cover">
				<h1 class="cover-heading">Chân Thành Cảm Ơn Quý Vị.</h1>
				<p class="lead">Không có gì sướng hơn là làm những gì mình thích</p>
				<p class="lead">
					<a href="#" class="btn btn-lg btn-default">Learn more</a>
				</p>
			</div>

			<div class="mastfoot">
				<div class="inner">
					<p>
						Cover template for <a href="http://getbootstrap.com">Bootstrap</a>,
						by <a href="https://twitter.com/mdo">@mdo</a>.
					</p>
				</div>
			</div>

		</div>

	</div>

</div>