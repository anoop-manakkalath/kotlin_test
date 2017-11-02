package com.kotlin.basic.test

import java.io.*
import java.nio.ByteBuffer
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    val x1 = System.nanoTime()
    getFileIO("src/main/resources/customer.xml")
    val x2 = System.nanoTime()
    getFileNIO("src/main/resources/customer.xml")
    val x3 = System.nanoTime()
    getFileNew("src/main/resources/customer.xml");
    val x4 = System.nanoTime()
    println("${x2-x1}")
    println("${x3-x2}")
    println("${x4-x3}")
}

fun getFileIO(file: String): String {
    val content = StringBuilder()
    val file = File(file)
    val fr = FileReader(file)
    val br = BufferedReader(fr)
    var textRead = br.readLine()
    while (textRead != null) {
        content.append(textRead).append("\n")
        textRead = br.readLine()
    }
    br.close();
    println(content)
    return content.toString()
}

fun getFileNIO(file: String): String {
    val content = StringBuilder()
    val aFile = RandomAccessFile(file, "r")
    val fChannel = aFile.channel
    val buffer = ByteBuffer.allocate(1024)
    while (fChannel.read(buffer) > 0) {
        buffer.flip()
        content.append(Charset.forName("utf-8").decode(buffer).toString())
        buffer.flip()
    }
    fChannel.close()
    aFile.close()
    println(content)
    return content.toString()
}

fun getFileNew(file: String): String {
    val content = StringBuilder()
    val paths = Paths.get(file)
    Files.lines(paths).forEachOrdered { line ->  content.append(line).append("\n")}
    println(content)
    return content.toString()
}