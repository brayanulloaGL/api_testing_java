# GENERAL NOTES FROM OSCAR VALERIO MONTES

REQUIRED
1. Add .idea folder and automated_testing_java.iml to the .gitignore file
2. Validate more than just status codes
3. Use groups for all tests 
4. Use testng parameters
5. Create a readme file to document how to run test cases
6. Add parallelism
7. Reduce repetitive code

OPTIONAL
1. I would say that you can move the "pages" package to the "test/java" folder to have all related to automation in one place, it can be easier to access page objects if they are close to the tests package. It can more beneficial when a project is bigger and you have a lots of test cases, lots of pages, etc.
2. I think there you can also use testng dataprovides
