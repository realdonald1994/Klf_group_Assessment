# Instructions

This is a simple website, mainly developed using Vue.js + SpringBoot technologies.

---

# Overall dispaly

## 1. Home

![Home](https://raw.githubusercontent.com/realdonald1994/blog-resources/master/img/Klf_group_Assessment.png)

## 2. DashBoard

![Dashboard](https://raw.githubusercontent.com/realdonald1994/blog-resources/master/img/Klf_group_Assessment(1).png)

## 3. Log

![Log](https://raw.githubusercontent.com/realdonald1994/blog-resources/master/img/Klf_group_Assessment2.png)

## 4. User Management

![UserManagement](https://raw.githubusercontent.com/realdonald1994/blog-resources/master/img/Klf_group_Assessment3.png)


# How to run

1.clone project to local

2.Create a database `klf` in mysql, run the project, and the data will be injected automatically.
 
3.The database is configured in the `application.properties` file in the` src \ main \ resources` directory of the backend project, and the mysql version is 8.0.15.

4.Run the backend project in IntelliJ IDEA. To ensure the project runs successfully, you can right-click `pom.xml` and select maven-> reimport and restart the project

At this point, the server is successfully started, at the same time, run the front-end project, visit `http: // localhost: 8080`, you can enter the login page, the default account is` admin`, the password is `123`
