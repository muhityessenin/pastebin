package pet.project.pastebin.services;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import pet.project.pastebin.custom.CustomMultipartFile;
import pet.project.pastebin.models.Paste;
import pet.project.pastebin.repository.PasteRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Service
public class PasteService {
    private final PasteRepository pasteRepository;
    private final S3Service s3Service;

    public PasteService(PasteRepository pasteRepository, S3Service s3Service) {
        this.pasteRepository = pasteRepository;
        this.s3Service = s3Service;
    }

    public void createPaste(Paste paste) throws IOException {
        if(pasteRepository.findByUrl(paste.getUrl()).isPresent()) {
            throw new DataIntegrityViolationException("Paste already exists");
        }
        byte[] bytes = paste.getContent().getBytes();
        paste.setUrl(encode(paste.getId() + paste.getTitle()));
        CustomMultipartFile file = new CustomMultipartFile(bytes, paste.getUrl());
        s3Service.uploadFile(file.getName(), file);
        pasteRepository.save(paste);
    }

    public void deletePaste(Long id) {
        pasteRepository.deleteById(id);
    }

    public Paste getPaste(Long id) {
        return pasteRepository.findById(id).orElse(null);
    }

    public List<Paste> getAllPastes() {
        return pasteRepository.findAll();
    }
    public static String encode(String plaintext){
        String res = Base64.getUrlEncoder().encodeToString(plaintext.getBytes(StandardCharsets.UTF_8));
        System.out.println(res);
        return res;
    }


}
