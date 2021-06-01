package fit.arseny.ta.controllers;

import fit.arseny.ta.models.LabThird;
import fit.arseny.ta.repo.LabThirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LabThirdController {

    @Autowired
    private LabThirdRepository labThirdRepository;

    @GetMapping("/lab3")
    public String lab_third_main(Model model){

        Iterable<LabThird> db_lab_third = labThirdRepository.findAll();

        model.addAttribute("title", "page for Lab 3");
        model.addAttribute("db_lab_third", db_lab_third);
        return "lab-third-main";
    }

    @GetMapping("/lab3/add")
    public String lab_third_add(Model model){
        return "lab-third-add";
    }

    @PostMapping("lab3/add")
    public String lab_third_post_add(@RequestParam String number, Model model){
//        LabSecond tmp = new LabSecond(Float.parseFloat(a),Float.parseFloat(b),Float.parseFloat(c),Float.parseFloat(d));
        LabThird tmp = new LabThird(Integer.parseInt(number));
        labThirdRepository.save(tmp);
        return "redirect:/lab3";
    }
}
