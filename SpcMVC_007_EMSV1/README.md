# EMS 프로젝트

## DB연동 도구
* mysql-connector-java
```
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.29</version>
</dependency>
```
* mybatis
```
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.10</version>
</dependency>
```
* mybatis-spring
```
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>2.0.7</version>
</dependency>
```
* spring-jdbc
```
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
```
* commons-dbcp
```
<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.9.0</version>
</dependency>
```

## 파일 업로드 도구
* commons-io
```
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.11.0</version>
</dependency>
```
* commons-fileupload
```
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
	<groupId>commons-fileupload</groupId>
	<artifactId>commons-fileupload</artifactId>
	<version>1.4</version>
</dependency>
```

## JSON 관련 도구
* jackson-bind
```
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
</dependency>

```

## 메일 전송 도구
* JavaMail API (compat)
```
<!-- https://mvnrepository.com/artifact/javax.mail/mail -->
<dependency>
    <groupId>javax.mail</groupId>
    <artifactId>mail</artifactId>
    <version>1.4.7</version>
</dependency>
```

## 암호화 도구
* spring security core (RELEASE 버전 쓰기)
```
<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-core -->
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-core</artifactId>
    <version>5.3.13.RELEASE</version>
</dependency>
```
* jasypt
* version 설정해주기
```
<org.jasypt-version>1.9.3</org.jasypt-version>
```
```
<!-- https://mvnrepository.com/artifact/org.jasypt/jasypt -->
<dependency>
    <groupId>org.jasypt</groupId>
    <artifactId>jasypt</artifactId>
    <version>${org.jasypt-version}</version>
</dependency>
```
```
<!-- https://mvnrepository.com/artifact/org.jasypt/jasypt-spring31 -->
<dependency>
    <groupId>org.jasypt</groupId>
    <artifactId>jasypt-spring31</artifactId>
    <version>${org.jasypt-version}</version>
</dependency>
 ```

## 데이터 유효성 검사 도구
* 서버(Controller) 단에서 데이터 유효성 검사 도구
* validation api (final)
```
<!-- https://mvnrepository.com/artifact/javax.validation/validation-api -->
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>
```

* hibernate validator (final)
```
<!-- https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator -->
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.2.3.Final</version>
</dependency>
```

* Spring framework 5.x 버전에서는 서버단 유효성 검사를 위해 framework 관련 요소를 추가해 주어야 한다
* spring Context support
```
<!-- https://mvnrepository.com/artifact/org.springframework/spring-context-support -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context-support</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
```

## MIME type
* 인터넷을 통해서 다양한 형태의 데이터를 보낼 때 서버와 웹 브라우저, 클라이언트 간에 데이터의 형식을 지정하는 방식
* 일반적으로 html 데이터는 text/html 형식으로 기본값으로 설정되어 있다
* 만약 html 데이터를 text/plan 형식으로 보내면 웹 브라우저에 html tag가 단순한 문자열로 그대로 노출된다
* MIME type은 인터넷 환경이 발전할 수록 계속 많아지고 더욱 다양해진다
* 현재 주로 많이 사용하는 것은 text/html, image/jpg, video/mp4, audio/mp3, application/json 등이 있다