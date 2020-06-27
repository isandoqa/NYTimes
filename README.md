# NYTimes
NYTimes Assignment
This is an assignment project, simply loads popular articles from NYTimes API and showing them in an android app in a simple master details structure.

Basic Concepts in the app:

* Simple MVC structural design pattern is used.
* View binding is used to access views within controllers.
* Retrofit is used for http process.
* Gson library is used to parse JSON response.
* RxJava/RxAndroid is used to handle data flows and the propagation of changes.
* Glide library is used to load/cache images.

The app contains two activities: Main activity which loads the articles and show them in a recycler view,
and ArticleDetails Activity which appears once an article is tapped in MainActivity to show the article details.
