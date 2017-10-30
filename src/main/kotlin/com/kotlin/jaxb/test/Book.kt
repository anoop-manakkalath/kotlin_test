package com.kotlin.jaxb.test

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Book(val name: String, val author: String, val description: String) {
    constructor() : this("No name", "No author", "No description")
}