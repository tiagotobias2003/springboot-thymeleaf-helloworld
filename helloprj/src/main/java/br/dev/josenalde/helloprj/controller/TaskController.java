package br.dev.josenalde.helloprj.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.dev.josenalde.helloprj.model.Task;

@Controller
public class TaskController {
    //forma de salvar tarefas em memória. Por enquanto não estamos usando BD
    List<Task> taskList = new ArrayList<Task>();
    
    //acessar pela URL a rota
    @GetMapping("/")
    public String home() {
        return "index"; //o nome do arquivo .html se estiver em pasta <folder>/create
    }

    @GetMapping("/create")
    public ModelAndView homeCreate() { //criar tarefa vazia
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("task", new Task());
        return mv;
    }

    @PostMapping("/create")
    public String create(Task task) {
        System.out.println("########################");
        System.out.println(task);
        System.out.println("########################");
        if (task.getId() != null) {
            Task taskFind = taskList.stream().filter(taskItem -> task.getId().equals(task.getId())).findFirst().get();
            taskList.set(taskList.indexOf(taskFind), task);
        } else {
            //definir um ID auto incremental "na mão"
            Long id = taskList.size() + 1L;
            taskList.add(new Task(id, task.getName(), task.getDate()));
        }

        //System.out.println(taskList.size());
        //System.out.println(taskList);
        //após adicionar, redirecionar para visão de listagem de tarefas
        //return "list"; //desta forma redireciona mas não muda a URL para list.html (precisa do get)
        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
    //public String list() {
        //para retornar objetos do backend para o frontend, vamos usar o ModelAndView do Springboot
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("taskList", taskList); //passar lista de objetos para a VIEW //chave:valor
        return mv;
        //return "list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("create");
        Task taskFind = taskList.stream().filter(task -> id.equals(task.getId())).findFirst().get();
        mv.addObject("task", taskFind);
        return mv;
    }
    
}
