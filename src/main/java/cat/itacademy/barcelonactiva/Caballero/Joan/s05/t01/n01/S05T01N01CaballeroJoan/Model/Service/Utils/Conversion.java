package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service.Utils;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Domain.Sucursal;

import java.util.Arrays;
import java.util.List;

public class Conversion {

    private static final List<String> paisos = Arrays.asList("Àustria", "Bèlgica", "Bulgària", "Croàcia", "República de Xipre", "República Txeca", "Dinamarca", "Estònia", "Finlàndia", "França", "Alemanya", "Grècia", "Hongria", "Irlanda", "Itàlia", "Letònia", "Lituània", "Luxemburg", "Malta", "Països Baixos", "Polònia", "Portugal", "Romania", "Eslovàquia", "Eslovènia", "Espanya", "Suècia");

    public static SucursalDTO toSucursalDTO(Sucursal sucursal){
        Validation.validateSucursal(sucursal);
        return createDTO(sucursal);
    }

    private static SucursalDTO createDTO(Sucursal sucursal){
        Integer id = sucursal.getPk_SucursalID();
        String nom = sucursal.getNomSucursal();
        String pais = sucursal.getPaisSucursal();
        String tipus = setTipusSucursal(sucursal.getPaisSucursal());
        return new SucursalDTO(id, nom, pais, tipus);
    }

    private static String setTipusSucursal(String paisSucursal){
        if(paisos.contains(paisSucursal)){
            return "UE";
        } else{
            return "Fora UE";
        }
    }

    public static Sucursal DTOtoSucursal(SucursalDTO sucursalDTO){
        Integer id = sucursalDTO.getPk_SucursalID();
        String nom = sucursalDTO.getNomSucursal();
        String pais = sucursalDTO.getPaisSucursal();
        return new Sucursal(id, nom, pais);
    }
}
