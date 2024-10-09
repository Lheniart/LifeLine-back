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
    public void processCsvFile(String filePath) throws IOException {
        try (var fileReader = new FileReader(filePath)) {
            CsvToBean<DaeTransferDTO> csvToBean = new CsvToBeanBuilder<DaeTransferDTO>(fileReader)
                    .withType(DaeTransferDTO.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .withThrowExceptions(false)  // Ignorer les lignes incorrectes
                    .build();

            List<DaeTransferDTO> entities = csvToBean.parse();
            int lineNumber = 1; // Pour suivre le numéro de ligne

            for (DaeTransferDTO entityDto : entities) {
                try {
                    // Conversion et création de l'entité
                    DaeEntity entity = new DaeEntity(
                            Integer.parseInt(entityDto.getGid()),  // Conversion de String en Integer
                            entityDto.getCNom(),
                            BigDecimal.valueOf(entityDto.getCLatCoor1()),  // Conversion en BigDecimal
                            BigDecimal.valueOf(entityDto.getCLongCoor1()),
                            entityDto.getCAdrNum(),
                            entityDto.getCAdrVoie(),
                            entityDto.getCComCp(),
                            entityDto.getCComNom(),
                            DaeEntity.Acces.Exterieur, // Valeur par défaut
                            entityDto.getCAccLib(),
                            entityDto.getCPhoto1(),
                            entityDto.getCDispJ(),
                            entityDto.getCDispH(),
                            entityDto.getCEtatFonct()
                    );

                    // Gestion des accès (Intérieur/Extérieur)
                    if ("Extérieur".equalsIgnoreCase(entityDto.getCAcc())) {
                        entity.setAcces(DaeEntity.Acces.Exterieur);
                    } else if ("Intérieur".equalsIgnoreCase(entityDto.getCAcc())) {
                        entity.setAcces(DaeEntity.Acces.Interieur);
                    }

                    // Enregistrer dans la base de données
                    daeRepository.save(entity);

                } catch (NumberFormatException e) {
                    System.out.println("Erreur de conversion des données à la ligne " + lineNumber + ": " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Erreur lors du traitement de la ligne " + lineNumber + ": " + e.getMessage());
                }
                lineNumber++; // Incrémenter le compteur de ligne
            }

        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier CSV: " + e.getMessage());
        }
    }
}
