<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setAttribute("commonURL", request.getContextPath());
%>
<meta charset="utf-8"> 

<!-- header -->
	<header class="header">
		<div class="header__wrap">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="header__content">
							<!-- header logo -->
							<a href="${commonURL}/movie/view" class="header__logo">
								<img src="${commonURL}/resources/img/logo.svg" alt="">
							</a>
							<!-- end header logo -->

							<!-- header nav -->
							<ul class="header__nav">
							

								<li class="header__nav-item">
									<a href="pricing.html" class="header__nav-link">영화</a>
								</li>
								<li class="header__nav-item">
									<a href="pricing.html" class="header__nav-link">예능</a>
								</li>
								<li class="header__nav-item">
									<a href="pricing.html" class="header__nav-link">드라마</a>
								</li>

								<li class="header__nav-item">
									<a href="faq.html" class="header__nav-link">만화</a>
								</li>
								<li class="header__nav-item">
									<a href="${commonURL}/movie/list" class="header__nav-link">웹툰</a>
								</li>
								<li class="header__nav-item">
									<a href="faq.html" class="header__nav-link">도서</a>
								</li>

								<!-- dropdown -->
								<li class="dropdown header__nav-item">
									<a class="dropdown-toggle header__nav-link header__nav-link--more" href="#" role="button" id="dropdownMenuMore" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="icon ion-ios-more"></i></a>

									<ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuMore">
										<li><a href="about.html">영화</a></li>
										<li><a href="signin.html">예능</a></li>
										<li><a href="signup.html">드라마</a></li>
										<li><a href="404.html">만화</a></li>
										<li><a href="404.html">웹툰</a></li>
										<li><a href="404.html">도서</a></li>
									</ul>
								</li>
								<!-- end dropdown -->
							</ul>
							<!-- end header nav -->

							<!-- header auth -->
							<div class="header__auth">
								<button class="header__search-btn" type="button">
									<i class="icon ion-ios-search"></i>
								</button>

								<a class="header__sign-in" href="${commonURL}/member/signin">
									<i class="icon ion-ios-log-in"></i>
									<span>sign in</span>
								</a>
							</div>
							<!-- end header auth -->

							<!-- header menu btn -->
							<button class="header__btn" type="button">
								<span></span>
								<span></span>
								<span></span>
							</button>
							<!-- end header menu btn -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- header search -->
		<form action="#" class="header__search">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="header__search-content">
							<input type="text" placeholder="Search for a movie, TV Series that you are looking for">

							<button type="button">search</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		<!-- end header search -->
	</header>
	<!-- end header -->