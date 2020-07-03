# Instructions


<br>
<br>
<br>
This is a simple website, mainly developed using Vue.js + SpringBoot technologies.

<br>
<br>
<br>

---

# Overall dispaly

## 1. Home

![Home](https://raw.githubusercontent.com/realdonald1994/blog-resources/master/img/Klf_group_Assessment.png)

## 2. DashBoard

![Dashboard](https://raw.githubusercontent.com/realdonald1994/blog-resources/master/img/Klf_group_Assessment(1).png)

## 3. Log

![Log](https://raw.githubusercontent.com/realdonald1994/blog-resources/master/img/Klf_group_Assessment5.png)

## 4. User Management

![UserManagement](https://raw.githubusercontent.com/realdonald1994/blog-resources/master/img/Klf_group_Assessment3.png)


# How to run

1.clone project to local

`git clone https://github.com/realdonald1994/Klf_group_Assessment.git`

2.Create a database `klf` in mysql, run the project, and the tables will be created automatically.
 
3.The database is configured in the `application.properties` file in the` src \ main \ resources` directory of the project, and the mysql version is 8.0.15. <Strong>Set your own username and password of database!</Strong>

4.Run the project in IntelliJ IDEA(Other IDE). To ensure the project runs successfully, you can right-click `pom.xml` and select maven-> reimport and restart the project

At this point, the server is successfully started, at the same time, visit `http: // localhost: 8085`, you can enter the home page, register your account and start visit.


# Technology Stack

## 1. Assessment 1

1.Spring Boot  
2.Spring Data JPA
3.MySql

## 2. Assessment 2

1.Vue.js  
2.ElementUI  
3.Axios  
4.Vuex

## 3. Assessment 3

1.Mysql  
2.Spring Data JPA  
3.Spring AOP  

# Notice

## 1. About Run Project

1. If you don't want to create data by yourself. I put the export sql file in the ` src \ main \ resources` directory of the project.  You can run sql script to import data.

## 2. Optimization

1. I make a simple user authentication with session. <Strong>It's means you can't visit admin page if you don't login.</strong>  
2. Wehn you visit admin page, you can click your `name(In the upper right corner of the page)` to log out admin management.  
3. On the home page, you can click `Contact`  to let customer to be able to send email to company.

# Thank you

:star: :star: :star:
