package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    // @Autowired - 생성자를 이용한 주입은 이 태그가 필요 없음
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""}) // 두 개 이상의 경로를 이렇게 설정할 수 있다
    public String showJoke(Model model){
        model.addAttribute("joke", jokeService.getJoke());

        return "index";
    }
}
