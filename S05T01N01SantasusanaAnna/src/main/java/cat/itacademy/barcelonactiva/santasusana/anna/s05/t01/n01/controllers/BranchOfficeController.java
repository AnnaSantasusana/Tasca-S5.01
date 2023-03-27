package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.dto.BranchOfficeDTO;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.services.IBranchOfficeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;


@Controller
@RequestMapping("/branches")
public class BranchOfficeController {

    @Autowired
    private IBranchOfficeService branchService;

    @GetMapping(value = {"/getAll", "/", ""})
    public String listBranchOffices(Model model) {

        List<BranchOfficeDTO> listBranchesDTO = branchService.listBranchOffices();
        if(!listBranchesDTO.isEmpty()) {
            model.addAttribute("branchOffices", listBranchesDTO);
        }
        return "list";
    }

    @GetMapping("/create")
    public String createBranchOffice(Model model) {
        BranchOfficeDTO branchDTO = new BranchOfficeDTO();
        model.addAttribute("branchOffice", branchDTO);
        return "create";
    }

    @PostMapping("/add")
    public String saveBranchOffice(@Valid @ModelAttribute("branchOffice") BranchOfficeDTO branchDTO,
                                   BindingResult result) {
        if (result.hasFieldErrors()) {
            return "create";
        }
        branchService.saveBranchOffice(branchDTO);
        return "redirect:/branches";
    }

    /**
     * Després en el Thymeleaf utilitzo el mètode saveBranchOffice() per guardar les modificacions fetes en aquest mètode
     */
    @GetMapping("/update/{pk_BranchID}")
    public String updateBranchOffice(@PathVariable("pk_BranchID") int pk_BranchID,
                                     Model model) {

        BranchOfficeDTO branchDTO = branchService.getBranchOfficeDTOById(pk_BranchID);
        model.addAttribute("branchOffice", branchDTO);
        return "edit";
    }

    @GetMapping("/delete/{pk_BranchID}")
    public String deleteBranchOffice(@PathVariable("pk_BranchID") int pk_BranchID) {

        branchService.deleteBranchOffice(pk_BranchID);
        return "redirect:/branches";
    }

    //He tenido que quitar el {pk_BranchID} después del /getOne para que me funcione bien la vista.
    //He hecho un buscador por id en la página principal (lista de branch offices)
    @GetMapping("/getOne")
    public String getBranchOffice(@RequestParam("pk_BranchID") int pk_BranchID,
                                  Model model) {
        if(branchService.existsBranchOfficeById(pk_BranchID)) {
            BranchOfficeDTO branchDTO = branchService.getBranchOfficeDTOById(pk_BranchID);
            model.addAttribute("branchOffice", branchDTO);
            return "details";
        }else{
            return "redirect:/branches";
        }
    }

}
