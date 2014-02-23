package com.example.ejerciciobbdd;



import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarProfesor extends Activity {
	
	EditText txt_cod,txt_dni,txt_ape,txt_fun,txt_sal;
	Button btn_insertar,btn_consultar;
	int cod , dni;
	String ape,func;
	float sal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insertar_profesores);
		
		txt_cod=(EditText)findViewById(R.id.editText1);
		txt_dni=(EditText)findViewById(R.id.editText2);
		txt_ape=(EditText)findViewById(R.id.editText3);
		txt_fun=(EditText)findViewById(R.id.editText4);
		txt_sal=(EditText)findViewById(R.id.editText5);
		
		btn_insertar=(Button)findViewById(R.id.boton_insertar_profesor);
		
		btn_insertar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				cod=Integer.parseInt(txt_cod.getText().toString());
				dni=Integer.parseInt(txt_dni.getText().toString());
				ape=txt_ape.getText().toString();
				func=txt_fun.getText().toString();
				sal=Float.parseFloat(txt_sal.getText().toString());
				
				CreaBase bbdd= new CreaBase(InsertarProfesor.this, "BaseDatos", null, 1) ;
				
				SQLiteDatabase bd = bbdd.getWritableDatabase();
				
				bd.execSQL("INSERT INTO profesores VALUES ("+cod+","+dni+",\""+ape+"\",\""+func+"\");");
				bd.close();
				
				Toast.makeText(InsertarProfesor.this, "Profesor Insertado con exito", Toast.LENGTH_SHORT).show();
				
				
			}
		});
		
	}

}
