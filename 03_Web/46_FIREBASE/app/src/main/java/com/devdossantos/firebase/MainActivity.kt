package com.devdossantos.firebase

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    data class User(val name: String = "", val idade: Int = 1)

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseRealtime()

        procurarArquivoUri()

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
            findViewById<ImageView>(R.id.img_image).setImageURI(imageUri)
        }
    }

//    private fun getFileName(uri: Uri): String? {
//        var result: String? = null
//        if (uri.scheme == "content") {
//            val cursor: Cursor? = contentResolver.query(uri, null, null, null, null)
//            try {
//                if (cursor != null && cursor.moveToFirst()) {
//                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
//                }
//            } finally {
//                cursor?.close()
//            }
//        }
//        if (result == null) {
//            result = uri.path
//            val cut = result!!.lastIndexOf('/')
//            if (cut != -1) {
//                result = result.substring(cut + 1)
//            }
//        }
//        return result
//    }


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
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, CONTEXT_RESQUEST_CODE)
    }

    private fun firebaseRealtime() {
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

//                myRef.setValue(User("Paulo", 29))

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(User::class.java)
                Toast.makeText(this@MainActivity, value?.idade.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })
    }

    companion object {
        const val CONTEXT_RESQUEST_CODE = 1
    }
}