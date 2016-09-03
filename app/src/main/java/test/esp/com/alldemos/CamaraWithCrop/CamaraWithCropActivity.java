package test.esp.com.alldemos.CamaraWithCrop;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import test.esp.com.alldemos.CropImage.CropImage;
import test.esp.com.alldemos.R;

/**
 * Created by admin on 18/5/16.
 */
public class CamaraWithCropActivity extends Activity {

    public static final String IMAGE_PATH = Environment.getExternalStorageDirectory() + "/AllDemo/Upload/";
    TextView txtGallery;
    TextView txtCamera;
    ImageView imgSelect;
    File mfile;
    int OPEN_GALLARY_CODE = 200;
    int OPEN_CAMARA_CODE = 400;
    int OPEN_CROP_CODE = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_camera_crop);

        System.out.println("============onCreate=============");

        txtGallery = (TextView) findViewById(R.id.txtGallery);
        txtCamera = (TextView) findViewById(R.id.txtCamera);
        imgSelect = (ImageView) findViewById(R.id.imgSelect);

        txtGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePath();

                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent, OPEN_GALLARY_CODE);
            }
        });

        txtCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePath();

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    Uri mImageCaptureUri = Uri.fromFile(mfile);
                    intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
                    intent.putExtra("return-data", false);
                    startActivityForResult(intent, OPEN_CAMARA_CODE);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        System.out.println("============onActivityResult=============");

        if (resultCode == RESULT_OK) {
            if (requestCode == OPEN_GALLARY_CODE) {
                try {
                    InputStream is = getContentResolver().openInputStream(data.getData());
                    FileOutputStream fos = new FileOutputStream(mfile);
                    copyStream(is, fos);
                    fos.close();
                    is.close();
                    startCropImage();
                } catch (Exception e) {

                }
            }

            if (requestCode == OPEN_CAMARA_CODE) {
                startCropImage();
            }
            if (requestCode == OPEN_CROP_CODE) {
                imgSelect.setImageURI(null);
                imgSelect.setImageURI(Uri.fromFile(mfile));
            }
        } else {

        }
    }

    public void imagePath() {
        File dir = new File(IMAGE_PATH);
        if (dir.exists() == true) {
            mfile = new File(IMAGE_PATH + "ProfilePic.png");
            if (mfile.exists()) {
                mfile.delete();
            }
            dir.delete();
            dir.mkdirs();
        } else {
            dir.mkdirs();
        }
        mfile = new File(IMAGE_PATH, "ProfilePic.png");
    }

    public static void copyStream(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
    }

    private void startCropImage() {
        try {
            Intent intent = new Intent(CamaraWithCropActivity.this, CropImage.class);
            intent.putExtra(CropImage.IMAGE_PATH, mfile.getPath());
            intent.putExtra(CropImage.SCALE, true);
            intent.putExtra(CropImage.ASPECT_X, 0);
            intent.putExtra(CropImage.ASPECT_Y, 0);
            startActivityForResult(intent, OPEN_CROP_CODE);
        } catch (Exception e) {
            Toast.makeText(CamaraWithCropActivity.this, e.toString(), Toast.LENGTH_LONG).show();
        }

    }
}
