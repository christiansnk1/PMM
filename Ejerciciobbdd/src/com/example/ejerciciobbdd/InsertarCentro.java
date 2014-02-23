package com.example.ejerciciobbdd;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarCentro extends Activity{

	EditText txt_cod,txt_tip,txt_nom,txt_dir,txt_tel,txt_num_plz;
	Button btn_insertar,btn_consultar;
	int cod,num_plazas;
	String nom,dir,telf;
	char tipo;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insertar_colegios);

		txt_cod=(EditText)findViewById(R.id.editText1);
		txt_tip=(EditText)findViewById(R.id.editText2);
		txt_nom=(EditText)findViewById(R.id.editText3);
		txt_dir=(EditText)findViewById(R.id.editText4);
		txt_tel=(EditText)findViewById(R.id.editText5);
		txt_num_plz=(EditText)findViewById(R.id.editText6);
		
		
		btn_insertar=(Button)findViewById(R.id.button_insertarcolegio);
	
		
		btn_insertar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cod=Integer.parseInt(txt_cod.getText().toString());
				tipo=txt_tip.getText().toString().charAt(0);
				nom=txt_nom.getText().toString();
				dir=txt_dir.getText().toString();
				telf=txt_tel.getText().toString();
				num_plazas=Integer.parseInt(txt_num_plz.getText().toString());
				
				CreaBase bbdd= new CreaBase(InsertarCentro.this, "BaseDatos", null, 1) ;
				
				SQLiteDatabase bd = bbdd.getWritableDatabase();
				
				bd.execSQL("INSERT INTO centros VALUES ("+cod+",'"+tipo+"',\""+nom+"\",\""+dir+"\",\""+telf+"\","+num_plazas+");");
				bd.close();
				
				Toast.makeText(InsertarCentro.this, "Centro Insertado con exito", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
