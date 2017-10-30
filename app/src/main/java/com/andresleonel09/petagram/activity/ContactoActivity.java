package com.andresleonel09.petagram.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.andresleonel09.petagram.R;
import com.andresleonel09.petagram.utils.Mail;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

public class ContactoActivity extends AppCompatActivity {

    EditText eNombre, eEmail, eMensaje;
    AppCompatButton btnEnviar;

    private ProgressDialog progressBar;
    private int progressBarStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        eNombre = (EditText) findViewById(R.id.txtNombre);
        eEmail = (EditText) findViewById(R.id.txtEmail);
        eMensaje = (EditText) findViewById(R.id.txtMensaje);
        btnEnviar = (AppCompatButton) findViewById(R.id.btnEnviar);

        setToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                sendMessage();
            }
        });
    }

    private void setToolbar() {
        Toolbar miActionBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(miActionBar);
    }

    private void sendMessage() {
        String[] recipients = {eEmail.getText().toString()};
        SendEmailAsyncTask email = new SendEmailAsyncTask(this);
        email.activity = (MainActivity) getParent();
        email.m = new Mail(getResources().getString(R.string.user_mail), getResources().getString(R.string.user_pass));
        email.m.set_from(getResources().getString(R.string.user_mail));
        email.m.setBody(eMensaje.getText().toString());
        email.m.set_to(recipients);
        email.m.set_subject("Comentario de: "+eNombre.getText().toString());
        email.execute();
    }

    public void displayMessage(String message) {
        Snackbar.make(findViewById(R.id.contactoLayout), message, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }

    private class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
        Mail m;
        MainActivity activity;

        public SendEmailAsyncTask(ContactoActivity activity) {
            progressBar = new ProgressDialog(activity);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                if (m.send()) {
                    displayMessage(getResources().getString(R.string.succ_email_enviado));
                } else {
                    displayMessage(getResources().getString(R.string.err_email_failed_send));
                }
                return true;
            } catch (AuthenticationFailedException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Bad account details");
                e.printStackTrace();
                if(getResources().getString(R.string.user_mail).equals("email")){
                    displayMessage(getResources().getString(R.string.err_email_faltante));
                }else {
                }
                return false;
            } catch (MessagingException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Email failed");
                e.printStackTrace();
                displayMessage("Email failed to send.");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                displayMessage("Unexpected error occured.");
                return false;
            }
        }
        @Override
        protected void onPreExecute() {
            progressBar.setCancelable(true);
            progressBar.setMessage(getResources().getString(R.string.enviando_email));
            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressBar.setProgress(0);
            progressBar.setMax(100);
            progressBar.show();
            progressBarStatus = 0;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (progressBar.isShowing()) {
                progressBar.dismiss();
            }
        }
    }
}
