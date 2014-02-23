package com.example.ejerciciobbdd;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarPersonal extends Activity {
	
	EditText txt_cod,txt_dni, txt_apellidos,txt_func,txt_sal;
	Button btn_insertar,btn_consultar;
	
	int cod_centro,dni;
	String apellidos,funcion;
	float salario;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.insertar_personal);
	
	txt_cod=(EditText)findViewById(R.id.editText1);
	txt_dni=(EditText)findViewById(R.id.editText2);
	txt_apellidos=(EditText)findViewById(R.id.editText3);
	txt_func=(EditText)findViewById(R.id.editText4);
	txt_sal=(EditText)findViewById(R.id.editText5);
	
	btn_insertar=(Button)findViewById(R.id.boton_insertar_personal);
	
	btn_insertar.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			cod_centro=Integer.parseInt(txt_cod.getText().toString());
			dni=Integer.parseInt(txt_dni.getText().toString());
			apellidos=txt_apellidos.getText().toString();
			funcion=txt_func.getText().toString();
			salario=Float.parseFloat(txt_sal.getText().toString());
			
			CreaBase bbdd= new CreaBase(InsertarPersonal.this, "BaseDatos", null, 1) ;
			
			SQLiteDatabase bd = bbdd.getWritableDatabase();
			
			bd.execSQL("INSERT INTO personal VALUES("+cod_centro+","+dni+",\""+apellidos+"\",\""+funcion+"\","+salario+");");
			bd.close();
			
			Toast.makeText(InsertarPersonal.this, "Personal Insertado con exito", Toast.LENGTH_SHORT).show();
			
		}
	});
}


}
