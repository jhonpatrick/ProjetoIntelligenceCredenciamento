package br.com.intelligence;

import android.app.Activity;
import android.app.LauncherActivity.IconResizer;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import br.com.intelligence.R;

import com.google.zxing.client.android.history.HistoryActivity;

public class Intelligence extends Activity {

	TextView user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intelligence);
		user = (TextView) findViewById(R.id.txtUser);
		
		  String logado;

	        Intent intent = getIntent();

	        Bundle dados = intent.getExtras();

	        logado = dados.getString("login").toString();

	        user.setText("Olá, "+ logado);
		

	}

	public void digitalizar(View view) {
		Intent intent = new Intent(this,
				br.com.intelligence.TelaDeAtividades.class);
		startActivity(intent);
		// finish();
	}

	public void historicoQr(View view) {
		Intent passaTela = new Intent(this, HistoryActivity.class);
		startActivity(passaTela);

	}

	// metodo sair...
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		this.finishActivity(0);
	}
}
