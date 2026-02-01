package lab.lab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lab.lab6.entity.Category;
import lab.lab6.service.CategoryService;


@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String index(Model model) {
        var categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories/index";
    }

    @GetMapping("/page")
    public String index(Model model, @PageableDefault(size = 2) Pageable pageable) {
        var page = categoryService.getCategoriesPaginated(pageable);
        model.addAttribute("page", page);
        return "categories/page";
    }

    @PostMapping("/create")
    public String create(Model model, Category category) {

        categoryService.createCategory(category);
        var categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        return "categories/index";
    }
}