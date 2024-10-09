package fr.epsi.lifelineback.DAE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DaeService {

    private final DaeRepository daeRepository;


    public List<DaeEntity> findAllNearDae(FindAllNearDaeDTO findAllNearDaeDTO){
        return daeRepository.findNearbyDaes(findAllNearDaeDTO.getLatitude(), findAllNearDaeDTO.getLongitude(), findAllNearDaeDTO.getRange());
    }

}
