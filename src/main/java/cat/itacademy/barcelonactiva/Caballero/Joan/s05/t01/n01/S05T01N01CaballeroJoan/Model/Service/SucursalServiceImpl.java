package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Domain.Sucursal;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Repository.SucursalRepository;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service.Utils.Conversion;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service.Utils.UpdateCommand;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service.Utils.Validation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SucursalServiceImpl implements SucursalService{
    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public SucursalDTO toSucursalDTO(Sucursal sucursal) {
        return Conversion.toSucursalDTO(sucursal);
    }

    @Override
    public SucursalDTO createSucursal(SucursalDTO sucursalDTO) {
        Validation.validateSucursalDB(sucursalRepository.save(Conversion.DTOtoSucursal(sucursalDTO)));
        return sucursalDTO;
    }

    @Override
    public SucursalDTO updateSucursal(int id, Sucursal sucursal) {
        return UpdateCommand.updateSucursal(id, sucursal);
    }

    @Override
    public void deleteSucursal(Integer id) {
        sucursalRepository.deleteById(id);
    }

    @Override
    public SucursalDTO getOneSucursal(Integer id) {
        return toSucursalDTO(getSucursalById(id));
    }

    @Override
    public Sucursal getSucursalById(Integer id) {
        return sucursalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sucursal with ID: " + id + ". Not Found."));
    }

    @Override
    public List<SucursalDTO> getAllSucursals() {
        List<Sucursal> sucursals = sucursalRepository.findAll();
        return sucursals.stream().map(this::toSucursalDTO).collect(Collectors.toList());
    }
}
