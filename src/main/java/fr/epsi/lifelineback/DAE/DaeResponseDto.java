package fr.epsi.lifelineback.DAE;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class DaeResponseDto {

    DaeEntity daeEntity;

    BigDecimal distance;
}
