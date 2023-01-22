package com.objectable.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class MainActivity extends AppCompatActivity {
	
	Button 	button1,
			button2,
			button3,
			button4,
			button5,
			button6,
			button7,
			button8,
			button9,
			button0,
			buttonStar,
			buttonHash,
			buttonCall;
	ImageButton buttonBackspace;
	TextView phoneNumber;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = findViewById(R.id.button1);
		button2 = findViewById(R.id.button2);
		button3 = findViewById(R.id.button3);
		button4 = findViewById(R.id.button4);
		button5 = findViewById(R.id.button5);
		button6 = findViewById(R.id.button6);
		button7 = findViewById(R.id.button7);
		button8 = findViewById(R.id.button8);
		button9 = findViewById(R.id.button9);
		button0 = findViewById(R.id.button0);
		buttonStar = findViewById(R.id.buttonStar);
		buttonHash = findViewById(R.id.buttonHash);
		buttonCall = findViewById(R.id.buttonCall);
		buttonBackspace = findViewById(R.id.buttonBackspace);
		phoneNumber = findViewById(R.id.phoneNumber);
		
		Dexter.withContext(this).withPermission(Manifest.permission.CALL_PHONE).withListener(new PermissionListener() {
			@Override
			public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
			
			}
			
			@Override
			public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
			
			}
			
			@Override
			public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
			
			}
		}).check();
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "1");
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "2");
			}
		});
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "3");
			}
		});
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "4");
			}
		});
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "5");
			}
		});
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "6");
			}
		});
		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "7");
			}
		});
		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "8");
			}
		});
		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "9");
			}
		});
		button0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "0");
			}
		});
		buttonStar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "*");
			}
		});
		buttonHash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString() + "#");
			}
		});
		buttonBackspace.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneNumber.setText(phoneNumber.getText().toString().substring(0, phoneNumber.getText().length() - 1));
			}
		});
		
		buttonCall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				makePhoneCall();
			}
		});
	}
	
	private void makePhoneCall() {
		String number = phoneNumber.getText().toString();
		String dial = "tel:" + number;
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//			TODO: Permission denied
			return;
		}
		startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
	}
}