# Euler on java

### Introduction
This code represent project Euler on Java. It contains 611 tasks and I will solve them in next year or so(I hope). 
Also it contains 10 tasks that not solved by humanity and I hope I will solve them to (Let's pray for it together).
All problems are divided on levels, there are 25 problems in one level. It gets totally 25 levels.
### UI Instruction
To run problem enter:
```
run %ProblemNumber%
```
To print all problems list enter:
```
print problems
```
To print problem info enter:
```
info %ProblemNumber%
```
To get help enter: 
```
help
```
To exit enter: 
```
exit
```
### Libraries and Dependencies 
To run this code you need to add JDBC library.\
To do so go to
```
File -> Project structure -> Libraries -> add(green plus) -> java
```
Select jar file from folder libraries and heat apply.
### Possible problems
Sometimes module is not loaded. That's means that all folders such ass out,libraries and src doesn't show in the project three.\
To fix it go to:\
\
Select JDK:
```
File -> Project structure -> Project -> Project JDK -> 9.0(java version 9.0.4)
```
Select Project language level:
```
File -> Project structure -> Project -> Project language level ->SDK default
```
Select output folder. Usually yourProjectPath/out
```
File -> Project structure -> Project -> Project compiler output -> %youProjectPath/out%
```
Import module. Select .iml-file in your project folder.
```
File -> Project structure -> Modules -> Add(green plus) -> Import Module ->  %youProjectPath/ProjectName.iml%
```
After all, don't forget to click apply button.
 
# Problem Overview
### Problem_003
We find a prime number by Miller-Rabin primality test. Not sure how the fuck it is working, but it does. Than in the for-loop we divide our huge number on integer: 2,3,4...etc If 
remainder of the division equals 0, we check if it is primal or not. 
### Creator and thanks
This code wrote Dmitry Blackwell and I am very sorry for it.\
Please do not be mad on me, I am just a learner.\
If you see any mistakes or ways to improve this project, please contact me or add your commits.
\
\
I also want to say special thanks to my kind friend Artem 
and my lovely girlfriend Dasha. This project was no possible without you.