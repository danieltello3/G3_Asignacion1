package pe.edu.grupo3_asignacion1.configs
//import pe.edu.ulima.dbaccess.services.PokemonService
import android.util.Log
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BackendClient {

    //const val BASE_URL = "https://programamovilv2.jose-jesusjes13.repl.co/"
    const val BASE_URL ="http://10.154.206.145:8000/"
    private val retrofit: Retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build();
    }

    fun <T> buildService(service: Class<T>): T{
        Log.d("TAG","Esta ingresando al buildService")
        return retrofit.create(service)
    }
}