package com.example.whatsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp.VMs.API.MainViewModel
import com.example.whatsapp.VMs.API.Repository
import com.example.whatsapp.VMs.App.WhatsAppVM
import com.example.whatsapp.lsPage.LSComp
import com.example.whatsapp.ui.theme.WhatsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navStateBig = rememberNavController()

                    val repo = Repository()
                    val viewModel = MainViewModel(repo)
                    val model = WhatsAppVM(viewModel,this , navController = navStateBig )


                    Box(modifier = Modifier.fillMaxSize()){

                        NavHost(navController = navStateBig , startDestination = "lsPage" ){
                            composable("lsPage"){
                                LSComp(navController = navStateBig, model = model )
                            }
                            composable("homePage"){
                                //LSComp(navController = navStateBig, model = model )
                            }
                        }
                    }


                }
            }
        }
    }
}

