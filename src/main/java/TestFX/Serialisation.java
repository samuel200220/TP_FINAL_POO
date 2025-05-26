package TestFX;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Serialisation {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Map<String, Evenement> l1 = new HashMap<>();

    static {
        mapper.registerModule(new JavaTimeModule());
    }

//    public static void sauvegarderJSON(List<Evenement> evenements, String fichier) throws IOException {
//        ObjectWriter writer = mapper.writerFor(
//                mapper.getTypeFactory().constructCollectionType(List.class, Evenement.class)
//        ).withDefaultPrettyPrinter();
//
//        writer.writeValue(new File(fichier), evenements);
//    }
//
//
//    public static List<Evenement> chargerJSON(String fichier) throws IOException {
//        ObjectReader reader = mapper.readerFor(
//                mapper.getTypeFactory().constructCollectionType(List.class, Evenement.class)
//        );
//
//        return reader.readValue(new File(fichier));
//    }
public static void sauvegarderJSON(Map<String,Evenement> evenements, String fichier) throws IOException {
//    ObjectWriter writer = mapper.writerFor(
//            mapper.getTypeFactory().constructCollectionType(List.class, Evenement.class)
//    ).withDefaultPrettyPrinter();
//
//    writer.withAttribute("type","Evenement");
//    writer.writeValue(new File(fichier), evenements);
    mapper.writerFor(new TypeReference<Map<String, Evenement>>() {})
            .withDefaultPrettyPrinter()
            .writeValue(new File(fichier), evenements);
}

    public static Map<String,Evenement> chargerJSON(String fichier) throws IOException {
        File file = new File(fichier);
        if (!file.exists()) return new HashMap<>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return mapper.readValue(file, new TypeReference<Map<String, Evenement>>() {});
    }

}
