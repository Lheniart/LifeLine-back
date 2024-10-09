package fr.epsi.lifelineback.DAE;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class DaeController {

    private final DaeService daeService;

    @PostMapping("/process")
    public ResponseEntity<String> processJson(@RequestBody String url) throws IOException {

            daeService.processCsvFile(url);
            return ResponseEntity.ok("JSON file processed successfully.");

    }

}
