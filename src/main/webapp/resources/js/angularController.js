(function(){
	var app = angular.module('socialWeb', []);

	//Controllers
	app.controller('PageController', function(){
		this.page = 10;
		this.setPage = function(newValue){
			this.page = newValue;
		};
		this.getPage = function(pageName){
			return this.page === pageName;
		};
	});

	//Directives
	// Layout
	app.directive('layoutMenu', function(){
		return{ restrict: 'E', templateUrl: './Layout/Menu' };
	});
	app.directive('layoutBlank', function(){
		return{ restrict: 'E', templateUrl: './Layout/Blank' };
	});
	
	// Pages
	// Main 10
	app.directive('mainPage', function(){
		return{ restrict: 'E', templateUrl: './Main' };
	});
	app.directive('mainSlide', function(){
		return{ restrict: 'E', templateUrl: './Main/Slide' };
	});
	app.directive('mainArticle', function(){
		return{ restrict: 'E', templateUrl: './Main/Article' };
	});
	app.directive('mainEvent', function(){
		return{ restrict: 'E', templateUrl: './Main/Event' };
	});
	
	// About 20
	app.directive('aboutPage', function(){//20
		return{ restrict: 'E', templateUrl: './About' };
	});
	
	// Article 30
	app.directive('articlePage', function(){//30
		return{ restrict: 'E', templateUrl: './Article' };
	});
	app.directive('articleCreate', function(){//31
		return{ restrict: 'E', templateUrl: './Article/Create' };
	});
	app.directive('articleDetail', function(){//32
		return{ restrict: 'E', templateUrl: './Article/Detail' };
	});
	
	/*These are not ready yet*/
	//Lecture 40
	app.directive('lecturePage', function(){//40
		return{ restrict: 'E', templateUrl: './Main' };
	});
	// Event 50
	app.directive('eventPage', function(){//50
		return{ restrict: 'E', templateUrl: './Main' };
	});
	// Admin 60
	app.directive('adminPage', function(){//60
		return{ restrict: 'E', templateUrl: './Account/ShowList' };
	});
	
	// Account
	app.directive('accountSignin', function(){//90
		return{ restrict: 'E', templateUrl: './Account/SignIn' };
	});
	app.directive('accountSignout', function(){//91
		return{ restrict: 'E', templateUrl: './Account/SignOut' };
	});
	app.directive('accountSignup', function(){//92
		return{ restrict: 'E', templateUrl: './Account/SignUp' };
	});
	app.directive('accountFindpw', function(){//93
		return{ restrict: 'E', templateUrl: './Account/FindPW' };
	});
	app.directive('accountSearch', function(){//94
		return{ restrict: 'E', templateUrl: './Account/Search' };
	});
	app.directive('accountShowlist', function(){//95
		return{ restrict: 'E', templateUrl: './Account/ShowList'};
	});
	app.directive('accountSession', function(){
		return{ restrict: 'E', templateUrl: './Account/Session' };
	});
})();
