# Приложение для автотестирования сайта компании Wrike

#### Техническое задание:
1.	Open url: wrike.com;
2.	Click "Get started for free" button near "Login" button;
3.	Fill in the email field with random generated value of email with mask “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);
4.	Click on "Create my Wrike account" button + check with assertion that you are moved to the next page;
5.	Fill in the Q&A section at the left part of page (like random generated answers) + check with assertion that your answers are submitted;
6.	Click on "Resend email" + check it with assertion;
7.	Check that section "Follow us" at the site footer contains the "Twitter" button that leads to the correct url and has the correct icon;
8.	Create results report using allure plugin.  

#### Стек:
•	Platform: java8
•	Build: maven
•	Test framework: junit4
•	UI test: selenium 3 (without wrappers)
•	Pattern: pageObject (test -> steps -> pages)
•	Reporting: allure plugin

#### Сборка проекта и генерация отчёта
Набрать в корне проекта в командной строке:
```
mvn clean install
```
После сборки проекта:
```
mvn allure:serve
```