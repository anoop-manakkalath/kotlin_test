package com.kotlin.jaxb.test

import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class Library(@XmlAttribute val name: String) {
    constructor() : this("Unnamed Library")

    @XmlElement
    val book: MutableCollection<Book> = mutableListOf()
}