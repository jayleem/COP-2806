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