package com.kotlin.jaxb.test

import co.test.kotlin.com.kotlin.jaxb.Customer
import com.google.common.io.Resources
import java.io.StringWriter
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller

fun main(args: Array<String>) {
    val jaxbContext = JAXBContext.newInstance(Customer::class.java)
    val jaxbUnmarshaller = jaxbContext.createUnmarshaller()
    val customer = jaxbUnmarshaller.unmarshal(Resources.getResource("customer.xml"))
//    val customer = jaxbUnmarshaller.unmarshal(File("src/main/resources/customer.xml"))
    println(customer)

    val library = Library("My Library");
    library.book.add(Book("Book 1", "Author 1", "Description 1"))
    library.book.add(Book("Book 2", "Author 2", "Description 2"))
    library.book.add(Book("Book 3", "Author 3", "Description 3"))

    val jaxbWriteContext = JAXBContext.newInstance(Library::class.java)
    val marshaller = jaxbWriteContext.createMarshaller()
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)

    val stringWriter = StringWriter()
    stringWriter.use {
        marshaller.marshal(library, stringWriter)
    }

    println(stringWriter)
}