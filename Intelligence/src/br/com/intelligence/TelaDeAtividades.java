package br.com.intelligence;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class TelaDeAtividades extends Activity {

	private String dados_recolhidos;
	public static final int REQUEST_CODE = 0;
	Intent intentEv = getIntent();

	public Spinner spnEv, spnAtv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_de_atividades);

		try {
			JSONArray ev = new JSONArray(intentEv.getStringExtra("eventos"));
			Toast.makeText(this, ev.toString(), Toast.LENGTH_LONG).show();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		ArrayAdapter<String> adapterEventos = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, listEventos);
		
//		ArrayList<String> listAtividades = pegaEventos.getStringArrayList("atividades");

		

	}

	// tratando o bot�o iniciar
	public void iniciar(View view) {
		intentEv = new Intent(this,
				com.google.zxing.client.android.CaptureActivity.class);
		startActivityForResult(intentEv, REQUEST_CODE);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub

		if (REQUEST_CODE == requestCode && RESULT_OK == resultCode) {

			Bundle extras = data.getExtras();
			if (extras != null) {
				dados_recolhidos = "Resultado do SCANER: "
						+ extras.getString("SCAN_RESULT") + "( "
						+ extras.getString("SCAN_FORMAT") + ")";
				Log.d("dados", dados_recolhidos);
			}

		}

	}

	// saindo
	public void onBackPressed() {
		super.onBackPressed();
		this.finishActivity(0);
	}
}
