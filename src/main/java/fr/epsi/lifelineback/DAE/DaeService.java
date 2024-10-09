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
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DaeService {

    private final DaeRepository daeRepository;


    public List<DaeResponseDto> findAllNearDae(FindAllNearDaeDTO findAllNearDaeDTO){
        List<DaeEntity> daeEntityList = daeRepository.findNearbyDaes(findAllNearDaeDTO.getLatitude(), findAllNearDaeDTO.getLongitude(), findAllNearDaeDTO.getRange());

        BigDecimal userLat = findAllNearDaeDTO.getUserLatitude();
        BigDecimal userLon = findAllNearDaeDTO.getUserLongitude();

        List<DaeResponseDto> result = new ArrayList<>();
        for (DaeEntity dae : daeEntityList) {
            if (userLat != null && userLon != null){
                BigDecimal distance = calculateDistanceInMeters(userLat, userLon, dae.getLatitude(), dae.getLongitude());
                result.add(new DaeResponseDto(dae, distance));
            }
            else {
                result.add(new DaeResponseDto(dae, new BigDecimal(0)));
            }
        }
        result.sort(Comparator.comparing(DaeResponseDto::getDistance));
        return result;
    }

    public BigDecimal calculateDistanceInMeters(BigDecimal lat1, BigDecimal lon1, BigDecimal lat2, BigDecimal lon2) {
        final BigDecimal EARTH_RADIUS_METERS = new BigDecimal("6371000"); // Rayon de la Terre en mètres
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

        // Convertir les degrés en radians
        BigDecimal latDistance = lat2.subtract(lat1).multiply(BigDecimal.valueOf(Math.PI)).divide(BigDecimal.valueOf(180), mc);
        BigDecimal lonDistance = lon2.subtract(lon1).multiply(BigDecimal.valueOf(Math.PI)).divide(BigDecimal.valueOf(180), mc);

        BigDecimal lat1Rad = lat1.multiply(BigDecimal.valueOf(Math.PI)).divide(BigDecimal.valueOf(180), mc);
        BigDecimal lat2Rad = lat2.multiply(BigDecimal.valueOf(Math.PI)).divide(BigDecimal.valueOf(180), mc);

        // Calcul de la formule de Haversine
        BigDecimal a = (BigDecimal.valueOf(Math.sin(latDistance.divide(BigDecimal.valueOf(2), mc).doubleValue())).pow(2))
                .add(BigDecimal.valueOf(Math.cos(lat1Rad.doubleValue()))
                        .multiply(BigDecimal.valueOf(Math.cos(lat2Rad.doubleValue())))
                        .multiply(BigDecimal.valueOf(Math.sin(lonDistance.divide(BigDecimal.valueOf(2), mc).doubleValue())).pow(2)));

        BigDecimal c = BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(Math.atan2(Math.sqrt(a.doubleValue()), Math.sqrt(BigDecimal.ONE.subtract(a).doubleValue()))));

        // Distance finale en mètres
        return EARTH_RADIUS_METERS.multiply(c, mc).setScale(3, RoundingMode.HALF_UP); // Distance en mètres, arrondie à 3 décimales
    }

}
