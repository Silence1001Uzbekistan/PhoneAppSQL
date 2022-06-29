package uz.silence.phoneappsql.CLASS

import java.io.Serializable

class Phone :Serializable{

    var id:Int? = null
    var type:Int? = null
    var name:String? = null
    var info:String? = null



    constructor(id: Int?, type: Int?, name: String?, info: String?) {
        this.id = id
        this.type = type
        this.name = name
        this.info = info
    }

    constructor(type: Int?, name: String?, info: String?) {
        this.type = type
        this.name = name
        this.info = info
    }
}