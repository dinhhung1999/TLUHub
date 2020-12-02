package com.example.tlu_hub.model

class PopularModel ( private var id : Int, private var title : String, private var urlImage : String) {
    public var Id : Int
        get() {return id}
        set(value) {id = value}

    public var Title : String
        get() = title
        set(value) {title = value}

    public var UrlImage : String
        get() = urlImage
        set(value) {urlImage = value}

//    constructor(id : Int, title : String, urlImage : String)
//        init {
//            this.id = id
//            this.title = title
//            this.urlImage = urlImage
//        }
            
}