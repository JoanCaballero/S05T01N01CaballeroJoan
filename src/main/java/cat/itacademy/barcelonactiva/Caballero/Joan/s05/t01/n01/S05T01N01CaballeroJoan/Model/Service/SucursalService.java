package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Domain.Sucursal;

import java.util.List;

public interface SucursalService {

    SucursalDTO toSucursalDTO(Sucursal sucursal);
    SucursalDTO createSucursal(SucursalDTO sucursalDTO);
    SucursalDTO updateSucursal(int id, Sucursal sucursal);
    void deleteSucursal(Integer id);
    SucursalDTO getOneSucursal(Integer id);
    Sucursal getSucursalById(Integer id);
    List<SucursalDTO> getAllSucursals();
}
