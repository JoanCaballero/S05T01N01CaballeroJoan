package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Controllers;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Domain.Sucursal;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service.SucursalService;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n01.S05T01N01CaballeroJoan.Model.Service.Utils.Conversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sucursales")
public class SucursalWebController {

    @Autowired
    SucursalService sucursalService;

    @GetMapping({"", "/"})
    public String getAllSucursales(Model model){
        model.addAttribute("sucursales", sucursalService.getAllSucursals());
        return "sucursales";
    }

    @GetMapping("/add")
    public String showAddSucursalForm(Model model) {
        model.addAttribute("sucursalDTO", new SucursalDTO());
        return "sucursal-add";
    }

    @PostMapping("/add")
    public String createSucursal(@ModelAttribute SucursalDTO sucursalDTO) {
        sucursalService.createSucursal(sucursalDTO);
        return "redirect:/sucursales";
    }

    @GetMapping("/update/{id}")
    public String showUpdateSucursalForm(@PathVariable int id, Model model) {
        Sucursal oldSucursal = sucursalService.getSucursalById(id);
        SucursalDTO oldSucursalDTO = Conversion.toSucursalDTO(oldSucursal);
        model.addAttribute("sucursalDTO", oldSucursalDTO);
        return "sucursal-update";
    }

    @PostMapping("/update/{id}")
    public String updateSucursal(@PathVariable int id, @ModelAttribute("sucursalDTO") SucursalDTO sucursal) {
        sucursalService.updateSucursal(id, Conversion.DTOtoSucursal(sucursal));
        return "redirect:/sucursales";
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable int id){
        sucursalService.deleteSucursal(id);
        return "redirect:/sucursales";
    }

    @GetMapping("/search")
    public String getSucursal(@RequestParam String id, Model model){
        try{
            if(id!=null){
                SucursalDTO sucursalDTO = sucursalService.getOneSucursal(Integer.parseInt(id));
                model.addAttribute("sucursales", sucursalDTO);
                return "sucursales";
            } else{
                model.addAttribute("mensaje", "No s'ha especificat cap ID.");
                return "sucursales";
            }
        }catch(Exception e){
            model.addAttribute("mensaje", "No s'ha trobat cap sucursal");
            return "sucursales";
        }
    }

}
