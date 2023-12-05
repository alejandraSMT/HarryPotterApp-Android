package com.example.harrypotterapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.data.HarryPoterrApiService
import com.example.harrypotterapp.data.model.Wand
import com.example.harrypotterapp.main.BottomBarApp
import com.example.harrypotterapp.main.NavigationGraph
import com.example.harrypotterapp.ui.theme.HarryPotterAppTheme
import com.example.harrypotterapp.ui.theme.gryffindorDarker
import com.example.harrypotterapp.views.byHouses.CharactersInHouseScreen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarryPotterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController: NavHostController = rememberNavController()
                    val bottomBarHeight = 56.dp
                    val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }

                    var buttonsVisible = remember { mutableStateOf(true) }

                    val character = Character(
                        name = "Harry Potter",
                        dateOfBirth = "31-07-1980",
                        gender = "male",
                        house = "gryffindor",
                        species = "human",
                        alive = true,
                        patronus = "stag",
                        image = "https://ik.imagekit.io/hpapi/harry.jpg",
                        wand = Wand(wood = "holly", length = 11.0, core = "phoenix tail feather")
                    )

                    Scaffold(
                        modifier = Modifier,
                        bottomBar = {
                            BottomBarApp(
                            navController = navController,
                            state = buttonsVisible
                        ) }
                    ) { padding ->
                        Box(
                            modifier = Modifier.padding(padding)
                        ) {
                            NavigationGraph(navController = navController)
                            //CharacterScreen(character = character)
                        }
                    }
                }
            }
        }
        getCharacters()
    }

    private fun getCharacters(){
        val api = Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HarryPoterrApiService::class.java)

        api.getCharacters().enqueue(object: Callback<List<Character>>{
            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        for (character in it){
                            Log.i("RESPONSE_PERSONAJES","onResponse: ${character.actor}")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                Log.e("ERROR","onFailure: ${t.message}")
            }

        })
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HarryPotterAppTheme {
        Greeting("Android")
    }
}