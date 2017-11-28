package com.kotlin.basic.test

import java.io.*
import java.nio.ByteBuffer
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

fun main(args: Array<String>) {
    val x1 = System.nanoTime()
    getFileIO("src/main/resources/customer.xml")
    val x2 = System.nanoTime()
    getFileNIO("src/main/resources/customer.xml")
    val x3 = System.nanoTime()
    getFileDirect("src/main/resources/customer.xml");
    val x4 = System.nanoTime()
    println("${x2-x1}")
    println("${x3-x2}")
    println("${x4-x3}")
}

fun getFileIO(file: String): String {
    val content = StringBuilder()
    val newLine = "\n"
    val inputStream: InputStream = File(file).inputStream()
    inputStream.bufferedReader().useLines { lines -> lines.forEach { content.append(it).append(newLine) } }
    println(content)
    return content.toString()
}

fun getFileDirect(file: String): String {
    val content = StringBuilder()
    val newLine = "\n"
    File(file).useLines { lines -> lines.forEach { content.append(it).append(newLine) }}
    println(content)
    return content.toString()
}

fun getFileNIO(file: String): String {
    val content = StringBuilder()
    val charSet = Charset.forName(StandardCharsets.UTF_8.name())
    val aFile = RandomAccessFile (file, "r")
    val fChannel = aFile.channel
    val buffer = ByteBuffer.allocate(2048)
    while (fChannel.read(buffer) != -1) {
        buffer.flip()
        content.append(charSet.decode(buffer))
        buffer.flip()
    }
    fChannel.close()
    aFile.close()
    println(content)
    return content.toString()
}
