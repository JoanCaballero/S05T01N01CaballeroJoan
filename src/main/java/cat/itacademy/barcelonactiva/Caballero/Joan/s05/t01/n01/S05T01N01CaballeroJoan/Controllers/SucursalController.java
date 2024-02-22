package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Controllers;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Domain.Sucursal;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service.SucursalService;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service.Utils.Conversion;
import org.hibernate.Remove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/add")
    public ResponseEntity<SucursalDTO> sucursalAdd(@RequestBody Sucursal sucursal){
        return new ResponseEntity<>(sucursalService.createSucursal(Conversion.toSucursalDTO(sucursal)), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SucursalDTO> sucursalUpdate(@PathVariable Integer id, @RequestBody Sucursal sucursal){
        return new ResponseEntity<>(sucursalService.updateSucursal(id, sucursal), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> sucursalDelete(@PathVariable Integer id){
        sucursalService.deleteSucursal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<SucursalDTO> sucursalGetOne(@PathVariable Integer id){
        SucursalDTO sucursalDTO = sucursalService.getOneSucursal(id);
        return new ResponseEntity<>(sucursalDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SucursalDTO>> sucursalGetAll(){
        List<SucursalDTO> sucursals = sucursalService.getAllSucursals();
        return new ResponseEntity<>(sucursals, HttpStatus.OK);
    }
}
