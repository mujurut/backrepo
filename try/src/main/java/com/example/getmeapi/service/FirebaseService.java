package com.example.getmeapi.service;

import com.example.getmeapi.model.FirebaseUser;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseService {

    public FirebaseApp initializeFirebase() throws IOException {


        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:backend.json");
        FileInputStream serviceAccount =
                new FileInputStream(resource.getFile());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();//.setDatabaseUrl("https://backend.firebase.com")


        return FirebaseApp.initializeApp(options);

    }

    public FirebaseUser authenticate(String idTOken) throws IOException, FirebaseAuthException {
        String uid = FirebaseAuth.getInstance(initializeFirebase()).verifyIdToken(idTOken).getUid();
        String name = FirebaseAuth.getInstance(initializeFirebase()).verifyIdToken(idTOken).getName();
        String email = FirebaseAuth.getInstance(initializeFirebase()).verifyIdToken(idTOken).getEmail();
        return new FirebaseUser(uid,name, email);
    }
}
