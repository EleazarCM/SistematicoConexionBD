package ni.edu.uca.sistematicopersistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import ni.edu.uca.sistematicopersistencia.data.database.BaseDatos
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtnombre = findViewById<EditText>(R.id.etNombreProducto)
        val precio = findViewById<EditText>(R.id.etPrecioProducto)
        val existencia = findViewById<EditText>(R.id.etCantidadExistencia)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        val room= Room.databaseBuilder(this, BaseDatos::class.java, "Persona").allowMainThreadQueries().build()

        val dao = room.productoDao()


        btnGuardar.setOnClickListener(){
            dao.insertarReg(producto= EntityProducto(nombre = txtnombre.text.toString(), precio = precio.text.toString().toDouble(), existencia = existencia.text.toString().toInt()))

        }
    }


}