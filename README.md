# Rest Assured TestNG Framework
Automating functional API Backend for https://ae.almosafer.com/en. API This project uses the object model (POM) design pattern.

## Stack & Libraries
- Java
- Rest Assured
- JSON
- TestNG
- Maven
- Allure Report 

## Prerequisites
- IDE (IntelJ IDEA)
- JDK (version 7 or 8) or higher
- Maven configuration

### Easy way to configure Maven (Mac)
<details>
  <summary>Click to view instructions</summary> 

1. Download Maven (tar.gz for mac) from [here](https://maven.apache.org/download.cgi)
2. Move the downloaded apache-maven-3.6.3 folder to your Home directory (This is the folder with your username)

In terminal:

1. Set system variables:
```
export M2_HOME=/Users/<YOUR USER NAME>/apache-maven-3.6.3/
```
2. Append the Maven bin folder to the path:
```
export PATH=$PATH:/Users/<YOUR USER NAME>/apache-maven-3.6.3/bin/
```
3. If you don't have a bash profile, create one:
```
touch .bash_profile
```
4. If you do have one, or after creating one, open the bash profile to edit:
```
open .bash_profile
```
5. Paste the two paths from step 1 and 2
6. Save and close
7. Now Maven will be installed for all sessions. To verify Maven is installed, type:
```
mvn --version
```
</details>

## How to run tests
In terminal:
```
git clone https://github.com/Ahmed-Mahmoud7/WeatherShpper.git
```
Change directory to the location of cloned project folder and run Maven clean
```
mvn clean
```
To run the test
```
mvn test
```

## Project components
- Main objects are in the directory *src/main/java/com.apitest.base*
- Test classes are in the the directory *src/test/java/com.apitest.mosaferapi*
