# AmFrame
Test framework for assignment

Includes:

page objects, driver singleton for Chrome, waits, unit tests, selenium test.

How to setup:
- To simplify run use IntelliJ Idea.
- It's basic maven project, pom file contains dependencies that can be downloaded via Maven plugin (Idea).
- Current setup should include chromedriver.exe (check drivers for your Chrome) in root of project folder
- Uses Java 8+, some code can be Java version dependent. JDK 1.8 recommended
- To run the project just right click to green triangle icon near test methods in classes GeneralTest and FrameworkTests (in dropdown menu you'll can chose run mode run/debug)
- Main test is mainTest in GeneralTest class


Note todoes (can be implement in future, just notes for myself):
- Test Steps classes for AOP approach to standard actions
- *.properties file to store paths and more
- pom management for full pipeline from build to jar artifacts
- Test runner
