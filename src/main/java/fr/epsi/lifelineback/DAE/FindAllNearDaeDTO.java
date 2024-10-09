package fr.epsi.lifelineback.DAE;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class FindAllNearDaeDTO {

    BigDecimal latitude;
    BigDecimal longitude;
    BigDecimal range;
    BigDecimal userLatitude;
    BigDecimal userLongitude;
}
