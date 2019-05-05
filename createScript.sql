/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jason
 * Created: May 4, 2019
 */

CREATE DATABASE IF NOT EXISTS tobadb;

CREATE TABLE IF NOT EXISTS tobadb.UserPass (
    UserName varchar(15) NOT NULL PRIMARY KEY,
    Password varchar(15) NOT NULL
);

INSERT INTO tobadb.UserPass VALUES ('admin', 'sesame');

CREATE TABLE IF NOT EXISTS tobadb.UserRole (
    UserName varchar(15) NOT NULL,
    RoleName varchar(15) NOT NULL,

    PRIMARY KEY(UserName, RoleName)
);

INSERT INTO tobadb.UserRole VALUES ('admin', 'sesame'); 

CREATE TABLE IF NOT EXISTS tobadb.Users (

);

CREATE TABLE tobadb.Users (
    UserID int NOT NULL AUTO_INCREMENT,
    FirstName varchar(255) NOT NULL,
    LastName varchar(255) NOT NULL,
    Phone varchar(255) NOT NULL,
    Address varchar(255) NOT NULL,
    City varchar(255) NOT NULL,
    `State` varchar(255) NOT NULL,
    ZipCode varchar(255) NOT NULL,
    Email varchar(255) NOT NULL,
    UserName varchar(255) NOT NULL,
    Password varchar(255) NOT NULL,

    PRIMARY KEY (UserID)
); 

INSERT INTO tobadb.Users VALUES ('1', 'jsmith', '', '', '', '', '', '', '', 'jsmith', 'letmein'); 