package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service.Utils;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Domain.Sucursal;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Repository.SucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateCommand {

    //TODO: A chuparla
    private static SucursalRepository sucursalRepository;

    @Autowired
    public UpdateCommand(SucursalRepository sucursalRepository){
        UpdateCommand.sucursalRepository = sucursalRepository;
    }

    public static SucursalDTO updateSucursal(int id, Sucursal sucursal){
        Sucursal oldSucursal = getOldSucursal(id);
        Sucursal newSucursal = updateOldSucursal(oldSucursal, sucursal);
        return Conversion.toSucursalDTO(saveSucursal(newSucursal));
    }

    private static Sucursal getOldSucursal(Integer id){
        Optional<Sucursal> oldSucursal = sucursalRepository.findById(id);
        if(oldSucursal.isPresent()){
            return oldSucursal.get();
        }else{
            throw new EntityNotFoundException("Sucursal with ID: " + id + ". Not found.");
        }
    }

    private static Sucursal updateOldSucursal(Sucursal oldSucursal, Sucursal newSucursal){
        oldSucursal.setNomSucursal(newSucursal.getNomSucursal());
        oldSucursal.setPaisSucursal(newSucursal.getPaisSucursal());
        return oldSucursal;
    }

    private static Sucursal saveSucursal(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }
}
