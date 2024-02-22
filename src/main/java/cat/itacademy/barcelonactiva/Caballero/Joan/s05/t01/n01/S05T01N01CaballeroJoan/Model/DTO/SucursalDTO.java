package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.DTO;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Domain.Sucursal;

import java.util.Arrays;
import java.util.List;

public class SucursalDTO {

    private Integer pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;

    public SucursalDTO(){}

    public SucursalDTO(Integer pk_SucursalID, String nomSucursal, String paisSucursal, String tipusSucursal){
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
        this.pk_SucursalID = pk_SucursalID;
        this.tipusSucursal = tipusSucursal;
    }

    //private static final List<String> paisos = Arrays.asList("Àustria", "Bèlgica", "Bulgària", "Croàcia", "República de Xipre", "República Txeca", "Dinamarca", "Estònia", "Finlàndia", "França", "Alemanya", "Grècia", "Hongria", "Irlanda", "Itàlia", "Letònia", "Lituània", "Luxemburg", "Malta", "Països Baixos", "Polònia", "Portugal", "Romania", "Eslovàquia", "Eslovènia", "Espanya", "Suècia");


    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }

//    public static SucursalDTO toSucursalDTO(Sucursal sucursal) {
//        SucursalDTO sucursalDTO = new SucursalDTO();
//
//        sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
//        sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
//        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
//
//        if (paisos.contains(sucursal.getPaisSucursal())){
//            sucursalDTO.setTipusSucursal("UE");
//        } else {
//            sucursalDTO.setTipusSucursal("Fora UE");
//        }
//
//        return sucursalDTO;
//    }
//
//    public static Sucursal fromSucursalDTO(SucursalDTO sucursalDTO){
//        Sucursal sucursal = new Sucursal();
//
//        sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
//        sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
//        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
//
//        return sucursal;
//    }
}
