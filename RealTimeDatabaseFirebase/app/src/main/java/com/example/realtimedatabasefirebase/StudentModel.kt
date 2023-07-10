package com.example.realtimedatabasefirebase

class StudentModel {
    lateinit var id: String
    lateinit var fname: String
    lateinit var lname: String
    lateinit var mobile: String
    lateinit var email: String
    lateinit var password: String

    constructor(id: String, fname: String, lname: String, mobile: String, email: String, password: String) {
        this.id = id
        this.fname = fname
        this.lname = lname
        this.mobile = mobile
        this.email = email
        this.password = password

    }


    constructor(){


    }
}