package com.binbin.androidowner

import android.content.Context
import android.net.Uri
import android.widget.Toast
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream


fun uriToStream(
    context: Context,
    uri: Uri?,
    operation:(stream: InputStream)->Unit
){
    if(uri!=null){
        try{
            val stream = context.contentResolver.openInputStream(uri)
            if(stream!=null) { operation(stream) }
            else{ Toast.makeText(context, "空的流", Toast.LENGTH_SHORT).show() }
            stream?.close()
        }
        catch(e: FileNotFoundException){ Toast.makeText(context, "文件不存在", Toast.LENGTH_SHORT).show() }
        catch(e: IOException){ Toast.makeText(context, "IO异常", Toast.LENGTH_SHORT).show() }
    }else{ Toast.makeText(context, "空URI", Toast.LENGTH_SHORT).show() }
}