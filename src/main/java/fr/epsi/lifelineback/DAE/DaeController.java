package fr.epsi.lifelineback.DAE;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DaeController {

    private final DaeService daeService;


    @PostMapping("/dae/near")
    public List<DaeResponseDto> findAllNearDae(@RequestBody FindAllNearDaeDTO findAllNearDaeDTO){
        return daeService.findAllNearDae(findAllNearDaeDTO);
    }

}
