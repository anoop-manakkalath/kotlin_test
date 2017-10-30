package co.test.kotlin.com.kotlin.jaxb

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
data class Customer(var name: String? = null, var age: Int = 0, var id: Int = 0)
