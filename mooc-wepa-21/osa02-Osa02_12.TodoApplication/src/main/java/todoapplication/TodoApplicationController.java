package todoapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoApplicationController {
    
    @Autowired
    private TaskRepository taskRepository;
    
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", this.taskRepository.findAll());
        return "index";
    }
    
    @PostMapping("/")
    public String postTask(@RequestParam String name) {
        if (name.equals("delete")) {
            this.taskRepository.deleteAllInBatch();
            return "redirect:/";
        } 
        
        if (!name.isEmpty()) {
            this.taskRepository.save(new Task(name));
        }
        
        return "redirect:/";
    }
    
    @GetMapping("/{id}")
    public String getUnique(@PathVariable Long id, Model model) {
        if (!this.taskRepository.existsById(id)) {
            return "redirect:/";
        }
        
        Task task = taskRepository.getOne(id);

        task.addOne();
        taskRepository.save(task);
        
        model.addAttribute("item", task);
        return "todo";
    }     
}
