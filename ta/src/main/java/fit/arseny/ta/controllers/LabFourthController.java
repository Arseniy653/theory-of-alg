package fit.arseny.ta.controllers;

import fit.arseny.ta.models.LabFourth;
import fit.arseny.ta.repo.LabFourthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LabFourthController {

    @Autowired
    private LabFourthRepository labFourthRepository;

    @GetMapping("/lab4")
    public String lab_fourth_main(Model model){
        Iterable<LabFourth> db_lab_fourth = labFourthRepository.findAll();
        model.addAttribute("title", "page for Lab 4");
        model.addAttribute("db_lab_fourth", db_lab_fourth);
        return "lab-fourth-main";
    }

    @GetMapping("/lab4/add")
    public String lab_fourth_add(Model model){
        return "lab-fourth-add";
    }

    @PostMapping("lab4/add")
    public String lab_fourth_post_add(@RequestParam String text){
//        LabSecond tmp = new LabSecond(Float.parseFloat(a),Float.parseFloat(b),Float.parseFloat(c),Float.parseFloat(d));
        LabFourth tmp = new LabFourth(text);

        tmp.setThree_3_letters_sequences();
        tmp.setTotalCountOfWords();
        tmp.setCountUniqueWords();
        tmp.setTop8FrequentWordsByString();
        tmp.setAmountWordsWithCharX();
        tmp.setAmountWordsWith3differerentChars();

        labFourthRepository.save(tmp);
        return "redirect:/lab4";
    }

    @PostMapping("/lab4/{id}/remove")
    public String lab_fourth_post_remove(@PathVariable(value = "id") long id, Module module){
//        LabFourth tmp = labFourthRepository.findById(id).orElseThrow();
//        labFourthRepository.delete(tmp);
        return "redirect:/lab4";
    }

}
