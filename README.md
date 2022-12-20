# TestVagrant Coding Assessment

Go to src/test/java where you will find a package TestVagrant.TestVagrantAssessment. Inside this, I have used POM(Page object model) to create test cases for the project. For each page(IMDB Page and Wiki Page), I have created a separate object repository where I have stored Xpaths associated with each page to avoid code duplicacy.
I have also used various TestNg annotations to run the Test cases. AfterMethod annotation to capture screenshot for both passed and failed test cases after the execution of each Test method.
I have even set the priority of test methods(The order in which Test methods should execute)
Also I have used ExtentReport listener to generate Report after executio of all the test cases.
I have used Factory Design Pattern to create various instances of Webdriver Class
And I am running my test methods using movieInformation.xml file

