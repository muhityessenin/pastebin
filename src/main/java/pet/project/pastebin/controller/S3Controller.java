package pet.project.pastebin.controller;

import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pet.project.pastebin.exception.DuplicateUrlException;
import pet.project.pastebin.models.Paste;
import pet.project.pastebin.repository.PasteRepository;
import pet.project.pastebin.services.PasteService;
import pet.project.pastebin.services.S3Service;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Optional;

@Controller
public class S3Controller {

    private final S3Service s3Service;

    private final PasteRepository pasteRepository;

    private final PasteService pasteService;

    public S3Controller(S3Service s3Service, PasteRepository pasteRepository, PasteService pasteService) {
        this.s3Service = s3Service;
        this.pasteRepository = pasteRepository;
        this.pasteService = pasteService;
    }

    @PostMapping( "/create")
    public String upload(Paste paste, Model model) {
        try{
            pasteService.createPaste(paste);
            model.addAttribute("paste", paste);
            return "success";
        }catch (DuplicateUrlException e){
            model.addAttribute("paste", paste);
            return "fail";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/paste/{url}")
    public String getPaste(@PathVariable String url, Model model) throws IOException {
        Optional<Paste> paste = pasteRepository.findByUrl(url);
        S3Object response = s3Service.getFile(url);
        String content;
        try (InputStream inputStream = response.getObjectContent()) {
            byte[] bytes = inputStream.readAllBytes();
            content = new String(bytes, StandardCharsets.UTF_8);
        }
        model.addAttribute("paste", paste);
        model.addAttribute("content", content);
        return "paste";
    }

}
