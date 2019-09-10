package com.rakuten.internship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RakutenkaiApplication {

//    @Bean
//    public GoogleCredential getGoogleCredential() throws FileNotFoundException, IOException {
//        GoogleCredential credential = GoogleCredential
//            .fromStream(new FileInputStream(System.getenv("GOOGLE_APPLICATION_CREDENTIALS")))
//            .createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));
//        credential.refreshToken();
//        return credential;
//    }

	public static void main(String[] args) {
		SpringApplication.run(RakutenkaiApplication.class, args);
	}
}
