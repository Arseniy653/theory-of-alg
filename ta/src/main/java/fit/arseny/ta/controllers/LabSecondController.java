package fit.arseny.ta.controllers;

import fit.arseny.ta.models.LabSecond;
import fit.arseny.ta.repo.LabSecondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LabSecondController {

    @Autowired
    private LabSecondRepository labSecondRepository;

    @GetMapping("/lab2")
    public String lab_second_main(Model model){

        Iterable<LabSecond> db_lab_second = labSecondRepository.findAll();

        model.addAttribute("title", "page for Lab 2");
        model.addAttribute("db_lab_second", db_lab_second);
        return "lab-second-main";
    }

    @GetMapping("/lab2/add")
    public String lab_second_add(Model model){
        return "lab-second-add";
    }

    @PostMapping("lab2/add")
    public String lab_second_post_add(@RequestParam String a, @RequestParam String b, @RequestParam String c, @RequestParam String d,Model model){
        LabSecond tmp = new LabSecond(Float.parseFloat(a),Float.parseFloat(b),Float.parseFloat(c),Float.parseFloat(d));
        labSecondRepository.save(tmp);
        return "redirect:/lab2";
    }
}
