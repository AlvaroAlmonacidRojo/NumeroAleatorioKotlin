package net.azarquiel.numeroaleatoriokotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener  {


    var numeroAleatorio:Int = 0
    var numeroMostrar:Int = 50
    var contador:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     numeroAleatorio= Random().nextInt(100)+1;

        tvNumero.text="50"

        ponOrejas()

        if(numeroMostrar>numeroAleatorio){
            hacerInvisibleLaFoto(iVmas)
            hacerVisibleLaFoto(iVmenos)
        }else if(numeroMostrar<numeroAleatorio){
            hacerInvisibleLaFoto(iVmenos)
            hacerVisibleLaFoto(iVmas)
        }else{
            tvAcertado.setTextColor(Color.parseColor("#00ff00"))
            tvAcertado.text="ACERTADO!!!!!"

            quitaOrejas()
            hacerVisibleLaFoto(iVmenos)
            hacerVisibleLaFoto(iVmas)
        }



    }

    override fun onClick(v: View) {

        val valor: Int  = v.tag.toString().toInt()

        numeroMostrar+=valor;

        if(numeroMostrar==numeroAleatorio){
            //tambien podemos utilizar para poner el color resources.getColor(R.color.green)
            tvAcertado.setTextColor(Color.parseColor("#00ff00"))
            tvAcertado.text="ACERTADO!!!!!"

            quitaOrejas()
            hacerVisibleLaFoto(iVmenos)
            hacerVisibleLaFoto(iVmas)
            tvConta.text="Contador: "+contador.toString();
            tvNumero.text= numeroMostrar.toString()
        }else{
            if(numeroMostrar>numeroAleatorio){
                hacerInvisibleLaFoto(iVmas)
                hacerVisibleLaFoto(iVmenos)
            }else if(numeroMostrar<numeroAleatorio){
                hacerInvisibleLaFoto(iVmenos)
                hacerVisibleLaFoto(iVmas)
            }

            tvAcertado.text="Siga probando suerte"
            contador++
            tvNumero.text= numeroMostrar.toString()
            tvConta.text="Contador: "+contador.toString();
        }

    }

    private fun hacerInvisibleLaFoto(v: View) {
        v.visibility = View.INVISIBLE;
    }

    private fun hacerVisibleLaFoto(v: View) {
        v.visibility = View.VISIBLE;
    }

    private fun ponOrejas(){
        btnmas1.setOnClickListener(this)
        btnmas5.setOnClickListener(this)
        btnmas10.setOnClickListener(this)
        btnmenos1.setOnClickListener(this)
        btnmenos5.setOnClickListener(this)
        btnmenos10.setOnClickListener(this)
    }

    private fun quitaOrejas(){
        btnmas1.setOnClickListener(null)
        btnmas5.setOnClickListener(null)
        btnmas10.setOnClickListener(null)
        btnmenos1.setOnClickListener(null)
        btnmenos5.setOnClickListener(null)
        btnmenos10.setOnClickListener(null)
    }
}
