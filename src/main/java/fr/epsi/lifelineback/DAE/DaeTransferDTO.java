package fr.epsi.lifelineback.DAE;

import com.opencsv.bean.CsvBindByName;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DaeTransferDTO {

    @CsvBindByName(column = "gid")
    private String gid;

    @CsvBindByName(column = "c_gid")
    private String cGid;

    @CsvBindByName(column = "c_etat_valid")
    private String cEtatValid;

    @CsvBindByName(column = "c_nom")
    private String cNom;

    @CsvBindByName(column = "c_x_coor2")
    private String cXCoor2;

    @CsvBindByName(column = "c_y_coor2")
    private String cYCoor2;

    @CsvBindByName(column = "c_lat_coor1")
    private Double cLatCoor1;

    @CsvBindByName(column = "c_long_coor1")
    private Double cLongCoor1;

    @CsvBindByName(column = "c_xy_precis")
    private String cXyPrecis;

    @CsvBindByName(column = "c_id_adr")
    private String cIdAdr;

    @CsvBindByName(column = "c_adr_num")
    private Integer cAdrNum;

    @CsvBindByName(column = "c_adr_voie")
    private String cAdrVoie;

    @CsvBindByName(column = "c_com_cp")
    private String cComCp;

    @CsvBindByName(column = "c_com_insee")
    private String cComInsee;

    @CsvBindByName(column = "c_com_nom")
    private String cComNom;

    @CsvBindByName(column = "c_acc")
    private String cAcc;

    @CsvBindByName(column = "c_acc_lib")
    private Boolean cAccLib;

    @CsvBindByName(column = "c_acc_pcsec")
    private String cAccPcsec;

    @CsvBindByName(column = "c_acc_acc")
    private String cAccAcc;

    @CsvBindByName(column = "c_acc_etg")
    private String cAccEtg;

    @CsvBindByName(column = "c_acc_complt")
    private String cAccComplt;

    @CsvBindByName(column = "c_photo1")
    private String cPhoto1;

    @CsvBindByName(column = "c_photo2")
    private String cPhoto2;

    @CsvBindByName(column = "c_disp_j")
    private String cDispJ;

    @CsvBindByName(column = "c_disp_h")
    private String cDispH;

    @CsvBindByName(column = "c_disp_complt")
    private String cDispComplt;

    @CsvBindByName(column = "c_date_instal")
    private String cDateInstal;

    @CsvBindByName(column = "c_etat_fonct")
    private String cEtatFonct;

    @CsvBindByName(column = "c_lc_ped")
    private String cLcPed;

    @CsvBindByName(column = "c_dtpr_lcped")
    private String cDtprLcped;

    @CsvBindByName(column = "c_dtpr_lcad")
    private String cDtprLcad;

    @CsvBindByName(column = "c_dtpr_bat")
    private String cDtprBat;

    @CsvBindByName(column = "c_freq_mnt")
    private String cFreqMnt;

    @CsvBindByName(column = "c_dispsurv")
    private String cDispsurv;

    @CsvBindByName(column = "c_dermnt")
    private String cDermnt;

    @CsvBindByName(column = "c_maj_don")
    private String cMajDon;

    @CsvBindByName(column = "c_expt_siren")
    private String cExptSiren;

    @CsvBindByName(column = "c_expt_rais")
    private String cExptRais;

    @CsvBindByName(column = "c_etat")
    private String cEtat;

    @CsvBindByName(column = "c_application_provenance")
    private String cApplicationProvenance;

    @CsvBindByName(column = "c_doublon")
    private Boolean cDoublon;

    @CsvBindByName(column = "c__edit_datemaj")
    private String cEditDatemaj;

    @CsvBindByName(column = "c_srid_origin")
    private String cSridOrigin;

    @CsvBindByName(column = "the_geom")
    private String theGeom;

    @CsvBindByName(column = "cc_photo1")
    private String ccPhoto1;
}
