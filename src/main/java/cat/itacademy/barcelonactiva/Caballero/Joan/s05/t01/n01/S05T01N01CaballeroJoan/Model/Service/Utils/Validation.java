package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service.Utils;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Domain.Sucursal;

public class Validation {
    public static void validateSucursalDB(Sucursal sucursal){
        if (sucursal == null || sucursal.getNomSucursal() == null || sucursal.getPaisSucursal() == null) {
            throw new IllegalArgumentException("Invalid sucursal data.");
        }
    }

    public static void validateSucursal(Sucursal sucursal){
        if (sucursal == null || sucursal.getPk_SucursalID() == null ||
                sucursal.getNomSucursal() == null || sucursal.getPaisSucursal() == null) {
            throw new IllegalArgumentException("Invalid sucursal data.");
        }
    }
}
