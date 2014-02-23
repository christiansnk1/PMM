package com.example.ejerciciobbdd;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button bColegios;
	Button bPersonal;
	Button bProfesores;
	Button bConsultas;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bColegios=(Button)findViewById(R.id.btn_colegios);
		bPersonal=(Button)findViewById(R.id.btn_personal);
		bProfesores=(Button)findViewById(R.id.btn_profesores);

		
		bColegios.setOnClickListener(this);
		bPersonal.setOnClickListener(this);
		bProfesores.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==bColegios){
			Intent i1 = new Intent(MainActivity.this,InsertarPersonal.class);
        	startActivity(i1);
  
			
			
		}
		if(v==bPersonal){
			Intent i2 = new Intent(MainActivity.this,ConsultaCentros.class);
        	startActivity(i2);
			
			
		}
		if(v==bProfesores){
			Intent i3 = new Intent(MainActivity.this,InsertarProfesor.class);
        	startActivity(i3);
			
			
		}
		if(v==bConsultas){
			
		}
		
		
	}
	
	

}
