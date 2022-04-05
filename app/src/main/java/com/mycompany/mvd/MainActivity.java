package com.mycompany.mvd;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.net.*;

public class MainActivity extends Activity 
{
	VideoView vd;
	static int PICK_VIDEO_CODE=101;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		vd=findViewById(R.id.mainVideoView);
		vd.setMediaController(new MediaController(this));
    }
	public void onClick(View v)
	{
		Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("video/*");
		startActivityForResult(Intent.createChooser(intent,"Video Chooser"),PICK_VIDEO_CODE);
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO: Implement this method
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==PICK_VIDEO_CODE)
		{
			if(resultCode==RESULT_OK)
			{
				Uri uri=data.getData();
				vd.setVideoURI(uri);
				vd.requestFocus();
				vd.start();
				
			}
		}
	}
	
}
