MobileCrimeTrackingSystem
=========================

Mobile Crime Tracking System with Android

Based on smart phones we established a mobile crime tracking system
which has the following functions:
1. Request infomation from the sever such as wanted criminals or lost
vehicles.
2. Using smart phones to collect infomation on crime scene and upload it
to the sever.
3.Using GPS to locate the client or request the position of a certain
address.

Package name and descriptions:
com.amaker.mp           Main package for the system, including main menu
and according activities

com.amaker.mp.fileupload  Package for uploading files

com.amaker.mp.infoquery   Package for requesting information

com.amaker.mp.infocollect  Package for collecting information

com.amaker.mp.location      Package for GPS locations

com.amaker.mp.location      Other utilities used

Login function is done by Http Client with Apache, we defined a class
named HttpUtil on the sever end. Also we use Model-View-Controller +
Data Access Object to set up the server.

Java Database Connectivity is used to access the database which is built
up using SQL. In practice, Tomcat server has to be set up.
