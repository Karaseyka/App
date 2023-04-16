package com.example.myapplication.feature.add;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.data.repository.ProjectRepository;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.feature.profile.Profile;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add extends AppCompatActivity {
    FirebaseStorage storage;
    StorageReference storageReference;

    private final int Pick_image = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_advertisment);
        FirebaseApp.initializeApp(getApplicationContext());
        ImageButton PickImage = findViewById(R.id.addFoto);
        Button bt = findViewById(R.id.ready);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp;
                sp = Add.this.getSharedPreferences("User_info", Context.MODE_PRIVATE);
                MutableLiveData<Projects> _project = new MutableLiveData<>();
                LiveData<Projects> project = _project;
                EditText et = findViewById(R.id.desc);
                TextView tv = findViewById(R.id.k);
                HashMap<String,String> SendData =new HashMap<>();
                SendData.put("name", "fjgh");
                SendData.put("description", et.getText().toString());
                SendData.put("user_nick", sp.getString(Profile.NICK, "unnamed"));

                SendData.put("foto_id", tv.getText().toString());


                ProjectRepository.addProject(SendData).enqueue(new Callback<Projects>() {

                    @Override
                    public void onResponse(@NonNull Call<Projects> call, @NonNull Response<Projects> response) {
                        _project.setValue(response.body());
                        Toast.makeText(Add.this, "Успешно", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<Projects> call, Throwable t) {

                    }
                });
            }
        });
        //Настраиваем для нее обработчик нажатий OnClickListener:
        PickImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Вызываем стандартную галерею для выбора изображения с помощью Intent.ACTION_PICK:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                //Тип получаемых объектов - image:
                photoPickerIntent.setType("image/*");
                //Запускаем переход с ожиданием обратного результата в виде информации об изображении:
                startActivityForResult(photoPickerIntent, Pick_image);

            }
        });
    }

    //Обрабатываем результат выбора в галерее:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case Pick_image:
                if (resultCode == RESULT_OK) {
                    try {
                        ImageView iv = (ImageView) findViewById(R.id.imageView);
                        //Получаем URI изображения, преобразуем его в Bitmap
                        //объект и отображаем в элементе ImageView нашего интерфейса:
                        Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        Glide.with(Add.this).load(imageUri.toString())
                                .into(iv);

                        String d = UUID.randomUUID().toString();
                        TextView tv = findViewById(R.id.k);
                        tv.setText(d);
                        StorageReference ref = storageReference.child("images/" + d);
                        ref.putFile(imageUri)
                                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        Toast.makeText(Add.this, "Uploaded", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        Toast.makeText(Add.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

}
