package com.test.project.controller



class KotlinTraining {


    var stream: Boolean
    get() = field
    set(value) { field = value }

    var age: Int
        get() = field
        set(value) { field = value }


    constructor(age: Int, stream: Boolean){
        this.age = age
        this.stream = stream
    }


    fun sayHello() {
        var userName: String = "Mate"
        println("Hello World $userName.")
    }


}
