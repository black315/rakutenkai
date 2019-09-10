package com.rakuten.internship.service;

import com.rakuten.internship.entity.Todo;
import com.rakuten.internship.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

//    @Autowired
//    private GoogleCredential credential;

//    @Autowired
//    private Gson gson;

    public List<Todo> findTodos() {
        return todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

//    public String translate(Todo todo) {
//        return TranslateOptions.getDefaultInstance().getService()
//            .translate(todo.getText(),
//                TranslateOption.sourceLanguage(todo.getSourceLanguage()),
//                TranslateOption.targetLanguage(todo.getTargetLanguage()))
//            .getTranslatedText();
//    }

//    public String translate2(Todo todo) throws JsonSyntaxException, ParseException, IOException, HttpException {
//        try (CloseableHttpResponse response = HttpClients.createDefault().execute(createQueryHttpPost(todo));) {
//            int statusCode = response.getStatusLine().getStatusCode();
//            if (statusCode == HttpStatus.SC_OK) {
//                return parseTranslationText(response.getEntity());
//            } else {
//                throw new HttpException(Integer.toString(statusCode));
//            }
//        }
//    }

//    private HttpPost createQueryHttpPost(Todo todo) {
//        return new HttpPost("https://translation.googleapis.com/language/translate/v2") {{
//            addHeader("Content-Type", "application/json; charset=UTF-8");
//            addHeader("Authorization", "Bearer " + credential.getAccessToken());
//            setEntity(new StringEntity(gson.toJson(createQueryJsonObject(todo)), "UTF-8"));
//        }};
//    }

//    private JsonObject createQueryJsonObject(Todo todo) {
//        JsonObject req = new JsonObject();
//        req.addProperty("q", todo.getText());
//        req.addProperty("source", todo.getSourceLanguage());
//        req.addProperty("target", todo.getTargetLanguage());
//        req.addProperty("format", "text");
//        return req;
//    }
    
//    private String parseTranslationText(HttpEntity entity) throws JsonSyntaxException, ParseException, IOException {
//        return gson.fromJson(EntityUtils.toString(entity, "UTF-8"), JsonObject.class)
//            .getAsJsonObject("data")
//            .getAsJsonArray("translations")
//            .get(0)
//            .getAsJsonObject()
//            .get("translatedText")
//            .getAsString();
//    }

}