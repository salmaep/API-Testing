# API-Testing

## Introduction
### DummyAPI.io
DummyAPI.io adalah sumber data API yang digunakan untuk pengujian. DummyAPI menyediakan data dummy yang dapat digunakan untuk mengembangkan, menguji, atau mendemonstrasikan fungsionalitas aplikasi tanpa harus terhubung ke sumber data yang sebenarnya.

### User Controller

**User Controller** adalah bagian dari aplikasi atau sistem yang bertanggung jawab untuk mengelola operasi yang berkaitan dengan user, seperti Create, Read, Update, dan Delete (CRUD) informasi user.

#### Base URL

``` bash
https://dummyapi.io/data/v1/

 ```

## Testing Tools
- IDE: visual studio code
- Alat build otomatis : Gradle
- Tools runing : Terminal
- Sistem operasi : Window
- Unit testing : Java (Junit)
- Bahasa pemrograman : Java
- Library pengujian API : Rest Assured

## Pre-requisites
1. Pastikan JDK (Java Development Kit) sudah terinstal di komputer Anda.
2. Pastikan Gradle sudah terinstal di komputer Anda.

## Project Tree Program
```
API-Testing
├─ .git
├─ .gitattributes
├─ .gitignore
├─ app
│  └─ src
│     ├─ main
│     │  ├─ java
│     │  │  └─ api
│     │  │     └─ testing
│     │  │        └─ App.java
│     │  └─ resources
│     └─ test
│        ├─ java
│        │  └─ api
│        │     └─ testing
│        │        ├─ CreateUserTest.java
│        │        ├─ DeleteUserTest.java
│        │        ├─ GetUserTest.java
│        │        └─ UpdateUserTest.java
│        └─ resources
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
└─ gradlew.bat
```

`src>test>java>api>testing` <br/>
Direktori ini digunakan untuk menyimpan file test `.java` atau program test java yang akan dijalankan, yang terdiri dari 4 file test program yaitu :<br/>
1. CreateUserTest.java <br/>
   File ini berisikan class Create User Test yang memuat script API testing untuk 5 method test case yang diuji.
2. DeleteUserTest.java <br/>
   File ini berisikan class Delete User Test yang memuat script API testing untuk 5 method test case yang diuji.
3. GetUserTest.java <br/>
   File ini berisikan class Get User Test yang memuat script API testing untuk 5 method test case yang diuji.
4. UpdateUserTest.java <br/>
   File ini berisikan class Update User Test yang memuat script API testing untuk 5 method test case yang diuji.

## Run Automation Test
Terdapat 2 cara untuk menjalankan automation test
1. Automation Testing Keseluruhan Project <br>
   Jalankan command berikut pada terminal
    ```
     ./gradlew clean test
     ```
2. Untuk suatu method tertentu <br>
   Jalankan command berikut pada terminal
    ```
     ./gradlew test --tests namaclass.namamethod
     ```
    
## Test Report
Test report adalah laporan yang dihasilkan setelah menjalankan serangkaian pengujian pada suatu perangkat lunak. Test report memberikan ringkasan tentang hasil pengujian yang dilakukan. Ini mencakup informasi tentang tes mana yang berhasil, tes mana yang gagal, serta hasilnya dalam berbagai format yang dapat membantu pengembang dalam menganalisis kinerja dan keandalan perangkat lunak mereka.

Untuk melihat hasil report dari test automation yang telah dijalankan akan tersimpan pada direktori berikut:
```
├─ build
│  ├─ generated
│  ├─ reports
│  │  └─ tests
│  │     └─ test
│  │        ├─ classes
│  │        ├─ css
│  │        ├─ index.html
```
### Hasil test resport 
Berikut merupakan contoh hasil test report pada file CreateUserTest.java
![Screenshot 2024-05-05 222809](https://github.com/salmaep/API-Testing/assets/95133669/8f0ac2d0-f373-4799-a43b-1cff6572db22)

## Author
1. 211524010 | Fariz Muhamad Ibnu Hisyam | [@farizibnu](https://github.com/farizibnu)
2. 211524025 | Salma Edyna Putri | [@salmaep](https://github.com/salmaep)
3. 211524028 | Tabitha Salsabila Permana | [@Tabitha2912](https://github.com/Tabitha2912)
