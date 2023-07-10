package com.example.tourprojecttest

class CulturalModalClass {

    lateinit var url: String
    lateinit var title: String
    lateinit var Aboutthisplace: String
    lateinit var Rating: String
    var status: Int = 0

    constructor(url: String, title: String, Aboutthisplace: String, Rating: String, status: Int) {
        this.url = url
        this.title = title
        this.Aboutthisplace = Aboutthisplace
        this.Rating = Rating
        this.status = status
    }

    constructor() {

    }
}