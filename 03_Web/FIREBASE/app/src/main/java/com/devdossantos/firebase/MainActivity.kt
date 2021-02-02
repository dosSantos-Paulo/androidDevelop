package com.devdossantos.firebase

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import pl.droidsonroids.gif.GifImageView


class MainActivity : AppCompatActivity() {

    data class User(val name: String = "", val idade: Int = 1)

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        firebaseRealtime()

//        procurarArquivoUri()

        findViewById<Button>(R.id.btn_procurarImagem).setOnClickListener {
            procurarArquivo()
        }

        findViewById<Button>(R.id.btn_enviarImagem).setOnClickListener {
            enviarArquivo()
        }

    }

    private fun procurarArquivoUri() {
        val firebase = FirebaseStorage.getInstance()
        val store = firebase.getReference("uploads")

        store.child("profile.png").downloadUrl.addOnSuccessListener {
            Picasso.get().load(it).into(findViewById<ImageView>(R.id.img_image))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CONTEXT_RESQUEST_CODE && resultCode == RESULT_OK) {
            imageUri = data?.data
            findViewById<VideoView>(R.id.img_image).setVideoURI(imageUri)
        }
    }


    fun enviarArquivo() {
        imageUri?.run {
            val firebase = FirebaseStorage.getInstance()
            val storage = firebase.getReference("uploads")

            val extension = MimeTypeMap.getSingleton()
                .getExtensionFromMimeType(contentResolver.getType(imageUri!!))

//            val fileReference = storage.child("${currentTimeMillis()}.${extension}")

            val fileReference = storage.child("profile.${extension}")

            fileReference.putFile(this)
                .addOnSuccessListener {
                    Toast.makeText(this@MainActivity, "Sucesso!!", Toast.LENGTH_LONG).show()
                    Log.d("PROGRESS:", fileReference.toString())
                }
                .addOnFailureListener {
                    Toast.makeText(this@MainActivity, "Deu ruim!!", Toast.LENGTH_LONG).show()
                }
                .addOnProgressListener { it ->
                    val progress = 100.0 * (it.bytesTransferred / it.totalByteCount)
                    Log.d("PROGRESS:", progress.toString())
                    val currentprogress = progress.toInt()
                    findViewById<ProgressBar>(R.id.progressBar).setProgress(currentprogress)
                }
        }
    }

    fun procurarArquivo() {
        val intent = Intent()
        intent.type = "video/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, CONTEXT_RESQUEST_CODE)
    }

    companion object {
        const val CONTEXT_RESQUEST_CODE = 1
    }
}