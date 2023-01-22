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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	
	private Button 	buttonStar, buttonHash, buttonCall;
	private ImageButton buttonBackspace;
	private TextView phoneNumber;
	private List<Button> digitButtons = new ArrayList<>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
		getSupportActionBar().hide();
		setContentView(R.layout.activity_main);
		
		buttonStar = findViewById(R.id.buttonStar);
		buttonHash = findViewById(R.id.buttonHash);
		buttonCall = findViewById(R.id.buttonCall);
		buttonBackspace = findViewById(R.id.buttonBackspace);
		phoneNumber = findViewById(R.id.phoneNumber);
		
		digitButtons.add(findViewById(R.id.button0));
		digitButtons.add(findViewById(R.id.button1));
		digitButtons.add(findViewById(R.id.button2));
		digitButtons.add(findViewById(R.id.button3));
		digitButtons.add(findViewById(R.id.button4));
		digitButtons.add(findViewById(R.id.button5));
		digitButtons.add(findViewById(R.id.button6));
		digitButtons.add(findViewById(R.id.button7));
		digitButtons.add(findViewById(R.id.button8));
		digitButtons.add(findViewById(R.id.button9));
		
		for (int i = 0; i < digitButtons.size(); i++) {
			int finalI = i;
			digitButtons.get(i).setOnClickListener(view -> phoneNumber.setText(phoneNumber.getText().toString() + finalI));
		}
		
		buttonStar.setOnClickListener(view -> phoneNumber.setText(phoneNumber.getText().toString() + "*"));
		buttonHash.setOnClickListener(view -> phoneNumber.setText(phoneNumber.getText().toString() + "#"));
		buttonBackspace.setOnClickListener(view -> {
			if (phoneNumber.getText().toString().length() > 0) {
				phoneNumber.setText(phoneNumber.getText().toString().substring(0, phoneNumber.getText().length() - 1));
			}
		});
		
		buttonCall.setOnClickListener(view -> makePhoneCall());
	}
	
	private void makePhoneCall() {
		String number = phoneNumber.getText().toString();
		String dial = "tel:" + number;
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//			TODO: Permission denied reaction
			return;
		}
		startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
	}
}